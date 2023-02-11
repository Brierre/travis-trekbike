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
import com.promineotech.trekbikes.service.DeleteBikeService;

@RestController
public class DefaultDeleteBikeController implements DeleteBikeController {

	@Autowired
	private DeleteBikeService deleteBikeService;
	
	@Override
	public Bike deleteBike(Long bikeId) {
		return deleteBikeService.deleteBike(bikeId);
		
	}

}
