package com.axiom.mobile.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axiom.mobile.model.Handset;
import com.axiom.mobile.repository.HandsetRepositoryDaoImpl;

@Service
public class HandsetServiceImpl implements HandsetService {

	@Autowired
	private HandsetRepositoryDaoImpl handsetRepository;

	public List<Handset> searchHandsetRecord(Map<String,String> propertiesMap) {

		return handsetRepository.searchHandsetRecord(propertiesMap);

	}

	public void insertHandsetRecords(List<Handset> handsetList) {

		for (Handset handset : handsetList) {
			handsetRepository.save(handset);
		}

	}

}
