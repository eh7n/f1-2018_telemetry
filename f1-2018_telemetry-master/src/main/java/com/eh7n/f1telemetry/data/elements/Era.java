package com.eh7n.f1telemetry.data.elements;

public enum Era {

	MODERN,
	CLASSIC;
	
	public static Era fromInt(int i) {
		switch(i) {
			case 0:
				return Era.MODERN;
			case 1:
				return Era.CLASSIC;
			default:
				return null;
		}
	}
}
