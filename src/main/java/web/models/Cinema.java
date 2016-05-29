package web.models;


import java.io.Serializable;
import javax.persistence.*;

import ch.qos.logback.classic.pattern.Util;
import utils.SlkUtil;

@Entity
@Table(name = "Cinema") 
public class Cinema implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cinemaId")
	private Long cinemaId;
	
	@Column(name = "cinemaName")
	private String cinemaName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "code")
	private Region region;
	
	@Column(name = "detailedAddress")
	private String detailedAddress;

	public Cinema() {}
	
	public Cinema(String cinemaName, Region region, String detailedAddress) {
		super();
		this.cinemaName = cinemaName;
		this.region = (Region)SlkUtil.deepClone(region);
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

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = (Region)SlkUtil.deepClone(region);
	}
	
	
}
