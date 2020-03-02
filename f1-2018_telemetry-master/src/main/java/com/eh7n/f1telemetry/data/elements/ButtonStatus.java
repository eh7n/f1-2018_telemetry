package com.eh7n.f1telemetry.data.elements;

public class ButtonStatus {

	private boolean crossAPressed;
	private boolean triangleYPressed;
	private boolean circleBPressed;
	private boolean squareXPressed;
	private boolean dpadLeftPressed;
	private boolean dpadRightPressed;
	private boolean dpadUpPressed;
	private boolean dpadDownPressed;
	private boolean optionsMenuPressed;
	private boolean L1LBPressed;
	private boolean R1RBPressed;
	private boolean L2LTPressed;
	private boolean R2RTPressed;
	private boolean leftStickPressed;
	private boolean rightStickPressed;
	
	public ButtonStatus() {}

	public boolean isCrossAPressed() {
		return crossAPressed;
	}

	public void setCrossAPressed(boolean crossAPressed) {
		this.crossAPressed = crossAPressed;
	}

	public boolean isTriangleYPressed() {
		return triangleYPressed;
	}

	public void setTriangleYPressed(boolean triangleYPressed) {
		this.triangleYPressed = triangleYPressed;
	}

	public boolean isCircleBPressed() {
		return circleBPressed;
	}

	public void setCircleBPressed(boolean circleBPressed) {
		this.circleBPressed = circleBPressed;
	}

	public boolean isSquareXPressed() {
		return squareXPressed;
	}

	public void setSquareXPressed(boolean squareXPressed) {
		this.squareXPressed = squareXPressed;
	}

	public boolean isDpadLeftPressed() {
		return dpadLeftPressed;
	}

	public void setDpadLeftPressed(boolean dpadLeftPressed) {
		this.dpadLeftPressed = dpadLeftPressed;
	}

	public boolean isDpadRightPressed() {
		return dpadRightPressed;
	}

	public void setDpadRightPressed(boolean dpadRightPressed) {
		this.dpadRightPressed = dpadRightPressed;
	}

	public boolean isDpadUpPressed() {
		return dpadUpPressed;
	}

	public void setDpadUpPressed(boolean dpadUpPressed) {
		this.dpadUpPressed = dpadUpPressed;
	}

	public boolean isDpadDownPressed() {
		return dpadDownPressed;
	}

	public void setDpadDownPressed(boolean dpadDownPressed) {
		this.dpadDownPressed = dpadDownPressed;
	}

	public boolean isOptionsMenuPressed() {
		return optionsMenuPressed;
	}

	public void setOptionsMenuPressed(boolean optionsMenuPressed) {
		this.optionsMenuPressed = optionsMenuPressed;
	}

	public boolean isL1LBPressed() {
		return L1LBPressed;
	}

	public void setL1LBPressed(boolean l1lbPressed) {
		L1LBPressed = l1lbPressed;
	}

	public boolean isR1RBPressed() {
		return R1RBPressed;
	}

	public void setR1RBPressed(boolean r1rbPressed) {
		R1RBPressed = r1rbPressed;
	}

	public boolean isL2LTPressed() {
		return L2LTPressed;
	}

	public void setL2LTPressed(boolean l2ltPressed) {
		L2LTPressed = l2ltPressed;
	}

	public boolean isR2RTPressed() {
		return R2RTPressed;
	}

	public void setR2RTPressed(boolean r2rtPressed) {
		R2RTPressed = r2rtPressed;
	}

	public boolean isLeftStickPressed() {
		return leftStickPressed;
	}

	public void setLeftStickPressed(boolean leftStickPressed) {
		this.leftStickPressed = leftStickPressed;
	}

	public boolean isRightStickPressed() {
		return rightStickPressed;
	}

	public void setRightStickPressed(boolean rightStickPressed) {
		this.rightStickPressed = rightStickPressed;
	}

}
