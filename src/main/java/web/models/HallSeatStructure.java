package web.models;

import web.models.Seat;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "HallSeatStructure")
public class HallSeatStructure implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hallSeatStructureId")
	private Long hallSeatStructureId;
	
	@Column(name = "Seats")
	private List<Seat> seats = new ArrayList<Seat>();;
	
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

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
