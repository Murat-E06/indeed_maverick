package apiPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteBook {

    String bUrl = "https://restful-booker.herokuapp.com";


    Response response;

    @DisplayName("DELETE with text")
    @Test
    public void test1() {



        response= RestAssured
                .given()
                .contentType("application/json")
                .pathParam("id",12282)
                .auth().basic("admin","password123")
                .cookie("token=abc123")
                .when()
                .delete(bUrl+"/booking/{id}");

        System.out.println(response.statusCode());

        response.prettyPrint();


    }

    @DisplayName("POST with text")
    @Test
    public void test2() {

        String bodyRequest="{\n" +
                "    \"firstname\" : \"Zeynep\",\n" +
                "    \"lastname\" : \"Beyza\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured
                .given()
                .accept("application/json")
                .contentType("application/json")
                .body(bodyRequest)
                .when()
                .delete(bUrl+"/booking")
                .then()
                .statusCode(200)
                .log().all();





    }
}
