package com.promineotech.trekbikes.service;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;

public interface DeleteBikeService {

	/**
	 * 
	 * @param bikeId
	 * @return
	 */
	
	Bike deleteBike(Long bikeId);
	
}
