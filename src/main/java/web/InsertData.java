package web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import web.models.Cinema;
import web.repositories.CinemaRepository;
import web.repositories.RegionRepository;


public class InsertData implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CinemaRepository cinema_repo;
	
	@Autowired
	RegionRepository region_repo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		if (region_repo.count() > 0) return;	// count > 0 means mysql database has been inserted data.
		
		// if mysql database has not been inserted data. Do the following action!
		
		// insert region info into Table Region.
		
		
		
//		Cinema cinema1 = new Cinema("金逸影城", "广州市", "番禺区", "小谷围大学城GOGO新天地3楼");
//		cinema_repo.save(cinema1);
//		Cinema cinema2 = new Cinema("珠江影城", "广州市", "")
	}

}
