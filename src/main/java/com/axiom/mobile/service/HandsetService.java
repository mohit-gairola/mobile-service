package com.axiom.mobile.service;

import java.util.List;

import com.axiom.mobile.model.Handset;

public interface HandsetService {

	List<Handset> searchHandsetRecord(String sim, String price, String announceDate, String phone, String id,
			String brand, String resolution, String picture, String audioJack, String gps, String battery);

	void insertHandsetRecords(List<Handset> handsetList);
}
