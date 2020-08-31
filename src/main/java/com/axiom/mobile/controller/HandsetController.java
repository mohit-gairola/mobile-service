package com.axiom.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.mobile.model.Handset;
import com.axiom.mobile.service.HandsetService;

@RestController
@RequestMapping(path = "handset", produces = MediaType.APPLICATION_JSON_VALUE)
public class HandsetController {

	@Autowired
	private HandsetService handsetService;

	@GetMapping(path = "/search")
	public List<Handset> getMobileData(@RequestParam(name = "sim", required = false) String sim,
			@RequestParam(name = "priceEur", required = false) String price,
			@RequestParam(name = "announceDate", required = false) String announceDate,
			@RequestParam(name = "phone", required = false) String phone,
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "resolution", required = false) String resolution,
			@RequestParam(name = "picture", required = false) String picture,
			@RequestParam(name = "audioJack", required = false) String audioJack,
			@RequestParam(name = "gps", required = false) String gps,
			@RequestParam(name = "battery", required = false) String battery) {

		return handsetService.searchHandsetRecord(sim, price, announceDate, phone, id, brand, resolution, picture,
				audioJack, gps, battery);

	}

	@PostMapping
	public void uploadMobileData(@RequestBody List<Handset> handsets) {

		handsetService.insertHandsetRecords(handsets);

	}
}
