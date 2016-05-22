package web.models;

import web.models.Seat;

import java.util.ArrayList;
//import java.util.List;

public class HallSeatStructure {
	private ArrayList<Seat> seats = new ArrayList<Seat>();;
	
	public HallSeatStructure() {}
	
	public void addSeat(Seat seat) {
		seats.add(seat);
	}
}
