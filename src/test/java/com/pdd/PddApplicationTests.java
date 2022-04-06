package com.pdd;

import com.pdd.model.Pdd;
import com.pdd.service.PddService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PddApplicationTests {
	@Autowired
	private PddService pddService;
	@Test
	void contextLoads() {
		for (Pdd pdd : pddService.findByTypeN("裤子")) {
			System.out.println(pdd);
		}
		
		
	}
	
}
