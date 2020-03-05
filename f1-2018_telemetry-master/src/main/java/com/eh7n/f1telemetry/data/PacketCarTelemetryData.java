package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.ButtonStatus;
import com.eh7n.f1telemetry.data.elements.CarTelemetryData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketCarTelemetryData extends Packet {

	//add here
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

@Override
	public void demo(){
		//CarTelemetryData ctd = null;
		//int i = 0;
		float brake =carTelemetryData.get(getHeader().getPlayerCarIndex()).getBrake();//刹车
		float clutch =carTelemetryData.get(getHeader().getPlayerCarIndex()).getClutch();
		float throttle =carTelemetryData.get(getHeader().getPlayerCarIndex()).getThrottle();
		float speed =carTelemetryData.get(getHeader().getPlayerCarIndex()).getSpeed();

		float gear =carTelemetryData.get(getHeader().getPlayerCarIndex()).getGear();

		log.trace("speed: "+speed+"\n"+"Brake: "+brake+"\n"+"Throttle: "+throttle+"\n"+"Clutch: "+clutch+"\n"+"Gear: "+gear+"\n");
	}

}
