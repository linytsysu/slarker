package web.models;

import java.io.Serializable;

public class Seat implements Serializable {
	private int logicRow;
	private int logicCol;
	private int seatRow;
	private int seatPew;	// pew for the number of row
	
	public Seat() {}
	public Seat(int logicRow, int logicCol, int seatRow, int seatPew) {
		super();
		this.logicRow = logicRow;
		this.logicCol = logicCol;
		this.seatRow = seatRow;
		this.seatPew = seatPew;
	}
	
	public int getLogicRow() {
		return logicRow;
	}
	public void setLogicRow(int logicRow) {
		this.logicRow = logicRow;
	}
	public int getLogicCol() {
		return logicCol;
	}
	public void setLogicCol(int logicCol) {
		this.logicCol = logicCol;
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatPew() {
		return seatPew;
	}
	public void setSeatPew(int seatPew) {
		this.seatPew = seatPew;
	}
	
}
