package com.axiom.mobile.repository;

import java.util.List;
import java.util.Map;

import com.axiom.mobile.model.Handset;

public interface HandsetRepositoryDao {

	List<Handset> searchHandsetRecord(Map<String,String> propertiesMap);
	
	Handset save(Handset handset);
}
