package com.promineotech.trekbikes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;
import com.promineotech.trekbikes.service.CreateBikeService;
@RestController
public class DefaultCreateBikeController implements CreateBikeController {

	@Autowired
	private CreateBikeService createBikeService;
	
	@Override
	public Bike newBike(Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar,
			Saddle saddle, Tire tire) {
		return createBikeService.newBike(frameset, color, drivetrain, handlebar, saddle, tire);
	}

}
