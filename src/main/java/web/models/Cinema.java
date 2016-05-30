package web.models;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Cinema") 
public class Cinema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cinemaId")
	private Long cinemaId;
	
	@Column(name = "cinemaName")
	private String cinemaName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "detailedAddress")
	private String detailedAddress;

	public Cinema() {}
	
	public Cinema(String cinemaName, String city, String town, String detailedAddress) {
		super();
		this.cinemaName = cinemaName;
		this.city = city;
		this.town = town;
		this.detailedAddress = detailedAddress;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	
	
}
