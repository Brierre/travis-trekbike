package com.promineotech.trekbikes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
	private Long bikeId;
	private Frameset frameset;
	private Color color;
	private Drivetrain drivetrain;
	private Handlebar handlebar;
	private Saddle saddle;
	private Tire tire;
}
