package com.eh7n.f1telemetry.data.elements;

public enum ResultStatus {

	INVALID,
	INACTIVE,
	ACTIVE,
	FINISHED,
	DISQUALIFIED,
	NOT_CLASSIFIED,
	RETIRED;
	
	public static ResultStatus fromInt(int i) {
		switch(i) {
			case 0:
				return ResultStatus.INVALID;
			case 1:
				return ResultStatus.INACTIVE;
			case 2:
				return ResultStatus.ACTIVE;
			case 3:
				return ResultStatus.FINISHED;
			case 4:
				return ResultStatus.DISQUALIFIED;
			case 5:
				return ResultStatus.NOT_CLASSIFIED;
			case 6:
				return ResultStatus.RETIRED;
			default:
				return null;
		}
	}
}
