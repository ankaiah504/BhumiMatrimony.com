package com.anki;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = SpringBootPostgresqlApplication.class)
@DirtiesContext

class SpringBootPostgresqlApplicationTests {

	@Test
	void contextLoads() {
	}

}
