package com.promineotech.trekbikes.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.trekbikes.dao.UpdateBikeDao;
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
public class DefaultUpdateBikeService implements UpdateBikeService {
	
	@Autowired
	private UpdateBikeDao updateBikeDao;
//	@Transactional
	@Override
	public Bike updateBike(Long bikeId, Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar, Saddle saddle, Tire tire){
		log.info("updateBike has been called bikeId={}, color={}, drivetrain={}, frameset={}, handlebar={}, saddle={}, tire={}", bikeId, color, drivetrain, frameset, handlebar, saddle, tire);
		return updateBikeDao.updateBike(bikeId, frameset, color, drivetrain, handlebar, saddle, tire);
	}
	}