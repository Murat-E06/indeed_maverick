package apiPractice;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class GetBook_id {

    String bUrl="https://restful-booker.herokuapp.com";


    Response response;

    @Test
    public void test1(){
        response = RestAssured.get(bUrl+"/booking");

        System.out.println(response.statusCode());

        response.prettyPrint();

    }
    @Test
    public void testWithPojo(){
        response = RestAssured.get(bUrl+"/booking");

        System.out.println(response.statusCode());

        response.prettyPrint();
        BookingID bookingIDList= response.as(BookingID.class);

    }
    @Test
    public void test2(){
        response=RestAssured.given().accept("application/json")
              .pathParam("id",6223)
                 .when().get(bUrl+"/booking/{id}");

        System.out.println(response.statusCode());

        response.prettyPrint();

        Booking booking1=response.as(Booking.class);
        System.out.println(booking1);
    }
    @Test
    public void test3(){

        response= RestAssured.given().accept("application/json")
                .pathParam("id",6223)
                .when().get(bUrl+"/booking/{id}");



       // System.out.println(booking1.getFirstname());

        System.out.println(response.statusCode());

        response.prettyPrint();

        Assertions.assertEquals(200,response.statusCode());
    }

    @Test
    public void test4(){

        RestAssured .given().accept("application/json")
                .pathParam("id",6223)
                .when().get(bUrl+"/booking/{id}")
                .then().statusCode(200)
                .log().all();

    }



}
