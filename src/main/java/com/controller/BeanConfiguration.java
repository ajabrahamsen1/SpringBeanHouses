package com.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.House;

@Configuration
public class BeanConfiguration {

	@Bean
	public House house() {
		House bean = new House();
		bean.setAddress(4321);
		bean.setStreet("Main Street");
		bean.setCity("Townsville");
		bean.setState("NA");
		bean.setZip(54321);
		return bean;
	}
}
