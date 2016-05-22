package web.models;

import java.io.Serializable;

import web.models.Seat;

public class SeatInfo extends Seat implements Serializable {
	public enum Status{OPTIONAL, OPTIONED, NOT_OPTIONAL, MAINTAINING;}
	
	private Status status;
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
}
