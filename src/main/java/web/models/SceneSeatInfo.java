package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "SceneSeatInfo")
public class SceneSeatInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6499777864815854777L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sceneSeatInfoId")
	private long sceneSeatInfoId;
	
	@ElementCollection
	@Column(name = "seatInfos", length=1000)
	private List<SeatInfo> seatInfos;

	public SceneSeatInfo(HallSeatStructure hallSeatStructure) {
		// TODO Auto-generated constructor stub
		List<Seat> seats = hallSeatStructure.getSeats();
		seatInfos = new ArrayList<SeatInfo>();
		for (Seat seat : seats) {
			SeatInfo seatInfo = new SeatInfo(seat);
			seatInfos.add(seatInfo);
		}
		System.out.println(this.seatInfos.size());
	}

	public long getSceneSeatInfoId() {
		return sceneSeatInfoId;
	}

	public void setSceneSeatInfoId(long sceneSeatInfoId) {
		this.sceneSeatInfoId = sceneSeatInfoId;
	}

	public List<SeatInfo> getSeatInfos() {
		return seatInfos;
	}

	public void setSeatInfos(List<SeatInfo> seatInfos) {
		this.seatInfos = seatInfos;
	}

	public List<SeatInfo> getAvailSeatRandom(double probability) {
		// TODO Auto-generated method stub
		List<SeatInfo> rst_seat_infos = new ArrayList<SeatInfo>();
		for (SeatInfo seat : this.seatInfos) {
			if (!seat.isAvail()) continue;
			double r = Math.random();
			if (r > probability) continue;
			rst_seat_infos.add(seat);
		}
		return rst_seat_infos;
	}
	
}
