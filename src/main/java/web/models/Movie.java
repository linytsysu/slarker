package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import utils.SlkUtil;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
	
	@SuppressWarnings("unchecked")
	public Movie(String name, List<String> directors, List<String> actors, String poster, List<String> type,
			String country, String language, String duration, Calendar releaseTime, List<String> version, double star,
			String backgroundImage) {
		super();
		this.name = name;
		this.directors = (List<String>)SlkUtil.deepClone(directors);
		this.actors = (List<String>)SlkUtil.deepClone(actors);
		this.poster = poster;
		this.type = (List<String>)SlkUtil.deepClone(type);
		this.country = country;
		this.language = language;
		this.duration = duration;
		this.releaseTime = (Calendar) SlkUtil.deepClone(releaseTime);
		this.version = (List<String>)SlkUtil.deepClone(version);
		this.star = star;
		this.backgroundImage = backgroundImage;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieId")
	private Long movieId;
	
	@Column(name = "name")
	private String name;
	
	@ElementCollection
	@Column(name = "directors")
	private List<String> directors;
	
	@ElementCollection
	@Column(name = "actors")
	private List<String> actors;
	
	@Column(name = "poster")
	private String poster;
	
	@ElementCollection
	@Column(name = "type")
	private List<String> type;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "duration")
	private String duration;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "releaseTime")
	private Calendar releaseTime;
	
	@ElementCollection
	@Column(name = "version")
	private List<String> version;
	
	@Column(name = "star")
	private double star;
	
	@Column(name = "backgroundImage")
	private String backgroundImage;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDirectors() {
		return directors;
	}

	@SuppressWarnings("unchecked")
	public void setDirectors(List<String> directors) {
		this.directors = (List<String>)SlkUtil.deepClone(directors);
	}

	public List<String> getActors() {
		return actors;
	}

	@SuppressWarnings("unchecked")
	public void setActors(List<String> actors) {
		this.actors = (List<String>)SlkUtil.deepClone(actors);
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<String> getType() {
		return type;
	}

	@SuppressWarnings("unchecked")
	public void setType(List<String> type) {
		this.type = (List<String>)SlkUtil.deepClone(type);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Calendar getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Calendar releaseTime) {
		this.releaseTime = (Calendar) SlkUtil.deepClone(releaseTime);
	}

	public List<String> getVersion() {
		return version;
	}

	@SuppressWarnings("unchecked")
	public void setVersion(List<String> version) {
		this.version = (List<String>)SlkUtil.deepClone(version);
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
}
