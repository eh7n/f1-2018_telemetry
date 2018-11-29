package com.eh7n.f1telemetry.data.elements;

public enum SessionType {

	UNKNOWN,
	P1,
	P2,
	P3,
	SHORT_P,
	Q1,
	Q2,
	Q3,
	SHORT_Q,
	OSQ,
	R,
	R2,
	TIME_TRIAL;

	public static SessionType fromInt(int i) {
		switch(i) {
			case 0:
				return SessionType.UNKNOWN;
			case 1:
				return SessionType.P1;
			case 2:
				return SessionType.P2;
			case 3:
				return SessionType.P3;
			case 4:
				return SessionType.SHORT_P;
			case 5:
				return SessionType.Q1;
			case 6:
				return SessionType.Q2;
			case 7:
				return SessionType.Q3;
			case 8:
				return SessionType.SHORT_Q;
			case 9:
				return SessionType.OSQ;
			case 10:
				return SessionType.R;
			case 11:
				return SessionType.R2;
			case 12:
				return SessionType.TIME_TRIAL;
			default:
				return null;
		}
	}
	
}
