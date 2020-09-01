package com.axiom.mobile.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.axiom.mobile.model.Handset;

@Repository
public class HandsetRepositoryDaoImpl implements HandsetRepositoryDao {

	@Autowired
	private HandsetRepository handsetRepository;

	@SuppressWarnings("deprecation")
	public List<Handset> searchHandsetRecord(Map<String, String> propertiesMap) {

		Criteria criteria = new Criteria();

		propertiesMap.forEach((propName, propValue) -> {
			if (!StringUtils.isEmpty(propValue)) {
				if (propName.equalsIgnoreCase("priceEur") || propName.equalsIgnoreCase("announceDate")) {
					criteria.and(Criteria.where("release." + propName).is(propValue));
				} else if (propName.equalsIgnoreCase("audioJack") || propName.equalsIgnoreCase("gps")
						|| propName.equalsIgnoreCase("battery")) {
					criteria.and(Criteria.where("hardware." + propName).is(propValue));
				} else {
					criteria.and(Criteria.where(propName).is(propValue));
				}
			}
		});

		Query query = new CriteriaQuery(criteria);

		return handsetRepository.search(query).stream().collect(Collectors.toList());

	}

	public Handset save(Handset handset) {
		return handsetRepository.save(handset);
	}
}
