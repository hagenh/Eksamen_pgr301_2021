package no.pgr301.konte;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class KonteApplicationTests {

	private final List<Measurement> measurementList = new ArrayList<>();

	@Test
	void contextLoads() {
	}

	/*@Test
	boolean testWillFail(){
		//measurementList.size() == 2;
		String test = "Test";
		return assertTrue(test, "Tost");
	}*/

}
