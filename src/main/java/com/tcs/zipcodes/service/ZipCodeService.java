package com.tcs.zipcodes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.zipcodes.response.ZippopotamResponse;

@Service
public class ZipCodeService {

	private final String API_URL = "https://api.zippopotam.us/us/";
	private static final Logger logger = LoggerFactory.getLogger(ZipCodeService.class);

	public String getPlaceNameByPostalCode(String postalCode) {
		String url = API_URL + postalCode;

		RestTemplate restTemplate = new RestTemplate();
		try {
			ZippopotamResponse response = restTemplate.getForObject(url, ZippopotamResponse.class);
			// Log the response to inspect the data
			if (response != null) {
				logger.info("Response received: {}", response);
				if (response.getPlaces() != null && !response.getPlaces().isEmpty()) {
					return response.getPlaces().get(0).getPlaceName(); // Return the place name
				} else {
					return "No places found for the postal code: " + postalCode;
				}
			} else {
				return "Error: No response from the API for postal code: " + postalCode;
			}
		} catch (Exception e) {
			logger.error("Error occurred while fetching data: {}", e.getMessage());
			return "Error fetching data: " + e.getMessage();
		}
	}
}
