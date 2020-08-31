package com.axiom.mobile.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.axiom.mobile.model.Handset;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${mobile.handset.api.url}")
	private String handsetApiUrl;

	public List<Handset> searchHandsetRecord(String sim, String price, String announceDate) {

		// Fetching Handset Data using REST API
		List<Handset> handsetRecords = getHandsetData();

		Stream<Handset> handsetDataStream = handsetRecords.parallelStream();

		// Filtering records on the basis of SIM
		if (!StringUtils.isEmpty(sim)) {
			handsetDataStream = handsetDataStream.filter(handsetData -> {
				String sims[] = handsetData.getSim().split(" ");
				for (String s : sims) {
					if (s.equalsIgnoreCase(sim)) {
						return true;
					}
				}
				return false;
			});
		}

		// Filtering records on the basis of Announce Date
		if (!StringUtils.isEmpty(announceDate)) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getRelease().getAnnounceDate().equals(announceDate));
		}

		// Filtering records on the basis of Price
		if (!StringUtils.isEmpty(price)) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getRelease().getPriceEur().equals(price));
		}

		// Finally collecting records on the basis of filters applied above
		List<Handset> filteredRecords = handsetDataStream.collect(Collectors.toList());

		return filteredRecords;

	}

	private List<Handset> getHandsetData() {
		ResponseEntity<List<Handset>> responseEntity= restTemplate.exchange(handsetApiUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Handset>>() {
				});
		return responseEntity.getBody();
	}

}
