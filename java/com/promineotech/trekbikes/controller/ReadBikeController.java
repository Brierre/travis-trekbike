package com.promineotech.trekbikes.controller;

import java.util.List;

import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.trekbikes.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/ReadBike")
@OpenAPIDefinition(info = @Info(title = "Trek Bikes Build"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})


public interface ReadBikeController {
	
	//@formatter:off
		@Operation(
			summary = "Returns a list of Trek Bike components",
			description = "Returns a list of Bike components",
			responses = {
				
				@ApiResponse(responseCode = "200", 
						description = "The list of Bike options is returned", 
						content = @Content(
						mediaType = "application/json", 
						schema = @Schema(
						implementation = TrekBikes.class))),
				
				@ApiResponse(responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(
						mediaType = "application/json")),
				
				@ApiResponse(responseCode = "404",  
						description = "No Bike component were found with the input criteria", 
						content = @Content(
						mediaType = "application/json")),
				
				@ApiResponse(responseCode = "500",  
						description = "An unplanned error occured.", 
						content = @Content(
						mediaType = "application/json"))
			},
		
			parameters = { 
				@Parameter(
						name = "frameset",  
						required = false, 
						description = "Frameset Needed for a Bike"),
				@Parameter(
						name = "color",  
						required = false, 
						description = "Color Needed for a Bike"),
				@Parameter(
						name = "drivetrain",  
						required = false, 
						description = "Drivetrain Needed for a Bike"),
				@Parameter(
						name = "handlebar",  
						required = false, 
						description = "Handlebar Needed for a Bike"),
				@Parameter(
						name = "saddle",  
						required = false, 
						description = "Saddle Needed for a Bike"),
				@Parameter(
						name = "tire",  
						required = false, 
						description = "Tires Needed for a Bike")
				
			}
		)
		@GetMapping(value = "/fetchTrekBikes")
		@ResponseStatus(code = HttpStatus.OK)
//		Order createOrder(@Valid @RequestBody OrderRequest orderRequest);

		List<Bike> fetchBike(
				@RequestParam(required = false)
				Frameset frameset,
				@RequestParam(required = false)
				Color color,
				@RequestParam(required = false)
				Drivetrain drivetrain,
				@RequestParam(required = false)
				Handlebar handlebar,
				@RequestParam(required = false)
				Saddle saddle,
				@RequestParam(required = false)
				Tire tire);	
		
		//@formatter:on


		
	}

