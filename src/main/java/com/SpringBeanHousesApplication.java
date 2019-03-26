package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.House;
import com.controller.BeanConfiguration;
import com.repository.HouseRepository;


@SpringBootApplication
public class SpringBeanHousesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanHousesApplication.class, args);
	}
		
	@Autowired
	HouseRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
	
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		House h = appContext.getBean("house", House.class);
		
		repo.save(h);
		
		House d = new House(307, "North 14th Avenue", "Winterset", "IA", 50273);
		
		repo.save(d);
		
		List<House> allMyHouses = repo.findAll();
		for(House houses: allMyHouses) {
			System.out.println(houses.toString());
		}
	}

}
