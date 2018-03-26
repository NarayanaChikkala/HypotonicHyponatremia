package com.narayana.HypertonicHyponatermia;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HypertoncHyponatermiaController {
	
	protected Logger logger = Logger
			.getLogger(HypertoncHyponatermiaController.class.getName());
	
	@Autowired
	HypertoncHyponatermiaRepository hypertoncHyponatermiaRepository;
	
	@RequestMapping("/HypertoncHyponatermia/{SerumSodium}/{SerumOsmol}")
	public String HypertoncHyponatermia(@PathVariable("SerumSodium") String SerumSodium,@PathVariable("SerumOsmol") String SerumOsmol) {
		logger.info("accounts-changed byId() invoked: " + SerumOsmol);
		String retVal = hypertoncHyponatermiaRepository.gethypertoncHyponatermia(SerumSodium,SerumOsmol);
		logger.info("accounts-microservice byId() found: " + retVal);
		return retVal;
	}

}
