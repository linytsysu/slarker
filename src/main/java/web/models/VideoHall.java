package web.models;
import java.io.Serializable;
import javax.persistence.*;

import web.models.HallSeatStructure;

@Entity
@Table(name = "VideoHall")
public class VideoHall implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7142566708612749482L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="videoHallId")
	private Long videoHallId;
	
	@Column(name="videoHallName")
	private String videoHallName;
	
	@OneToOne
	@JoinColumn(name = "hallSeatStructureId")
	private HallSeatStructure hallSeatStructure;
	
	@ManyToOne
	@JoinColumn(name = "cinemaId")
	private Cinema cinema;

	public VideoHall() {}
	public VideoHall(String videoHallName, HallSeatStructure hallSeatStructure, Cinema cinema) {
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
