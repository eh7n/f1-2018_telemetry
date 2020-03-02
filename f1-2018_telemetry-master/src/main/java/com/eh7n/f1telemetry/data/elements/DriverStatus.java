package com.eh7n.f1telemetry.data.elements;

public enum DriverStatus {

	IN_GARAGE,
	FLYING_LAP,
	IN_LAP,
	OUT_LAP,
	ON_TRACK;
	
	public static DriverStatus fromInt(int i) {
		switch(i) {
			case 0:
				return DriverStatus.IN_GARAGE;
			case 1:
				return DriverStatus.FLYING_LAP;
			case 2:
				return DriverStatus.IN_LAP;
			case 3:
				return DriverStatus.OUT_LAP;
			default:
				return DriverStatus.ON_TRACK;
		}
	}
}
