package com.axiom.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.mobile.model.HandsetData;
import com.axiom.mobile.service.MobileService;
import com.axiom.mobile.validator.SimValidator;

@RestController
@RequestMapping(path = "mobile", produces = MediaType.APPLICATION_JSON_VALUE)
public class MobileController {

	@Autowired
	private MobileService mobileService;

	@Autowired
	private SimValidator validator;

	@GetMapping(path = "/search")
	public List<HandsetData> getMobileData(@RequestParam(name = "sim", required = false) String sim,
			@RequestParam(name = "priceEur", required = false) String price,
			@RequestParam(name = "announceDate", required = false) String announceDate) {

		validator.validate(sim);

		return mobileService.searchHandsetRecord(sim, price, announceDate);

	}
}
