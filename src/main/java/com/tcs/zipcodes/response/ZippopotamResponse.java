package com.tcs.zipcodes.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ZippopotamResponse {

	@JsonProperty("post code")
	private String postCode;

	private String country;

	@JsonProperty("country abbreviation")
	private String countryAbbreviation;

	private List<Place> places;

	@Data
	@NoArgsConstructor
	public static class Place {

		@JsonProperty("place name")
		private String placeName;

		private String state;

		@JsonProperty("state abbreviation")
		private String stateAbbreviation;

		private String latitude;

		private String longitude;
	}
}
