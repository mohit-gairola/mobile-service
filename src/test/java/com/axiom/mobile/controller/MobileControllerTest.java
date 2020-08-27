package com.axiom.mobile.controller;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.axiom.mobile.MobileServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { MobileServiceApplication.class })
@AutoConfigureMockMvc
public class MobileControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Before
	public void setUp() {

		mockServer = MockRestServiceServer.createServer(restTemplate);
		mockServer.expect(once(), requestTo("https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list"))
				.andRespond(withSuccess(
						"[{\n" + "\"id\": 25846,\n" + "\"brand\": \"Apple\",\n"
								+ "\"phone\": \"Apple iPad Pro 12.9 (2018)\",\n"
								+ "\"picture\": \"https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg\",\n"
								+ "\"release\": {\n" + "\"announceDate\": \"2018 October\",\n" + "\"priceEur\": 1100\n"
								+ "},\n" + "\"sim\": \"Nano-SIM eSIM\",\n" + "\"resolution\": \"2048 x 2732 pixels\",\n"
								+ "\"hardware\": {\n" + "\"audioJack\": \"No\",\n" + "\"gps\": \"Yes with A-GPS\",\n"
								+ "\"battery\": \"Li-Po 9720 mAh battery (36.71 Wh)\"\n" + "}\n" + "}]",
						MediaType.TEXT_HTML));
	}

	@Test
	public void should_Search_HandsetRecords_When_ValidRequest() throws Exception {

		mockMvc.perform(get("/mobile/search?sim=eSIM").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(25846))
				.andExpect(jsonPath("$[0].brand").value("Apple"));

	}

	@Test
	public void should_Give_Bad_Request_When_Sim_Is_Invalid() throws Exception {

		mockMvc.perform(get("/mobile/search?sim=INVALID_SIM").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());

	}

}