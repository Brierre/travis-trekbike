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
public class DefaultDeleteBikeDao implements DeleteBikeDao {


	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Bike deleteBike(Long bikeId) {

	//@ formatter:off
	String sql = ""
		+ "DELETE FROM bike "
		+ "WHERE bike_pk = :bike_pk";
	// @formatter:on
	
	Map<String, Object> params = new HashMap<>();
	params.put("bike_pk", bikeId);

	jdbcTemplate.update(sql, params);
	return Bike
		// @formatter:off
		.builder()
		.bikeId(bikeId)
		.build();
		// @formatter:on
}

}