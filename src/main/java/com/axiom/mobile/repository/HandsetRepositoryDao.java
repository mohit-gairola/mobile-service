package com.axiom.mobile.repository;

import java.util.List;

import com.axiom.mobile.model.Handset;

public interface HandsetRepositoryDao {

	List<Handset> searchHandsetRecord(String sim, String price, String announceDate, String phone, String id,
			String brand, String resolution, String picture, String audioJack, String gps, String battery);
	
	Handset save(Handset handset);
}
