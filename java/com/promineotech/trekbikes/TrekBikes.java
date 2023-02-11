package com.promineotech.trekbikes;

//http://localhost:8080/swagger-ui/index.html#/DefaultCreateBikeController

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class TrekBikes extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(TrekBikes.class, args);
	}
	
}
//Layers: controller (Swagger) ,DAO, Service, Entity
//Full CRDU on one: CRUD on Saddle, read on REST
//COntrollers: 1 controller per entity or on controller for each part of CRUD
//1 per entity: easy control on each individule entity, easly to debug, more endpoints
//1 per CRUD, only 4 endpoints, but harder to debug/make flexible