package com.promineotech.trekbikes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/UpdateBike")
@OpenAPIDefinition(info = @Info(title = "Trek Bikes"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server")})
public interface UpdateBikeController {
	//Updates Bike

		// @formatter:off
		@Operation(
			summary = "Updates a Bike",
			description = "Updates a Bike",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The Bike information was updated successfully.",
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
					description = "Unable to update Trek Bike with the information given",
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
					name ="bikeId",
					allowEmptyValue = false,
					required = true,
					description = "Identify which bike to update."),
				@Parameter(
					name = "frameset",
					allowEmptyValue = false,
					required = true,
					description = "Frameset chosen for bike"),
				@Parameter(
					name = "color",
					allowEmptyValue = false,
					required = true,
					description = "Color chosen for Handlebar"),
				@Parameter(
					name = "handlebar",
					allowEmptyValue = false,
					required = true,
					description = "Handlebar chosen"),
				@Parameter(
					name = "drivetrain",
					allowEmptyValue = false,
					required = true,
					description = "Drivetrain chosen"),
				@Parameter(
					name = "saddle",
					allowEmptyValue = false,
					required = true,
					description = "Saddle chosen"),
				@Parameter(
					name = "tire",
					allowEmptyValue = true,
					required = true,
					description = "Tire Chosen")
	}	

		)

		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
		Bike updateBike(
				@RequestParam(required = true)
				Long bikeId,
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
