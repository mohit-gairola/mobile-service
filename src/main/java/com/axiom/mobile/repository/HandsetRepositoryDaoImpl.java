package com.axiom.mobile.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

		List<Handset> handsetList = new ArrayList<Handset>();

		Criteria criteria = new Criteria();

		propertiesMap.forEach((propName, propValue) -> {

			if (!StringUtils.isEmpty(propValue)) {
				criteria.and(Criteria.where("*." + propName).is(propValue));
			}
		});

		Query query = new CriteriaQuery(criteria);

		handsetRepository.search(query).forEach(h -> handsetList.add(h));
		return handsetList;
	}

	public Handset save(Handset handset) {
		return handsetRepository.save(handset);
	}
}
