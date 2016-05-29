package web.models;
import java.io.Serializable;
import javax.persistence.*;

import utils.SlkUtil;
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
	public VideoHall(String videoHallName, HallSeatStructure hallSeatStructure, Cinema cinema) {
		super();
		this.videoHallName = (String) SlkUtil.deepClone(videoHallName);
		this.hallSeatStructure = (HallSeatStructure) SlkUtil.deepClone(hallSeatStructure);
		this.cinema = (Cinema) SlkUtil.deepClone(cinema);
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
		this.hallSeatStructure = (HallSeatStructure) SlkUtil.deepClone(hallSeatStructure);
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = (Cinema) SlkUtil.deepClone(cinema);
	}
}
