package com.promineotech.trekbikes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;
import com.promineotech.trekbikes.service.UpdateBikeService;
@RestController
public class DefaultUpdateBikeController implements UpdateBikeController {
	@Autowired
		private UpdateBikeService updateBikeService;
	@Override
	public Bike updateBike(Long bikeId, Frameset frameset, Color color, 
			Drivetrain drivetrain, Handlebar handlebar, Saddle saddle, Tire tire) {
		return updateBikeService.updateBike(bikeId, frameset, color, drivetrain, handlebar, saddle, tire);
	}

}
	