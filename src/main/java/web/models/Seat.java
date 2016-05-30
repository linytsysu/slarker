package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8705772480859972653L;
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
	
	// method for add data
	public static List<Seat> getSeatListRandom(int row, int col, double probability) {
		List<Seat> seats = new ArrayList<Seat>();
		for (int r = 1; r <= row; ++r) {
			int cc = 1;
			for (int c = 1; c <= col; ++c) {
				double rd = Math.random();
				if (rd > probability) continue;
				Seat seat = new Seat(r, c, r, cc);
				seats.add(seat);
				++cc;
			}
		}
		return seats;
	}
	
	
}
