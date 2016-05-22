package web.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SceneSeatInfo")
public class SceneSeatInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sceneSeatInfoId")
	private long sceneSeatInfoId;
	
	@Column(name = "seatInfos")
	private List<SeatInfo> seatInfos;

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
	
}
