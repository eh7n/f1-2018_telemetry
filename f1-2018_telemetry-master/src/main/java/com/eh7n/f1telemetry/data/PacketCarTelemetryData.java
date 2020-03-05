package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketCarTelemetryData extends Packet {

	//add here
	float brake = 0;

	float throttle = 0;

	byte LED_brake;
	byte LED_throttle;

	private static final Logger log = LoggerFactory.getLogger(PacketCarTelemetryData.class);
	
	private List<CarTelemetryData> carTelemetryData;
	private ButtonStatus buttonStatus; // TODO, create a representation of this data properly
	
	public PacketCarTelemetryData() {}
	
	public List<CarTelemetryData> getCarTelemetryData() {
		return carTelemetryData;
	}
	public void setCarTelemetryData(List<CarTelemetryData> carTelemetryData) {
		this.carTelemetryData = carTelemetryData;
	}

	public ButtonStatus getButtonStatus() {
		return buttonStatus;
	}

	public void setButtonStatus(ButtonStatus buttonStatus) {
		this.buttonStatus = buttonStatus;
	}

	public static String byteToBit(byte b) {
		return ""
				+ (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
				+ (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
				+ (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}
@Override
	public void demo(){
		//CarTelemetryData ctd = null;
		//int i = 0;
		brake =carTelemetryData.get(getHeader().getPlayerCarIndex()).getBrake();//刹车
		float clutch =carTelemetryData.get(getHeader().getPlayerCarIndex()).getClutch();
		throttle =carTelemetryData.get(getHeader().getPlayerCarIndex()).getThrottle();
		float speed =carTelemetryData.get(getHeader().getPlayerCarIndex()).getSpeed();

		float gear =carTelemetryData.get(getHeader().getPlayerCarIndex()).getGear();

		log.trace("speed: "+speed+"\n"+"Brake: "+brake+"\n"+"Throttle: "+throttle+"\n"+"Clutch: "+clutch+"\n"+"Gear: "+gear+"\n");
	}

	@Override
	public byte convert_brake_to_byte()
	{

	if(brake==0){
		LED_brake = 0;
	}
	else if(brake>0&&brake<=12.5){
		LED_brake = 1;
	}
	else if(brake>12.5&&brake<=25){
		LED_brake = 3;
	}
	else if(brake>25&&brake<=37.5){
		LED_brake = 7;
	}
	else if(brake>37.5&&brake<=50){
		LED_brake = 15;
	}
	else if(brake>50&&brake<=62.5){
		LED_brake = 31;
	}
	else if(brake>62.5&&brake<=75){
		LED_brake = 63;
	}
	else if(brake>75&&brake<=87.5){
		LED_brake = 127;
	}
	else if(brake>87&&brake<=100){
		LED_brake = -1;
	}

	String binaryString_LED_brake = byteToBit(LED_brake);
	System.out.println("binaryString_LED_brake = " + binaryString_LED_brake);

	return LED_brake;
	}

	@Override
	public byte convert_throttle_to_byte(){

		if(throttle==0){
			LED_throttle = 0;
		}
		else if(throttle>0&&throttle<=12.5){
			LED_throttle = 1;
		}
		else if(throttle>12.5&&throttle<=25){
			LED_throttle = 3;
		}
		else if(throttle>25&&throttle<=37.5){
			LED_throttle = 7;
		}
		else if(throttle>37.5&&throttle<=50){
			LED_throttle = 15;
		}
		else if(throttle>50&&throttle<=62.5){
			LED_throttle = 31;
		}
		else if(throttle>62.5&&throttle<=75){
			LED_throttle = 63;
		}
		else if(throttle>75&&throttle<=87.5){
			LED_throttle =127;
		}
		else if(throttle>87&&throttle<=100){
			LED_throttle = -1;
		}

		String binaryString_LED_throttle = byteToBit(LED_throttle);
		System.out.println("binaryString_LED_throttle = " + binaryString_LED_throttle);

		return LED_throttle;
	}

}
