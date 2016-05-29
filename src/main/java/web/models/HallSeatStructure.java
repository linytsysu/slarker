package web.models;

import web.models.Seat;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.persistence.*;

import utils.SlkUtil;

@Entity
@Table(name = "HallSeatStructure")
public class HallSeatStructure implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hallSeatStructureId")
	private Long hallSeatStructureId;
	
	@ElementCollection
	@Column(name = "Seats")
	private List<Seat> seats;
	
	public HallSeatStructure() {}
	
	@SuppressWarnings("unchecked")
	public HallSeatStructure(List<Seat> seats) {
		// TODO Auto-generated constructor stub
		this.seats = (List<Seat>)SlkUtil.deepClone(seats);
	}

	public void addSeat(Seat seat) {
		seats.add((Seat) SlkUtil.deepClone(seat));
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

	@SuppressWarnings("unchecked")
	public void setSeats(List<Seat> seats) {
		this.seats = (List<Seat>)SlkUtil.deepClone(seats);
	}
}
