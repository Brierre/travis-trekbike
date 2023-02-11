package com.promineotech.trekbikes.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.trekbikes.dao.ReadBikeDao;
import com.promineotech.trekbikes.entity.*;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DefaultReadBikeService implements ReadBikeService {
	@Autowired
	private ReadBikeDao readBikeDao;
	@Transactional	
	@Override
	public List<Bike> fetchBike(Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar, Saddle saddle, Tire tire){
		log.info("fetchBike has been called for frameset={}, color={}, drivetrain={}, handlebar={}, saddle={}, tire={}", frameset, color, drivetrain, handlebar, saddle, tire);
		return readBikeDao.fetchBike(frameset, color, drivetrain, handlebar, saddle, tire);
	}

	
}
