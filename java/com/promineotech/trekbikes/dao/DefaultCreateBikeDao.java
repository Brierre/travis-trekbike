package com.promineotech.trekbikes.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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

public class DefaultCreateBikeDao implements CreateBikeDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Bike newBike(Frameset frameset, Color color, Drivetrain drivetrain, Handlebar handlebar,
			Saddle saddle, Tire tire) {
		log.info("DAO: frameset={}, color={}, drivetrain={}, handlebar={}, saddle={}, tire={}", frameset, color, drivetrain, handlebar, saddle, tire);
		
		// @formatter:off
		String sql = ""
				+ "INSERT INTO bike ("
				+ "frameset_id, color_id, drivetrain_id, handlebar_id, saddle_id, tire_id"
				+ ") VALUES ("
				+ ":frameset_id, :color_id, :drivetrain_id, :handlebar_id, :saddle_id, :tire_id"
				+ ")";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("frameset_id", frameset);  
		params.put("color_id", color);
		params.put("drivetrain_id", drivetrain);
		params.put("handlebar_id", handlebar);
		params.put("saddle_id", saddle);
		params.put("tire_id", tire);
		
		jdbcTemplate.update(sql, params);
		return Bike.builder()
			// @formatter:off
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
