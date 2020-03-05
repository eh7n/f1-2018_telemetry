package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarMotionData;
import com.eh7n.f1telemetry.data.elements.WheelData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketMotionData extends Packet {
	//add

	private static final Logger log = LoggerFactory.getLogger(PacketMotionData.class);
	byte LED_direction;
	float f_WheelsAngle;
	
	private List<CarMotionData> carMotionDataList;
	private WheelData<Float> suspensionPosition;
	private WheelData<Float> suspensionVelocity;
	private WheelData<Float> suspensionAcceleration;
	private WheelData<Float> wheelSpeed;
	private WheelData<Float> wheelSlip;
	private float localVelocityX;
	private float localVelocityY;
	private float localVelocityZ;
	private float angularVelocityX;
	private float angularVelocityY;
	private float angularVelocityZ;
	private float angularAccelerationX;
	private float angularAccelerationY;
	private float angularAccelerationZ;
	private float frontWheelsAngle;

	public PacketMotionData() {}

	public List<CarMotionData> getCarMotionDataList() {
		return carMotionDataList;
	}

	public void setCarMotionDataList(List<CarMotionData> carMotionDataList) {
		this.carMotionDataList = carMotionDataList;
	}

	public WheelData<Float> getSuspensionPosition() {
		return suspensionPosition;
	}

	public void setSuspensionPosition(WheelData<Float> suspensionPosition) {
		this.suspensionPosition = suspensionPosition;
	}

	public WheelData<Float> getSuspensionVelocity() {
		return suspensionVelocity;
	}

	public void setSuspensionVelocity(WheelData<Float> suspensionVelocity) {
		this.suspensionVelocity = suspensionVelocity;
	}

	public WheelData<Float> getSuspensionAcceleration() {
		return suspensionAcceleration;
	}

	public void setSuspensionAcceleration(WheelData<Float> suspensionAcceleration) {
		this.suspensionAcceleration = suspensionAcceleration;
	}

	public WheelData<Float> getWheelSpeed() {
		return wheelSpeed;
	}

	public void setWheelSpeed(WheelData<Float> wheelSpeed) {
		this.wheelSpeed = wheelSpeed;
	}

	public WheelData<Float> getWheelSlip() {
		return wheelSlip;
	}

	public void setWheelSlip(WheelData<Float> wheelSlip) {
		this.wheelSlip = wheelSlip;
	}

	public float getLocalVelocityX() {
		return localVelocityX;
	}

	public void setLocalVelocityX(float localVelocityX) {
		this.localVelocityX = localVelocityX;
	}

	public float getLocalVelocityY() {
		return localVelocityY;
	}

	public void setLocalVelocityY(float localVelocityY) {
		this.localVelocityY = localVelocityY;
	}

	public float getLocalVelocityZ() {
		return localVelocityZ;
	}

	public void setLocalVelocityZ(float localVelocityZ) {
		this.localVelocityZ = localVelocityZ;
	}

	public float getAngularVelocityX() {
		return angularVelocityX;
	}

	public void setAngularVelocityX(float angularVelocityX) {
		this.angularVelocityX = angularVelocityX;
	}

	public float getAngularVelocityY() {
		return angularVelocityY;
	}

	public void setAngularVelocityY(float angularVelocityY) {
		this.angularVelocityY = angularVelocityY;
	}

	public float getAngularVelocityZ() {
		return angularVelocityZ;
	}

	public void setAngularVelocityZ(float angularVelocityZ) {
		this.angularVelocityZ = angularVelocityZ;
	}

	public float getAngularAccelerationX() {
		return angularAccelerationX;
	}

	public void setAngularAccelerationX(float angularAccelerationX) {
		this.angularAccelerationX = angularAccelerationX;
	}

	public float getAngularAccelerationY() {
		return angularAccelerationY;
	}

	public void setAngularAccelerationY(float angularAccelerationY) {
		this.angularAccelerationY = angularAccelerationY;
	}

	public float getAngularAccelerationZ() {
		return angularAccelerationZ;
	}

	public void setAngularAccelerationZ(float angularAccelerationZ) {
		this.angularAccelerationZ = angularAccelerationZ;
	}

	public float getFrontWheelsAngle() {
		return frontWheelsAngle;
	}

	public void setFrontWheelsAngle(float frontWheelsAngle) {
		this.frontWheelsAngle = frontWheelsAngle;
	}
	@Override
	public void demo(){
		//CarTelemetryData ctd = null;
		//int i = 0;

		f_WheelsAngle = getFrontWheelsAngle();

		//log.trace("speed: "+speed+"\n"+"Brake: "+brake+"\n"+"Throttle: "+throttle+"\n"+"Clutch: "+clutch+"\n"+"Gear: "+gear+"\n");
		log.trace("FrontWheelsAngle: "+ f_WheelsAngle);
	}
	@Override
	public byte convert_direction_to_byte(){
		if(f_WheelsAngle<0)
		{
			LED_direction = 2;
		}
		else if(f_WheelsAngle>0)
		{
			LED_direction = 1;
		}
		else if(f_WheelsAngle==0)
		{
			LED_direction = 0;
		}
		String binaryString_LED_direction = Integer.toBinaryString(LED_direction);
		System.out.println("binaryString_LED_direction = " + binaryString_LED_direction);
		return LED_direction;
	}


}
