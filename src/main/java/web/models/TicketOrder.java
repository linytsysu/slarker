package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TicketOrder")
public class TicketOrder implements Serializable {
	public enum OrderStatus {UNPAID, PAID, CLOSED;}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Long orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieSceneId")
	private MovieScene movieScene;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@Column(name = "orderedSeatInfos")
	private ArrayList<SeatInfo> orderedSeatInfos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "orderStatus")
	private OrderStatus orderStatus;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public MovieScene getMovieScene() {
		return movieScene;
	}

	public void setMovieScene(MovieScene movieScene) {
		this.movieScene = movieScene;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<SeatInfo> getOrderedSeatInfos() {
		return orderedSeatInfos;
	}

	public void setOrderedSeatInfos(ArrayList<SeatInfo> orderedSeatInfos) {
		this.orderedSeatInfos = orderedSeatInfos;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
