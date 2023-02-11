package com.promineotech.trekbikes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.trekbikes.TrekBikes;
import com.promineotech.trekbikes.entity.Bike;
import com.promineotech.trekbikes.entity.Color;
import com.promineotech.trekbikes.entity.Drivetrain;
import com.promineotech.trekbikes.entity.Frameset;
import com.promineotech.trekbikes.entity.Handlebar;
import com.promineotech.trekbikes.entity.Saddle;
import com.promineotech.trekbikes.entity.Tire;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/CreateBike")
@OpenAPIDefinition(info = @Info(title = "TrekBikes"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server")
})

public interface CreateBikeController {
	//CREATE has one Method CreateBike

	//createBike()
		// @formatter:off
		@Operation(
			summary = "Adds a Complete Trek Bike",
			description = "Creates a New Bike with all components",
			responses = {
				@ApiResponse(
					responseCode = "201",
					description = "New Trek Bike",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = TrekBikes.class))),
				@ApiResponse(
					responseCode = "400",
					description = "Invalid request parameters",
					content = @Content(
						mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404",
					description = "Unable to create new Trek bike",
					content = @Content(
						mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500",
					description = "An unplanned error has occurred.",
					content = @Content(
						mediaType = "application/json"))
			},
			parameters = { 
				@Parameter(
					name = "frameset",  
					allowEmptyValue = false,
					required = true,
					description = "Frameset Needed for a Bike"),
				@Parameter(
					name = "color",  
					allowEmptyValue = false,
					required = true, 
					description = "Color Needed for a Bike"),
				@Parameter(
					name = "drivetrain",  
					allowEmptyValue = false,
					required = true, 
					description = "Drivetrain Needed for a Bike"),
				@Parameter(
					name = "handlebar",  
					allowEmptyValue = false,
					required = true, 
					description = "Handlebar Needed for a Bike"),
				@Parameter(
					name = "saddle",  
					allowEmptyValue = false,
					required = true, 
					description = "Saddle Needed for a Bike"),
				@Parameter(
					name = "tire",  
					allowEmptyValue = false,
					required = true, 
					description = "Tires Needed for a Bike")		
		
			}
		)

@PostMapping
@ResponseStatus(code = HttpStatus.OK)
		Bike newBike(
				@RequestParam(required = true) 
				Frameset frameset,
				@RequestParam(required = true) 
				Color color,
				@RequestParam(required = true) 
				Drivetrain drivetrain,
				@RequestParam(required = true) 
				Handlebar handlebar,
				@RequestParam(required = true) 
				Saddle saddle,
				@RequestParam(required = true) 
				Tire tire);
		// @formatter:on
}




