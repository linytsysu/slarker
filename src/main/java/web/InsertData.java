package web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import web.models.Cinema;
import web.models.HallSeatStructure;
import web.models.Movie;
import web.models.MovieScene;
import web.models.Region;
import web.models.Seat;
import web.models.SeatInfo;
import web.models.TicketOrder;
import web.models.User;
import web.models.UserRole;
import web.models.VideoHall;
import web.repositories.CinemaRepository;
import web.repositories.HallSeatStructureRepository;
import web.repositories.MovieRepository;
import web.repositories.MovieSceneRepository;
import web.repositories.OrderRepository;
import web.repositories.RegionRepository;
import web.repositories.SceneSeatInfoRepository;
import web.repositories.UserRepository;
import web.repositories.UserRoleRepository;
import web.repositories.VideoHallRepository;


public class InsertData implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CinemaRepository cinema_repo;
	
	@Autowired
	RegionRepository region_repo;
	
	@Autowired
	MovieRepository movie_repo;
	
	@Autowired
	MovieSceneRepository movie_scene_repo;
	
	@Autowired
	UserRepository user_repo;
	
	@Autowired
	HallSeatStructureRepository hall_seat_struct_repo;

	@Autowired
	VideoHallRepository video_hall_repo;
	
	@Autowired
	SceneSeatInfoRepository scene_seat_info_repo;
	
	@Autowired
	UserRoleRepository user_role_repo;
	
	@Autowired
	OrderRepository order_repo;
	
	@Resource(name = "passwordEncoder")
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
//		if (region_repo.count() > 0) return;	// count > 0 means mysql database has been inserted data.
		
		// if mysql database has not been inserted data. Do the following action!
		
//		cinema_repo.deleteAll();
//		region_repo.deleteAll();
//		movie_repo.deleteAll();
//		movie_scene_repo.deleteAll();
//		user_repo.deleteAll();
//		hall_seat_struct_repo.deleteAll();
//		video_hall_repo.deleteAll();
//		scene_seat_info_repo.deleteAll();
//		order_repo.deleteAll();
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		System.out.println(calendar);
//		calendar.add(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(calendar);
		
		// test Calendar
		Date date1 = Calendar.getInstance().getTime();
		Date date2 = Calendar.getInstance().getTime();
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		Date date = new Date();
		date.setTime(d2-d1);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar);
		
		if (region_repo.count() > 0) return;
		
		// insert region info into Table Region.
		// new PanYa district and BaiYun district.
		Region region_panyu = new Region("440113", "番禺区", "广州市");
		Region region_baiyun = new Region("440111", "白云区", "广州市");
		Region region_tianhe = new Region("440106", "天河区", "广州市");
		region_repo.save(region_panyu);
		region_repo.save(region_baiyun);
		region_repo.save(region_tianhe);
		
		// new Cinema jinyi,wanda,feiyang and jiahe.
		Cinema cinema_jinyi = new Cinema("金逸影珠江-广州大学城店", region_panyu, "小谷围街贝岗村中二横路1号高高新天地商业广场三层第3A028号");
		Cinema cinema_wanda = new Cinema("广州番禺万达电影城", region_panyu, "南村兴南大道东368号万达广场4楼");
		Cinema cinema_feiyang = new Cinema("天河城飞扬影城", region_tianhe, "天河路208号天河城4楼");
		Cinema cinema_jiahe = new Cinema("广州橙天嘉禾影城", region_baiyun, "云城东路503号白云万达广场3楼");
		cinema_repo.save(cinema_jinyi);
		cinema_repo.save(cinema_wanda);
		cinema_repo.save(cinema_feiyang);
		cinema_repo.save(cinema_jiahe);
		
		
		// new HallSeatStructure
		HallSeatStructure hall_seat_structure_jinyi_1 = new HallSeatStructure(Seat.getSeatListRandom(10, 10, 0.8));
		HallSeatStructure hall_seat_structure_jinyi_2 = new HallSeatStructure(Seat.getSeatListRandom(9, 9, 0.8));
		HallSeatStructure hall_seat_structure_wanda_2 = new HallSeatStructure(Seat.getSeatListRandom(10, 8, 0.8));
		HallSeatStructure hall_seat_structure_wanda_3 = new HallSeatStructure(Seat.getSeatListRandom(10, 10, 0.9));
		HallSeatStructure hall_seat_structure_feiyang_6 = new HallSeatStructure(Seat.getSeatListRandom(10, 10, 0.9));
		HallSeatStructure hall_seat_structure_feiyang_8 = new HallSeatStructure(Seat.getSeatListRandom(10, 10, 0.9));
		HallSeatStructure hall_seat_structure_jiahe_5 = new HallSeatStructure(Seat.getSeatListRandom(10, 10, 0.9));
		
		hall_seat_struct_repo.save(hall_seat_structure_jinyi_1);
		hall_seat_struct_repo.save(hall_seat_structure_jinyi_2);
		hall_seat_struct_repo.save(hall_seat_structure_wanda_2);
		hall_seat_struct_repo.save(hall_seat_structure_wanda_3);
		hall_seat_struct_repo.save(hall_seat_structure_feiyang_6);
		hall_seat_struct_repo.save(hall_seat_structure_feiyang_8);
		hall_seat_struct_repo.save(hall_seat_structure_jiahe_5);
		
		// new VideoHalls
		VideoHall video_hall_jinyi_1 = new VideoHall("1号厅", hall_seat_structure_jinyi_1, cinema_jinyi);
		VideoHall video_hall_jinyi_2 = new VideoHall("2号厅", hall_seat_structure_jinyi_2, cinema_jinyi);
		VideoHall video_hall_wanda_2 = new VideoHall("二号厅", hall_seat_structure_wanda_2, cinema_wanda);
		VideoHall video_hall_wanda_3 = new VideoHall("三号厅", hall_seat_structure_wanda_3, cinema_wanda);
		VideoHall video_hall_feiyang_6 = new VideoHall("天河6厅", hall_seat_structure_feiyang_6, cinema_feiyang);
		VideoHall video_hall_feiyang_8 = new VideoHall("天河8厅", hall_seat_structure_feiyang_8, cinema_feiyang);
		VideoHall video_hall_jiahe_5 = new VideoHall("5号厅", hall_seat_structure_jiahe_5, cinema_jiahe);
		
		video_hall_repo.save(video_hall_jinyi_1);
		video_hall_repo.save(video_hall_jinyi_2);
		video_hall_repo.save(video_hall_wanda_2);
		video_hall_repo.save(video_hall_wanda_3);
		video_hall_repo.save(video_hall_feiyang_6);
		video_hall_repo.save(video_hall_feiyang_8);
		video_hall_repo.save(video_hall_jiahe_5);
		
		// new Movie
		List<String> directors = new ArrayList<String>();
		directors.add("詹姆斯·波宾");
		List<String> actors = new ArrayList<String>();
		actors.add("约翰尼·德普-饰-疯帽先生");
		actors.add("安妮·海瑟薇-饰-白女王");
		actors.add("米娅·华希科沃斯卡-饰-爱丽丝");
		actors.add("海伦娜·伯翰·卡特-饰-红桃女王");
		actors.add("迈克尔·辛-饰-白兔子");
		List<String> types = new ArrayList<String>();
		types.add("奇幻");
		types.add("冒险");
		Calendar release_time = Calendar.getInstance();
		release_time.set(2016, 5, 27);
		List<String> version = new ArrayList<String>();
		version.add("IMAX3D");
		version.add("2D");
		version.add("3D");
		version.add("巨幕");
		Movie movie_1 = new Movie("爱丽丝梦游仙境2：镜中奇遇记", directors, actors, "ailisimengyouxianjing2.jpg", types, "美国", "英语", "1小时55分钟", release_time, version, 8.4, "ailisimengyouxianjing2_bg.jpg");
		
		List<String> directors_2 = new ArrayList<String>();
		directors_2.add("邓肯·琼斯");
		List<String> actors_2 = new ArrayList<String>();
		actors_2.add("宝拉·巴顿-饰-迦罗娜");
		actors_2.add("崔维斯·费米尔-饰-安杜因·洛萨");
		actors_2.add("托比·凯贝尔-饰-杜隆坦");
		actors_2.add("罗伯特·卡辛斯基-饰-奥格瑞姆");
		actors_2.add("本·福斯特-饰-麦迪文");
		actors_2.add("多米尼克·库珀-饰-莱恩·乌瑞恩国");
		actors_2.add("克兰西·布朗-饰-黑手");
		actors_2.add("本·施耐泽-饰-卡德加");
		actors_2.add("吴彦祖-饰-古尔丹");
		List<String> types_2 = new ArrayList<String>();
		types_2.add("奇幻");
		types_2.add("冒险");
		types_2.add("动作");
		types_2.add("战争");
		Calendar release_time_2 = Calendar.getInstance();
		release_time_2.set(2016, 6, 8);
		List<String> version_2 = new ArrayList<String>();
		version_2.add("IMAX3D");
		version_2.add("3D");
		Movie movie_2 = new Movie("魔兽", directors_2, actors_2, "moshou.jpg", types_2, "美国", "英语", "2小时3分钟", release_time_2, version_2, 9, "moshou_bg.jpg");
		
		List<String> directors_3 = new ArrayList<String>();
		directors_3.add("费格尔·雷利");
		directors_3.add("克雷·卡提斯");
		List<String> actors_3 = new ArrayList<String>();
		actors_3.add("杰森·苏戴奇斯");
		actors_3.add("乔什·盖德");
		actors_3.add("丹尼·麦克布耐");
		actors_3.add("玛娅·鲁道夫");
		actors_3.add("彼特·丁拉基");
		actors_3.add("比尔·哈德尔");
		actors_3.add("吉甘-迈克尔");
		actors_3.add("吉奥弗瑞·阿伦");
		actors_3.add("托尼·海尔");
		actors_3.add("吉丽安·贝尔");
		List<String> types_3 = new ArrayList<String>();
		types_3.add("动画");
		types_3.add("喜剧");
		types_3.add("动作");
		Calendar release_time_3 = Calendar.getInstance();
		release_time_3.set(2016, 5, 20);
		List<String> version_3 = new ArrayList<String>();
		version_3.add("3D");
		version_3.add("巨幕");
		Movie movie_3 = new Movie("愤怒的小鸟", directors_3, actors_3, "fenludexiaoniao.jpg", types_3, "美国", "英语", "1小时37分钟", release_time_3, version_3, 8.8, "fenludexiaoniao_bg.jpg");
		
		List<String> directors_4 = new ArrayList<String>();
		directors_4.add("布莱恩·辛格");
		List<String> actors_4 = new ArrayList<String>();
		actors_4.add("迈克尔·法斯宾德-饰-万磁王");
		actors_4.add("詹姆斯·麦卡沃伊詹姆斯·麦卡沃伊-饰-X教授");
		actors_4.add("詹妮弗·劳伦斯-饰-变形女");
		actors_4.add("尼古拉斯·霍尔特-饰-野兽");
		actors_4.add("伊万·彼得斯-饰-快银");
		actors_4.add("奥斯卡·伊萨克-饰-成年天启");
		actors_4.add("索菲·特纳-饰-凤凰女");
		actors_4.add("泰尔·谢里丹-饰-镭射眼");
		actors_4.add("亚历山德拉·西普-饰 -暴风女");
		List<String> types_4 = new ArrayList<String>();
		types_4.add("动作");
		types_4.add("奇幻");
		types_4.add("科幻");
		types_4.add("冒险");
		Calendar release_time_4 = Calendar.getInstance();
		release_time_4.set(2016, 6, 3);
		List<String> version_4 = new ArrayList<String>();
		version_4.add("IMAX3D");
		version_4.add("3D");
		version_4.add("巨幕");
		Movie movie_4 = new Movie("X战警：天启", directors_4, actors_4, "x_zhanjing_tianqi.jpg", types_4, "美国", "英语", "2小时24分钟", release_time_4, version_4, 9, "x_zhanjing_tianqi_bg.jpg");
		
		movie_repo.save(movie_1);
		movie_repo.save(movie_2);
		movie_repo.save(movie_3);
		movie_repo.save(movie_4);
		
		// new MovieScene
		Calendar calendar_1 = Calendar.getInstance();
		calendar_1.set(2016, 5, 29, 13, 10);
		MovieScene movie_scene_1 = new MovieScene(calendar_1, 64, movie_1, video_hall_jinyi_1);
		scene_seat_info_repo.save(movie_scene_1.getSceneSeatInfo());
		
		Calendar calendar_2 = Calendar.getInstance();
		calendar_2.set(2016, 5, 29, 13, 40);
		MovieScene movie_scene_2 = new MovieScene(calendar_2, 64, movie_1, video_hall_jinyi_2);
		scene_seat_info_repo.save(movie_scene_2.getSceneSeatInfo());
		
		Calendar calendar_3 = Calendar.getInstance();
		calendar_3.set(2016, 6, 30, 14, 20);
		MovieScene movie_scene_3 = new MovieScene(calendar_3, 64, movie_2, video_hall_wanda_2);
		scene_seat_info_repo.save(movie_scene_3.getSceneSeatInfo());
		
		Calendar calendar_4 = Calendar.getInstance();
		calendar_4.set(2016, 6, 30, 13, 5);
		MovieScene movie_scene_4 = new MovieScene(calendar_4, 32, movie_3, video_hall_wanda_3);
		scene_seat_info_repo.save(movie_scene_4.getSceneSeatInfo());
		
		Calendar calendar_5 = Calendar.getInstance();
		calendar_5.set(2016, 6, 30, 15, 40);
		MovieScene movie_scene_5 = new MovieScene(calendar_5, 56, movie_3, video_hall_feiyang_6);
		scene_seat_info_repo.save(movie_scene_5.getSceneSeatInfo());
		
		Calendar calendar_6 = Calendar.getInstance();
		calendar_6.set(2016, 7, 1, 10, 50);
		MovieScene movie_scene_6 = new MovieScene(calendar_6, 64, movie_2, video_hall_feiyang_8);
		scene_seat_info_repo.save(movie_scene_6.getSceneSeatInfo());
		
		Calendar calendar_7 = Calendar.getInstance();
		calendar_7.set(2016, 7, 2, 11, 55);
		MovieScene movie_scene_7 = new MovieScene(calendar_7, 64, movie_2, video_hall_jiahe_5);
		scene_seat_info_repo.save(movie_scene_7.getSceneSeatInfo());
		
		Calendar calendar_8 = Calendar.getInstance();
		calendar_8.set(2016, 7, 3, 18, 30);
		MovieScene movie_scene_8 = new MovieScene(calendar_8, 64, movie_4, video_hall_jiahe_5);
		scene_seat_info_repo.save(movie_scene_8.getSceneSeatInfo());
		
		movie_scene_repo.save(movie_scene_1);
		movie_scene_repo.save(movie_scene_2);
		movie_scene_repo.save(movie_scene_3);
		movie_scene_repo.save(movie_scene_4);
		movie_scene_repo.save(movie_scene_5);
		movie_scene_repo.save(movie_scene_6);
		movie_scene_repo.save(movie_scene_7);
		movie_scene_repo.save(movie_scene_8);
		
		// new User
		User user_1 = new User("meliodas", passwordEncoder.encode("password"), "meliodas@sina.com");
		User user_2 = new User("common", passwordEncoder.encode("common"), "common@gmail.com");
		User user_3 = new User("jiahao", passwordEncoder.encode("jiahao"), "jiahao@sina.com");
		User user_4 = new User("yiting", passwordEncoder.encode("yiting"), "yiting@sina.com");
		User user_5 = new User("langge", passwordEncoder.encode("langge"), "langge@sina.com");
		User user_6 = new User("priya",  "$2a$04$CO93CT2ObgMiSnMAWwoBkeFObJlMYi/wzzOnPlsTP44r7qVq0Jln2", "priya@gmail.com");
		
		user_repo.save(user_1);
		user_repo.save(user_2);
		user_repo.save(user_3);
		user_repo.save(user_4);
		user_repo.save(user_5);
		user_repo.save(user_6);
		
		// new UserRole
		UserRole user_role_1 = new UserRole(user_1, "ROLE_USER");
		UserRole user_role_2 = new UserRole(user_2, "ROLE_USER");
		UserRole user_role_3 = new UserRole(user_3, "ROLE_USER");
		UserRole user_role_4 = new UserRole(user_4, "ROLE_USER");
		UserRole user_role_5 = new UserRole(user_5, "ROLE_USER");
		UserRole user_role_6 = new UserRole(user_6, "ROLE_USER");
		
		user_role_repo.save(user_role_1);
		user_role_repo.save(user_role_2);
		user_role_repo.save(user_role_3);
		user_role_repo.save(user_role_4);
		user_role_repo.save(user_role_5);
		user_role_repo.save(user_role_6);
		
		// new TicketOrder
		List<SeatInfo> avail_seat_1 = movie_scene_1.getAvailSeatRandom(0.02);
		while (avail_seat_1.isEmpty()) {
			avail_seat_1 = movie_scene_1.getAvailSeatRandom(0.02);
		}
		Calendar createDate_1 = Calendar.getInstance();
		createDate_1.set(2016, 5, 28, 9, 5);
		TicketOrder ticket_order_1 = new TicketOrder(movie_scene_1, user_1, avail_seat_1, createDate_1);
		
		List<SeatInfo> avail_seat_2 = movie_scene_2.getAvailSeatRandom(0.02);
		while (avail_seat_2.isEmpty()) {
			avail_seat_2 = movie_scene_2.getAvailSeatRandom(0.02);
		}
		Calendar createDate_2 = Calendar.getInstance();
		createDate_2.set(2016, 5, 28, 9, 55);
		TicketOrder ticket_order_2 = new TicketOrder(movie_scene_2, user_2, avail_seat_2, createDate_2);
		
		List<SeatInfo> avail_seat_3 = movie_scene_1.getAvailSeatRandom(0.02);
		while (avail_seat_3.isEmpty()) {
			avail_seat_3 = movie_scene_3.getAvailSeatRandom(0.02);
		}
		Calendar createDate_3 = Calendar.getInstance();
		createDate_3.set(2016, 5, 27, 12, 15);
		TicketOrder ticket_order_3 = new TicketOrder(movie_scene_3, user_3, avail_seat_3, createDate_3);
		
		List<SeatInfo> avail_seat_4 = movie_scene_1.getAvailSeatRandom(0.02);
		while (avail_seat_4.isEmpty()) {
			avail_seat_4 = movie_scene_4.getAvailSeatRandom(0.02);
		}
		Calendar createDate_4 = Calendar.getInstance();
		createDate_4.set(2016, 5, 26, 21, 30);
		TicketOrder ticket_order_4 = new TicketOrder(movie_scene_4, user_4, avail_seat_4, createDate_4);
		
		order_repo.save(ticket_order_1);
		order_repo.save(ticket_order_2);
		order_repo.save(ticket_order_3);
		order_repo.save(ticket_order_4);
		
		
		System.out.println("Insert data done!");
	}

}
