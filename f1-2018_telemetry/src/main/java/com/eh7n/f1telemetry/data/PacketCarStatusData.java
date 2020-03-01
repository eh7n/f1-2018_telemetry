package com.eh7n.f1telemetry.data;

import java.util.List;

import com.eh7n.f1telemetry.data.elements.CarStatusData;

public class PacketCarStatusData extends Packet {

	private List<CarStatusData> carStatuses;

	public PacketCarStatusData() {}

	public List<CarStatusData> getCarStatuses() {
		return carStatuses;
	}

	public void setCarStatuses(List<CarStatusData> carStatuses) {
		this.carStatuses = carStatuses;
	}

}
