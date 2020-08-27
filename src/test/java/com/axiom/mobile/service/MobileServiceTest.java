package com.axiom.mobile.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.axiom.mobile.model.HandsetData;
import com.axiom.mobile.model.Release;

@RunWith(MockitoJUnitRunner.class)
public class MobileServiceTest {

	@InjectMocks
	private MobileService mobileService = new MobileServiceImpl();

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private ResponseEntity<List<HandsetData>> responseEntity;

	@Mock
	private List<HandsetData> handsetDataList;

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(mobileService, "handsetApiUrl", "TEST_URL");

		Mockito.when(responseEntity.getBody()).thenReturn(getHandsetData());
		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.eq(HttpMethod.GET),
				ArgumentMatchers.isNull(), ArgumentMatchers.<ParameterizedTypeReference<List<HandsetData>>>any()))
				.thenReturn(responseEntity);
	}

	@Test
	public void testSearchMobileRecordsBySIM() {

		List<HandsetData> result = mobileService.searchHandsetRecord("eSIM", null, null);

		assertEquals(3, result.size());
		assertEquals("Ericsson T20", result.get(0).getPhone());
		assertEquals("Ericsson T30", result.get(1).getPhone());
		assertEquals("Ericsson T40", result.get(2).getPhone());

	}

	@Test
	public void testSearchMobileRecordsByPrice() {

		List<HandsetData> result = mobileService.searchHandsetRecord(null, "200", null);

		assertEquals(2, result.size());
		assertEquals("Ericsson T20", result.get(0).getPhone());
		assertEquals("Ericsson T30", result.get(1).getPhone());

	}

	@Test
	public void testSearchMobileRecordsByAnnounceDate() {

		List<HandsetData> result = mobileService.searchHandsetRecord(null, null, "2000");

		assertEquals(2, result.size());
		assertEquals("Ericsson T30", result.get(0).getPhone());
		assertEquals("Ericsson T40", result.get(1).getPhone());

	}

	@Test
	public void testSearchMobileRecordsBySimAndPriceAndAnnounceDate() {

		List<HandsetData> result = mobileService.searchHandsetRecord("eSIM", "400", "2000");

		assertEquals(1, result.size());
		assertEquals("Ericsson T40", result.get(0).getPhone());

	}

	private List<HandsetData> getHandsetData() {
		
		List<HandsetData> handsetList = new ArrayList<>();
		
		HandsetData handsetData1 = new HandsetData();
		handsetData1.setPhone("Ericsson T20");
		handsetData1.setSim("eSIM");
		Release release1 = new Release();
		release1.setAnnounceDate("1999");
		release1.setPriceEur("200");
		handsetData1.setRelease(release1);
		handsetList.add(handsetData1);

		HandsetData handsetData2 = new HandsetData();
		handsetData2.setPhone("Ericsson T30");
		handsetData2.setSim("Nano-SIM eSIM");
		Release release2 = new Release();
		release2.setAnnounceDate("2000");
		release2.setPriceEur("200");
		handsetData2.setRelease(release2);
		handsetList.add(handsetData2);

		HandsetData handsetData3 = new HandsetData();
		handsetData3.setPhone("Ericsson T40");
		handsetData3.setSim("eSIM");
		Release release3 = new Release();
		release3.setAnnounceDate("2000");
		release3.setPriceEur("400");
		handsetData3.setRelease(release3);
		handsetList.add(handsetData3);

		return handsetList;

	}

}
