package web.models;
import java.io.Serializable;
import javax.persistence.*;

import web.models.HallSeatStructure;

@Entity
@Table(name = "VideoHall")
public class VideoHall implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="videoHallId")
	private Long videoHallId;
	
	@Column(name="videoHallName")
	private String videoHallName;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "hallSeatStructureId")
	private HallSeatStructure hallSeatStructure;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinemaId")
	private Cinema cinema;

	public VideoHall() {}
	public VideoHall(Long videoHallId, String videoHallName, HallSeatStructure hallSeatStructure, Cinema cinema) {
		super();
		this.videoHallName = videoHallName;
		this.hallSeatStructure = hallSeatStructure;
		this.cinema = cinema;
	}
	
	public Long getVideoHallId() {
		return videoHallId;
	}

	public void setVideoHallId(Long videoHallId) {
		this.videoHallId = videoHallId;
	}

	public String getVoideHallName() {
		return videoHallName;
	}

	public void setVoideHallName(String voideHallName) {
		this.videoHallName = voideHallName;
	}

	public HallSeatStructure getHallSeatStructure() {
		return hallSeatStructure;
	}

	public void setHallSeatStructure(HallSeatStructure hallSeatStructure) {
		this.hallSeatStructure = hallSeatStructure;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}
