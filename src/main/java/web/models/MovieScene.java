package web.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MovieScene")
public class MovieScene implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieSceneId")
	private Long movieSceneId;
	
	// " Colume : name = beginDate " will cause an error while building the table.
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "beginTime")
	private String beginTime;
	
	@Column(name = "price")
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	private Movie movie;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "videoHallId")
	private VideoHall videoHall;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sceneSeatInfoId")
	private SceneSeatInfo sceneSeatInfo;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public VideoHall getVideoHall() {
		return videoHall;
	}

	public void setVideoHall(VideoHall videoHall) {
		this.videoHall = videoHall;
	}

	public SceneSeatInfo getSceneSeatInfo() {
		return sceneSeatInfo;
	}

	public void setSceneSeatInfo(SceneSeatInfo sceneSeatInfo) {
		this.sceneSeatInfo = sceneSeatInfo;
	}

	public Long getMovieSceneId() {
		return movieSceneId;
	}

	public void setMovieSceneId(Long movieSceneId) {
		this.movieSceneId = movieSceneId;
	}

	public Date getBeginDate() {
		return date;
	}

	public void setBeginDate(Date date) {
		this.date = date;
	}
}
