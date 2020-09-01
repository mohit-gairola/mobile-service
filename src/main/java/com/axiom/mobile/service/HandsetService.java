package com.axiom.mobile.service;

import java.util.List;
import java.util.Map;

import com.axiom.mobile.model.Handset;

public interface HandsetService {

	List<Handset> searchHandsetRecord( Map<String,String> propertiesMap);

	void insertHandsetRecords(List<Handset> handsetList);
}
