package com.nyu.db.projServer;

import com.nyu.db.projServer.controller.SetOrderController;
import com.nyu.db.projServer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	@Autowired
	private SetOrderController setOrderController;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
		assertThat(setOrderController).isNotNull();

	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(!this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/set-order/office-list",
                String.class).isEmpty());
	}

	@Autowired
	private OrderService orderService;
	@Test
	void checkVehicleSearchService() throws Exception {
		assertThat(!orderService.getVehicleByOfficeID(1L).isEmpty());
	}


}
