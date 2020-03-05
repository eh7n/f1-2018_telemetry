package com.eh7n.f1telemetry.data;

import com.eh7n.f1telemetry.data.elements.Header;
import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class Packet {
	
	private Header header;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);
		}catch(Exception e) {
			//TODO: Handle this exception
		}
		return json;
	}

	public void demo(){

	}
	public byte convert_brake_to_byte(){
		return 0;
	}
	public byte convert_throttle_to_byte(){
		return 0;
	}
	public byte convert_direction_to_byte(){
		return 0;
	}
}
