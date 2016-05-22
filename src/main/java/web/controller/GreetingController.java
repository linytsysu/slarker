package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.models.Cinema;
import web.models.HallSeatStructure;
import web.models.Seat;
import web.models.VideoHall;
import web.repositories.VideoHallRepository;

@Controller
public class GreetingController {

	@Autowired
	private VideoHallRepository videoHallRepository;
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
    	
    	Cinema cinema = new Cinema();
    	cinema.setCinemaName("万达影院");
    	cinema.setCity("广州");
    	cinema.setTown("番禺区");
    	cinema.setDetailedAddress("大学城GOGO新天地三楼");
    	
//    	HallSeatStructure hallSeatStructure = new HallSeatStructure();
//    	hallSeatStructure.addSeat(new Seat(1, 1, 1, 1));
//    	hallSeatStructure.addSeat(new Seat(1, 2, 1, 2));
//    	hallSeatStructure.addSeat(new Seat(1, 3, 1, 3));
//    	hallSeatStructure.addSeat(new Seat(4, 5, 4, 5));
    	
    	VideoHall videoHall = new VideoHall();;
    	videoHall.setVoideHallName("SamepleVideoHall 1 厅");
    	videoHall.setCinema(cinema);
//    	videoHall.setHallSeatStructure(hallSeatStructure);
    	
    	videoHallRepository.save(videoHall);
    	
    	model.addAttribute("name", name);
        return "greeting";
    }

}

