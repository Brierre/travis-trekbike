package com.promineotech.trekbikes.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;

import lombok.extern.slf4j.Slf4j;

@Component 
@Slf4j
public class DefaultUpdateBikeDao implements UpdateBikeDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Bike updateBike(Long bikeId, Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar,
			Saddle saddle, Tire tire) {
		log.info("DAO: bikeId={}, frameset={}, color={}, drivetrain={}, handlebar={}, saddle={}, tire={}", 
				frameset, color, drivetrain, handlebar, saddle, tire);
			
		//@formatter:off
		String sql = ""
				+ "UPDATE bike"
				+"SET frameset = :frameset, color = :color, drivetrain = :drivetrain, handlebar = :handlebar, saddle = :saddle, tire = :tire "
				+"WHERE bike_pk = :bike_pk";
		//@formatter:on
		

		Map<String, Object> params = new HashMap<>();
		params.put("bike_pk", bikeId);
		params.put("frameset", frameset);
		params.put("color", color);
		params.put("drivetrain", drivetrain);
		params.put("handlebar", handlebar);
		params.put("saddle", saddle);
		params.put("tire", tire);

		jdbcTemplate.update(sql, params);
		return Bike
			// @formatter:off
			.builder()
			.frameset(frameset)
			.color(color)
			.drivetrain(drivetrain)
			.handlebar(handlebar)
			.saddle(saddle)
			.tire(tire)
			.build();
			// @formatter:on
		
		}
	}


