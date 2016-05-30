package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "TicketOrder")
public class TicketOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7176047837465838418L;

	public enum OrderStatus {UNPAID, PAID, CLOSED;}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "movieSceneId")
	private MovieScene movieScene;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ElementCollection
	@Column(name = "orderedSeatInfos", length=1000)
	private List<SeatInfo> orderedSeatInfos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private Calendar createdDate;
	
	@Column(name = "orderStatus")
	private OrderStatus orderStatus;
	
	public TicketOrder(MovieScene movie_scene_1, User user_1, List<SeatInfo> avail_seat_1, Calendar createDate) {
		// TODO Auto-generated constructor stub
		this.movieScene = movie_scene_1;
		this.user = user_1;
		this.orderedSeatInfos = avail_seat_1;
		this.createdDate = createDate;
		this.orderStatus = OrderStatus.UNPAID;
		
		for (SeatInfo seat_info : orderedSeatInfos) {
			seat_info.setOptioned();
		}
	}

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

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
