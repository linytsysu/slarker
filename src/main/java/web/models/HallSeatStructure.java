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
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 3314206697106092840L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hallSeatStructureId")
	private Long hallSeatStructureId;
	
	@ElementCollection
	@Column(name = "seats")
	private List<Seat> seats;
	
	public HallSeatStructure() {}
	
	public HallSeatStructure(List<Seat> seats) {
		// TODO Auto-generated constructor stub
		this.seats = seats;
	}

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
