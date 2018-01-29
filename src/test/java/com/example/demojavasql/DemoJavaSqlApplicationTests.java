package com.example.demojavasql;

import com.example.demojavasql.dto.AccessDTO;
import com.example.demojavasql.repository.AccessRepository;
import com.example.demojavasql.service.AccessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJavaSqlApplicationTests {

	@Autowired
	private AccessService accessService;

	@Test
	public void contextLoads() {
	}


	@Test
	public void ipSearcherSuccess() throws ParseException {
		AccessDTO access = this.accessService.findIp("2017-01-01 01:00:00"
				,"2017-01-01 02:00:00",1,200);
		assertEquals("192.168.130.161", access.getMessage());

	}

	@Test
	public void ipSearcherNotFound() throws ParseException {
		AccessDTO access = this.accessService.findIp("2018-01-01 01:00:00"
				,"2018-01-01 02:00:00",1,200);
		assertEquals("There is no result for this particular request", access.getMessage());

	}

	@Test
	public void ipSearcherThresholdToHigh() throws ParseException {
		AccessDTO access = this.accessService.findIp("2017-01-01 02:35:00"
				,"2017-01-01 03:35:00",1,200);
		assertEquals("The repeated ip for this range of time does not reach the minimum threshold", access.getMessage());

	}

}
