package com.eh7n.f1telemetry.data.elements;

import java.math.BigInteger;

public class Header {
	
	private int packetFormat;
	private long packetVersion;
	private int packetId;
	private BigInteger sessionUID;
	private float sessionTime;
	private long frameIdentifier;
	private int playerCarIndex;
	
	public Header() {}

	public int getPacketFormat() {
		return packetFormat;
	}
	
	public void setPacketFormat(int packetFormat) {
		this.packetFormat = packetFormat;
	}
	
	public long getPacketVersion() {
		return packetVersion;
	}
	
	public void setPacketVersion(long packetVersion) {
		this.packetVersion = packetVersion;
	}
	
	public int getPacketId() {
		return packetId;
	}
	
	public void setPacketId(int packetId) {
		this.packetId = packetId;
	}
	
	public BigInteger getSessionUID() {
		return sessionUID;
	}
	
	public void setSessionUID(BigInteger sessionUID) {
		this.sessionUID = sessionUID;
	}
	
	public float getSessionTime() {
		return sessionTime;
	}
	
	public void setSessionTime(float sessionTime) {
		this.sessionTime = sessionTime;
	}
	
	public long getFrameIdentifier() {
		return frameIdentifier;
	}
	
	public void setFrameIdentifier(long frameIdentifier) {
		this.frameIdentifier = frameIdentifier;
	}
	
	public int getPlayerCarIndex() {
		return playerCarIndex;
	}
	
	public void setPlayerCarIndex(int playerCarIndex) {
		this.playerCarIndex = playerCarIndex;
	}
	
	@Override
	public String toString() {
		return "Header :: packetFormat:" + this.getPacketFormat() + 
		", version:" + this.getPacketVersion() +
		", packetId:" + this.getPacketId() + 
		", sessionUID:" + this.getSessionUID() + 
		", sessionTime:" + this.getSessionTime() +
		", frameIdentifier:" + this.getFrameIdentifier() +
		", playerCarIndex:" + this.getPlayerCarIndex();
	}
}
