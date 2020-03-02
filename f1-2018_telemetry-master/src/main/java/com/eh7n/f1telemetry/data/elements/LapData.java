package com.eh7n.f1telemetry.data.elements;

public class LapData {
	
	private float carIndex;
	private boolean playersCar;
	private float lastLapTime;
	private float currentLapTime;
	private float bestLaptTime;
	private float sector1Time;
	private float sector2Time;
	private float lapDistance;
	private float totalDistance;
	private float safetyCarDelta;
	private int carPosition;
	private int currentLapNum;
	private PitStatus pitStatus;
	private int sector;
	private boolean currentLapInvalid;
	private int penalties;
	private int gridPosition;
	private DriverStatus driverStatus;
	private ResultStatus resultStatus;
	
	public LapData() {}

	public float getCarIndex() {
		return carIndex;
	}
	public void setCarIndex(float carIndex) {
		this.carIndex = carIndex;
	}
	public boolean isPlayersCar() {
		return playersCar;
	}
	public void setPlayersCar(boolean playersCar) {
		this.playersCar = playersCar;
	}
	public float getLastLapTime() {
		return lastLapTime;
	}
	public void setLastLapTime(float lastLapTime) {
		this.lastLapTime = lastLapTime;
	}
	public float getCurrentLapTime() {
		return currentLapTime;
	}
	public void setCurrentLapTime(float currentLapTime) {
		this.currentLapTime = currentLapTime;
	}
	public float getBestLaptTime() {
		return bestLaptTime;
	}
	public void setBestLaptTime(float bestLaptTime) {
		this.bestLaptTime = bestLaptTime;
	}
	public float getSector1Time() {
		return sector1Time;
	}
	public void setSector1Time(float sector1Time) {
		this.sector1Time = sector1Time;
	}
	public float getSector2Time() {
		return sector2Time;
	}
	public void setSector2Time(float sector2Time) {
		this.sector2Time = sector2Time;
	}
	public float getLapDistance() {
		return lapDistance;
	}
	public void setLapDistance(float lapDistance) {
		this.lapDistance = lapDistance;
	}
	public float getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(float totalDistance) {
		this.totalDistance = totalDistance;
	}
	public float getSafetyCarDelta() {
		return safetyCarDelta;
	}
	public void setSafetyCarDelta(float safetyCarDelta) {
		this.safetyCarDelta = safetyCarDelta;
	}
	public int getCarPosition() {
		return carPosition;
	}
	public void setCarPosition(int carPosition) {
		this.carPosition = carPosition;
	}
	public int getCurrentLapNum() {
		return currentLapNum;
	}
	public void setCurrentLapNum(int currentLapNum) {
		this.currentLapNum = currentLapNum;
	}
	public PitStatus getPitStatus() {
		return pitStatus;
	}
	public void setPitStatus(PitStatus pitStatus) {
		this.pitStatus = pitStatus;
	}
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public boolean isCurrentLapInvalid() {
		return currentLapInvalid;
	}
	public void setCurrentLapInvalid(boolean currentLapInvalid) {
		this.currentLapInvalid = currentLapInvalid;
	}
	public int getPenalties() {
		return penalties;
	}
	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	public int getGridPosition() {
		return gridPosition;
	}
	public void setGridPosition(int gridPosition) {
		this.gridPosition = gridPosition;
	}
	public DriverStatus getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(DriverStatus driverStatus) {
		this.driverStatus = driverStatus;
	}
	public ResultStatus getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}
	
}
