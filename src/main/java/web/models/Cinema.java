package web.models;


import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "Cinema") 
public class Cinema implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cinemaId")
	private Long cinemaId;
	
	@Column(name = "cinemaName")
	private String cinemaName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "star")
	private double star;
	
	public Cinema() {}
	public Cinema(Cinema cinema) {
		this.cinemaId = cinema.cinemaId;
		this.cinemaName = cinema.cinemaName;
		this.address = cinema.address;
		this.star = cinema.star;
	}
	public Long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	
}
