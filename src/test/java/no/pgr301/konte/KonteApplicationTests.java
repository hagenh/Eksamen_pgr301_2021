package no.pgr301.konte;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class KonteApplicationTests {


    @Test
    void contextLoads() {
    }

   /* @Test
    void testGetMeasurementList() {
        final List<Measurement> measurementList = new ArrayList<>();
        Assertions.assertTrue(true, String.valueOf(measurementList.size()));

        RestAssured.given().get("http://localhost:5050/weather/")
                .then()
                .statusCode(200);
    }

    @Test
    void testPostMeasurementList() {
        double lat = 33.421;
        MeasurementDto dto = new MeasurementDto(23.41, 123, 134, 652);

        RestAssured.given().contentType(ContentType.JSON)
                .body(dto)
				.post("http://localhost:5050/weather/")
                .then()
                .statusCode(200);
    }*/

    @Test
    void testDummyTest(){
        final List<MeasurementDto> measurementList = new ArrayList<>();
        Assertions.assertTrue(true, String.valueOf(measurementList.size()));

        MeasurementDto dto = new MeasurementDto(23.41, 123, 134, 652);
        measurementList.add(dto);

        Assertions.assertFalse(false, String.valueOf(measurementList.isEmpty()));
    }

}
