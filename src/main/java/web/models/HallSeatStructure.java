package web.models;

import web.models.Seat;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "HallSeatStructure")
public class HallSeatStructure implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hallSeatStructureId")
	private Long hallSeatStructureId;
	
	@Column(name = "Seats")
	private ArrayList<Seat> seats = new ArrayList<Seat>();;
	
	public HallSeatStructure() {}
	
	public void addSeat(Seat seat) {
		seats.add(seat);
	}

	public Long getHallSeatStructureId() {
		return hallSeatStructureId;
	}

	public void setHallSeatStructureId(Long hallSeatStructureId) {
		this.hallSeatStructureId = hallSeatStructureId;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
}
