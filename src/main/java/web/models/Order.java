package web.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Order")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum OrderStatus{UNPAID, PAID, CLOSED;}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Long orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieSceneId")
	@Column(name = "movieScene")
	private MovieScene movieScene;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@Column(name = "user")
	private User user;
	
	private List<SeatInfo> orderedSeatInfos;
	
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

	public List<SeatInfo> getOrderedSeatInfos() {
		return orderedSeatInfos;
	}

	public void setOrderedSeatInfos(List<SeatInfo> orderedSeatInfos) {
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
