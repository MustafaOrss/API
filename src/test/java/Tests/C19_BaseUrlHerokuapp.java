package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

        1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test
        edin

                    {
                       "firstname" : "Ahmet",
                       "lastname" : “Bulut",
                       "totalprice" : 500,
                       "depositpaid" : false,
                       "bookingdates" : {
                                  "checkin" : "2021-06-01",
                                    "checkout" : "2021-06-10"
                                 },
                                "additionalneeds" : "wi-fi"
                              }


            2- https://restful-booker.herokuapp.com/booking
            endpointine yandaki body’ye sahip bir POST request
            gonderdigimizde donen response’un status code’unun
            200 oldugunu ve “firstname” degerinin “Ahmet”
            oldugunu test edin
     */

    @Test
    public void test01(){
        // 1- endpoint ve request body olustur

        specHerokuapp.pathParam("pp1","booking");

        // 2- expected data olustur


        // 3- request gonder ve donen response'i kaydet

        Response response=given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        //4- Assertion

        JsonPath responseJsonPath = response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size());

        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking", Matchers.hasSize(1600));

    }
}
