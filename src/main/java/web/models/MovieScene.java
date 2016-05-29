package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import utils.SlkUtil;

@Entity
@Table(name = "MovieScene")
public class MovieScene implements Serializable {

	public MovieScene(Calendar calendar, double price, Movie movie, VideoHall videoHall) {
		super();
		this.calendar = (Calendar)SlkUtil.deepClone(calendar);
		this.price = price;
		this.movie = (Movie) SlkUtil.deepClone(movie);
		this.videoHall = (VideoHall) SlkUtil.deepClone(videoHall);
		
		this.sceneSeatInfo = new SceneSeatInfo(videoHall.getHallSeatStructure());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieSceneId")
	private Long movieSceneId;
	
	// " Colume : name = beginDate " will cause an error while building the table.
	@Temporal(TemporalType.DATE)
	@Column(name = "calendar")
	private Calendar calendar;
	
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
		this.movie = (Movie) SlkUtil.deepClone(movie);
	}

	public VideoHall getVideoHall() {
		return videoHall;
	}

	public void setVideoHall(VideoHall videoHall) {
		this.videoHall = (VideoHall) SlkUtil.deepClone(videoHall);
	}

	public SceneSeatInfo getSceneSeatInfo() {
		return sceneSeatInfo;
	}

	public void setSceneSeatInfo(SceneSeatInfo sceneSeatInfo) {
		this.sceneSeatInfo = (SceneSeatInfo) SlkUtil.deepClone(sceneSeatInfo);
	}

	public Long getMovieSceneId() {
		return movieSceneId;
	}

	public void setMovieSceneId(Long movieSceneId) {
		this.movieSceneId = movieSceneId;
	}

	public Calendar getBeginDate() {
		return calendar;
	}

	public void setBeginDate(Calendar calendar) {
		this.calendar = (Calendar) SlkUtil.deepClone(calendar);
	}
	
	public List<SeatInfo> getAvailSeatRandom(double probability) {
		return this.sceneSeatInfo.getAvailSeatRandom(probability);
	}
}
