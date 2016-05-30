package web.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MovieScene")
public class MovieScene implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieSceneId")
	private String movieSceneId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "beginTime")
	private String beginTime;
	
	@Column(name = "price")
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	@Column(name = "movie")
	private Movie movie;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "videoHallId")
	@Column(name = "videoHall")
	private VideoHall videoHall;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sceneSeatInfoId")
	@Column(name = "sceneSeatInfo")
	private SceneSeatInfo sceneSeatInfo;
}
