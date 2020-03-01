package com.eh7n.f1telemetry.data.elements;

public enum ZoneFlag {
	
	NONE,
	GREEN,
	BLUE,
	YELLOW,
	RED,
	UNKNOWN;
	
	public static ZoneFlag fromInt(int i) {
		switch(i) {
			case 0:
				return ZoneFlag.NONE;
			case 1:
				return ZoneFlag.GREEN;
			case 2:
				return ZoneFlag.BLUE;
			case 3:
				return ZoneFlag.YELLOW;
			case 4:
				return ZoneFlag.RED;
			default:
				return ZoneFlag.UNKNOWN;
		}
	}
}
