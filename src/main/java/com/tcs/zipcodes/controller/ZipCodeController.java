package com.tcs.zipcodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.zipcodes.service.ZipCodeService;

@RestController
public class ZipCodeController {

	@Autowired
	private ZipCodeService zipCodeService;

	@GetMapping("/zipcode/{postalCode}")
	public String getPlaceName(@PathVariable String postalCode) {
		return zipCodeService.getPlaceNameByPostalCode(postalCode);
	}
}
