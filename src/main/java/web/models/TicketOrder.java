package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import utils.SlkUtil;

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
	
	@ElementCollection
	@Column(name = "orderedSeatInfos")
	private List<SeatInfo> orderedSeatInfos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private Calendar createdDate;
	
	@Column(name = "orderStatus")
	private OrderStatus orderStatus;
	
	@SuppressWarnings("unchecked")
	public TicketOrder(MovieScene movie_scene_1, User user_1, List<SeatInfo> avail_seat_1, Calendar createDate) {
		// TODO Auto-generated constructor stub
		this.movieScene = (MovieScene) SlkUtil.deepClone(movie_scene_1);
		this.user = (User) SlkUtil.deepClone(user_1);
		this.orderedSeatInfos = (List<SeatInfo>)SlkUtil.deepClone(avail_seat_1);
		this.createdDate = (Calendar) SlkUtil.deepClone(createDate);
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
		this.movieScene = (MovieScene) SlkUtil.deepClone(movieScene);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = (User) SlkUtil.deepClone(user);
	}

	public List<SeatInfo> getOrderedSeatInfos() {
		return orderedSeatInfos;
	}

	@SuppressWarnings("unchecked")
	public void setOrderedSeatInfos(List<SeatInfo> orderedSeatInfos) {
		this.orderedSeatInfos = (List<SeatInfo>) SlkUtil.deepClone(orderedSeatInfos);
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = (Calendar) SlkUtil.deepClone(createdDate);
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
