package com.narayana.HypertonicHyponatermia;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class HypertoncHyponatermiaImpl implements HypertoncHyponatermiaRepository {

	public static final String HYPONATERMIA_SERVICE_URL = "http://HYPONATEMIA";
	public static final String HYPERTONIC_SERVICE_URL = "http://HYPERTONCITY";
	protected RestTemplate restTemplate;

	@Override
	public String gethypertoncHyponatermia(String serumSodium, String serumOsmol) {
		String hyponatermia = restTemplate.getForObject(HYPONATERMIA_SERVICE_URL+"/hyponatemia/{serumSodium}",String.class);
		if(hyponatermia.equalsIgnoreCase("hyponatemia")) {
			String hypertonicity = restTemplate.getForObject(HYPERTONIC_SERVICE_URL+"/Hypertonicity/{serumOsmol}",String.class);
			if(hypertonicity.equalsIgnoreCase("hypertonic")) {
				return "hypertonichyponatermia";
			}
			else {
				return "nothypertonichyponatermia";
			}
		}
		else {
			return "nothypertonichyponatermia";
		}
	}

	

}
