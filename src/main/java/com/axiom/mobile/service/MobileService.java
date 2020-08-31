package com.axiom.mobile.service;

import java.util.List;

import com.axiom.mobile.model.Handset;

public interface MobileService {

	List<Handset> searchHandsetRecord(String sim, String price, String announceDate);
}
