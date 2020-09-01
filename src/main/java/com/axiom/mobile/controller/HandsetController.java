package com.axiom.mobile.controller;

import java.util.List;
import java.util.Map;

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
	public List<Handset> getMobileData(@RequestParam Map<String,String> requestParams) {

		return handsetService.searchHandsetRecord(requestParams);

	}

	@PostMapping
	public void uploadMobileData(@RequestBody List<Handset> handsets) {

		handsetService.insertHandsetRecords(handsets);

	}
}
