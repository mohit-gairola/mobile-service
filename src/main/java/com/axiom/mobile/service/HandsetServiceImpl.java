package com.axiom.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axiom.mobile.model.Handset;
import com.axiom.mobile.repository.HandsetRepositoryDaoImpl;

@Service
public class HandsetServiceImpl implements HandsetService {

	@Autowired
	private HandsetRepositoryDaoImpl handsetRepository;

	public List<Handset> searchHandsetRecord(String sim, String price, String announceDate, String phone, String id,
			String brand, String resolution, String picture, String audioJack, String gps, String battery) {

		return handsetRepository.searchHandsetRecord(sim, price, announceDate, phone, id, brand, resolution, picture,
				audioJack, gps, battery);

	}

	public void insertHandsetRecords(List<Handset> handsetList) {

		for (Handset handset : handsetList) {
			handsetRepository.save(handset);
		}

	}

}
