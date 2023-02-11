package com.promineotech.trekbikes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.trekbikes.dao.DeleteBikeDao;
import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDeleteBikeService implements DeleteBikeService {
	@Autowired
	private DeleteBikeDao deleteBikeDao;
	@Override
	public Bike deleteBike(Long bikeId){
		log.info("deleteBike has been called for bikeId={}", bikeId);
		return deleteBikeDao.deleteBike(bikeId);
	}
	
}
