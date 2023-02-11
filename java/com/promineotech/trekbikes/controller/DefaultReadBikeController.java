package com.promineotech.trekbikes.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;
import com.promineotech.trekbikes.service.ReadBikeService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class DefaultReadBikeController implements ReadBikeController {

	@Autowired
	private ReadBikeService readBikeService;

	
	@Override
	public List<Bike> fetchBike(Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar,
			Saddle saddle, Tire tire) {
		log.info("frameset={}, color={}, drivetrain={}, handlebar={}, saddle={}, tire={}", frameset, color, drivetrain, handlebar, saddle, tire);
		return readBikeService.fetchBike(frameset, color, drivetrain, handlebar, saddle, tire);
	}

}
