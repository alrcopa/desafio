package br.com.requeijo.desafio;

import br.com.requeijo.desafio.service.CasaPopularServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		CasaPopularServiceTest.class
})
class DesafioApplicationTests {

	@Test
	void contextLoads() {
	}

}
