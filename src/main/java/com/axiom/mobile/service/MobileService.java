package com.axiom.mobile.service;

import java.util.List;

import com.axiom.mobile.model.HandsetData;

public interface MobileService {

	List<HandsetData> searchHandsetRecord(String sim, String price, String announceDate);
}
