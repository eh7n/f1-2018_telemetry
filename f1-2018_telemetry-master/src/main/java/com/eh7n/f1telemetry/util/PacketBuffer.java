package com.eh7n.f1telemetry.util;

import java.math.BigInteger;

/**
 * A wrapper for the byte array to make deserializing the data easier.
 * 
 * This class provides a way to traverse the byte array while converting native
 * C data types into Java equivalents. In many cases, the Java data types used
 * are not the most efficient, but were chosen for simplicity (int, for example,
 * is the basis for all non-floating point numbers unless a larger value is
 * needed.)
 * 
 * 
 * @author eh7n
 *
 */
public class PacketBuffer {

	private final byte[] ba;
	private int i;

	private PacketBuffer(byte[] array) {
		this.ba = array;
		this.i = 0;
	}

	/**
	 * Wrap the byte array for processing
	 * 
	 * @param array
	 * @return the wrapper
	 */
	public static PacketBuffer wrap(byte[] array) {
		return new PacketBuffer(array);
	}

	/**
	 * Gets the next set of bytes based on the input size
	 * 
	 * @param size - how many bytes to return
	 * @return the next byte[] based on the current position and the requested size
	 */
	public byte[] getNextBytes(int size) {
		byte[] next = new byte[size];
		int j = 0;
		while (j < size) {
			next[j++] = ba[i++];
		}
		return next;
	}

	/**
	 * Gets and converts the next byte from an unsigned 8bit int to a signed int
	 * 
	 * @return the next C uint8 in the byte buffer as a Java int
	 */
	public int getNextUInt8AsInt() {
		return ba[i++] & 0xFF;
	}

	/**
	 * Gets and converts the next byte from an unsigned 8bit int to a boolean
	 * 
	 * @return the next C uint8 in the byte buffer as a Java boolean
	 */
	public boolean getNextUInt8AsBoolean() {
		return 1 == (ba[i++] & 0xFF);
	}

	/**
	 * Gets and converts the next two bytes from an unsigned 16bit int to an signed
	 * int
	 * 
	 * @return the next C uint16 in the byte buffer as a Java int
	 */
	public int getNextUInt16AsInt() {
		return (ba[i++] & 0xFF) | ((ba[i++] & 0xFF) << 8);
	}

	/**
	 * Gets and converts the next 4 bytes from an unsigned 32bit int to a signed
	 * long
	 * 
	 * @return the next C uint in the byte buffer as a Java long
	 */
	public long getNextUIntAsLong() {
		return (ba[i++] & 0xFF) | ((ba[i++] & 0xFF) << 8) | ((ba[i++] & 0xFF) << 16) | ((ba[i++] & 0xFF) << 24);
	}

	/**
	 * Gets the next byte as a 16bit int, no conversion necessary
	 * 
	 * @return the next C int8 (byte) as Java int
	 */
	public int getNextInt8AsInt() {
		return ba[i++];
	}

	/**
	 * Gets and converts the next 8 bytes from an unsigned 64bit int to a BigInteger
	 * 
	 * @return the next C uint64 in the byte buffer as a Java BigInteger
	 */
	public BigInteger getNextUInt64AsBigInteger() {
		byte[] uint64 = getNextBytes(8);
		return new BigInteger(1, uint64);
	}

	/**
	 * Gets and converts the next 32bits as a float
	 * 
	 * @return the next C float as a Java float
	 */
	public float getNextFloat() {
		int floatAsInt = (ba[i++] & 0xFF) | ((ba[i++] & 0xFF) << 8) | ((ba[i++] & 0xFF) << 16)
				| ((ba[i++] & 0xFF) << 24);
		return Float.intBitsToFloat(floatAsInt);
	}

	/**
	 * Invokes getNextFloat() against the array n number of times, where n is the
	 * parameter passed in. It will traverse the byte array 4 * n bytes
	 * 
	 * @param count the number (n) of floats in the array
	 * @return the next array of C floats as a Java float[]
	 */
	public Float[] getNextFloatArray(int count) {
		Float[] floats = new Float[count];
		for (int k = 0; k < count; k++) {
			floats[k] = getNextFloat();
		}
		return floats;
	}
	
	/**
	 * Invokes getNextUInt8AsInt() against the array n number of times, where n is
	 * the parameter passed in. It will traverse the byte array n bytes
	 * 
	 * @param count the number (n) of ints in the array
	 * @return the next array of C ints as a Java int[]
	 */
	public Integer[] getNextUInt8ArrayAsIntegerArray(int count) {
		Integer[] ints = new Integer[count];
		for (int k = 0; k < count; k++) {
			ints[k] = getNextUInt8AsInt();
		}
		return ints;
	}
	
	/**
	 * Invokes getNextUInt16AsInt() against the array n number of times, where n is
	 * the parameter passed in. It will traverse the byte array 2 * n bytes
	 * 
	 * @param count the number (n) of ints in the array
	 * @return the next array of C ints as a Java int[]
	 */
	public Integer[] getNextUInt16ArrayAsIntegerArray(int count) {
		Integer[] ints = new Integer[count];
		for (int k = 0; k < count; k++) {
			ints[k] = getNextUInt16AsInt();
		}
		return ints;
	}

	/**
	 * Gets and converts the next series of bytes (n) from their unsigned integer
	 * value to a Java char, compiling them into a char array and returning them as
	 * a String. Can also handle null terminated strings, in theory
	 * 
	 * @param count the number (n) of chars in the array
	 * @return the next array of C unit8s as a String
	 */
	public String getNextCharArrayAsString(int count) {
		char[] charArr = new char[count];
		boolean reachedEnd = false;
		for (int k = 0; k < count; k++) {
			char curr = (char) ba[i++];
			if(curr == '\u0000') {
				reachedEnd = true;
			}else if (!reachedEnd) {
				charArr[k] = curr;
			}
		}
		return new String(charArr);

	}

	/**
	 * Get the current position of the index in the array
	 * 
	 * @return the current position of the buffer
	 */
	public int getCurrentPosition() {
		return i;
	}

	/**
	 * The size of the underlying byte array
	 * 
	 * @return the size of the wrapped byte[]
	 */
	public int getSize() {
		return ba.length;
	}

	/**
	 * Returns whether or not there are still more bytes to traverse
	 * 
	 * @return true if there is another byte in the array
	 */
	public boolean hasNext() {
		return i < (ba.length - 1);
	}

}
