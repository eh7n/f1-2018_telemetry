package com.eh7n.f1telemetry.data.elements;

public enum SafetyCarStatus {

	NO_SAFETY_CAR,
	FULL_SAFETY_CAR,
	VIRTUAL_SAFETY_CAR;
	
	public static SafetyCarStatus fromInt(int i) {
		switch (i) {
		case 0:
			return SafetyCarStatus.NO_SAFETY_CAR;
		case 1:
			return SafetyCarStatus.FULL_SAFETY_CAR;
		case 2:
			return SafetyCarStatus.VIRTUAL_SAFETY_CAR;
		default:
			return null;
		}
	}
}
