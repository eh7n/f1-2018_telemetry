package com.eh7n.f1telemetry.data.elements;

public enum Weather {

	CLEAR, 
	LIGHT_CLOUD, 
	OVERCAST, 
	LIGHT_RAIN, 
	HEAVY_RAIN, 
	STORM;

	public static Weather fromInt(int i) {
		switch (i) {
		case 0:
			return Weather.CLEAR;
		case 1:
			return Weather.LIGHT_CLOUD;
		case 2:
			return Weather.OVERCAST;
		case 3:
			return Weather.LIGHT_RAIN;
		case 4:
			return Weather.HEAVY_RAIN;
		default:
			return Weather.STORM;
		}
	}
}
