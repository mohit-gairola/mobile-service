package com.axiom.mobile.repository;

import java.util.ArrayList;
import java.util.List;

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
	public List<Handset> searchHandsetRecord(String sim, String price, String announceDate, String phone, String id,
			String brand, String resolution, String picture, String audioJack, String gps, String battery) {

		List<Handset> handsetList = new ArrayList<Handset>();

		Criteria criteria = new Criteria();

		if (!StringUtils.isEmpty(sim)) {
			criteria.and(Criteria.where("sim").is(sim));
		}
		if (!StringUtils.isEmpty(price)) {
			criteria.and(Criteria.where("release.priceEur").is(price));
		}
		if (!StringUtils.isEmpty(announceDate)) {
			criteria.and(Criteria.where("release.announceDate").is(announceDate));
		}
		if (!StringUtils.isEmpty(phone)) {
			criteria.and(Criteria.where("phone").is(phone));
		}
		if (!StringUtils.isEmpty(id)) {
			criteria.and(Criteria.where("id").is(id));
		}
		if (!StringUtils.isEmpty(brand)) {
			criteria.and(Criteria.where("brand").is(brand));
		}
		if (!StringUtils.isEmpty(resolution)) {
			criteria.and(Criteria.where("resolution").is(resolution));
		}
		if (!StringUtils.isEmpty(picture)) {
			criteria.and(Criteria.where("picture").is(picture));
		}
		if (!StringUtils.isEmpty(audioJack)) {
			criteria.and(Criteria.where("hardware.audioJack").is(audioJack));
		}
		if (!StringUtils.isEmpty(gps)) {
			criteria.and(Criteria.where("hardware.gps").is(gps));
		}
		if (!StringUtils.isEmpty(battery)) {
			criteria.and(Criteria.where("hardware.battery").is(battery));
		}

		Query query = new CriteriaQuery(criteria);

		handsetRepository.search(query).forEach(h -> handsetList.add(h));
		return handsetList;
	}

	public Handset save(Handset handset) {
		return handsetRepository.save(handset);
	}
}

