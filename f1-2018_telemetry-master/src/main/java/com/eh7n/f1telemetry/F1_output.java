package com.eh7n.f1telemetry;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eh7n.f1telemetry.data.Packet;
import com.eh7n.f1telemetry.util.PacketDeserializer;

/**
 * The base class for the F1 2018 Telemetry app. Starts up a non-blocking I/O
 * UDP server to read packets from the F1 2018 video game and then hands those
 * packets off to a parallel thread for processing based on the lambda function
 * defined. Leverages a fluent API for initialization.
 *
 * Also exposes a main method for starting up a default server
 *
 * @author eh7n
 *
 */
public class F1_output {

    private static final Logger log = LoggerFactory.getLogger(F1_output.class);

    private static final String DEFAULT_BIND_ADDRESS = "0.0.0.0";
    private static final int DEFAULT_PORT = 20777;
    private static final int MAX_PACKET_SIZE = 1341;

    private String bindAddress;
    private int port;
    private Consumer<Packet> packetConsumer;

    private F1_output() {
        bindAddress = DEFAULT_BIND_ADDRESS; // if not bindTO, then the bindAddress is default
        port = DEFAULT_PORT;
    }

    /**
     * Create an instance of the UDP server
     *
     * @return
     */
    public static F1_output create() {
        return new F1_output();
    }

    /**
     * Set the bind address
     *
     * @param bindAddress
     * @return the server instance
     */
    public F1_output bindTo(String bindAddress) {
        this.bindAddress = bindAddress;
        return this;
    }

    /**
     * Set the bind port
     *
     * @param port
     * @return the server instance
     */
    public F1_output onPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Set the consumer via a lambda function
     *
     * @param consumer
     * @return the server instance
     */
    public F1_output consumeWith(Consumer<Packet> consumer) {
        packetConsumer = consumer;
        return this;
    }

    /**
     * Start the F1 2018 Telemetry UDP server
     *
     * @throws IOException           if the server fails to start
     * @throws IllegalStateException if you do not define how the packets should be
     *                               consumed
     */
    public void start() throws IOException {

        if (packetConsumer == null) {
            throw new IllegalStateException("You must define how the packets will be consumed.");
        }

        log.info("F1 2018 - Telemetry UDP Server");

        // Create an executor to process the Packets in a separate thread
        // To be honest, this is probably an over-optimization due to the use of NIO,
        // but it was done to provide a simple way of providing back pressure on the
        // incoming UDP packet handling to allow for long-running processing of the
        // Packet object, if required.
        ExecutorService executor = Executors.newSingleThreadExecutor();//in a separate thread

        // the print format is
        //17:14:43.249 [pool-1-thread-1] TRACE c.e.f.F12018TelemetryUDPServer - {"header":{"packetFormat":2018,"packetVersion":1,"packetId":2,"sessionUID":17024013698017524279,"sessionTime":164.88759,"frameIdentifier":7462,"playerCarIndex":0},"

        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.socket().bind(new InetSocketAddress(bindAddress, port));
            log.info("Listening on " + bindAddress + ":" + port + "...");//begin to print
            ByteBuffer buf = ByteBuffer.allocate(MAX_PACKET_SIZE);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            while (true) {
                channel.receive(buf);
                final Packet packet = PacketDeserializer.read(buf.array());
                executor.submit(() -> {
                    packetConsumer.accept(packet);
                });
                buf.clear();
            }
        } finally {
            executor.shutdown();
        }
    }

    /**
     * Main class in case you want to run the server independently. Uses defaults
     * for bind address and port, and just logs the incoming packets as a JSON
     * object to the location defined in the logback config
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        F12018TelemetryUDPServer.create()
                .bindTo("0.0.0.0")
                .onPort(20777)
                .consumeWith((p) -> {
                    p.demo();
                    p.convert_brake_to_byte();
                    p.convert_throttle_to_byte();
                    p.convert_direction_to_byte();

                    //log.trace(p.toJSON());
                    // toJSON is a string
                    //json = "";
                    //json = mapper.writeValueAsString(this);//this is packet
                    //it just print the packet(because it needs to be converted to string first)
                })
                .start();
    }
}
