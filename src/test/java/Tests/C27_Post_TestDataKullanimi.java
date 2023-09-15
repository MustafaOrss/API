package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {
    @Test
    public void test01(){


    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir post request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu tes    t edin.

                 Request body
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

                       Expected Response Body
           {
                        "bookingid": 24,
                        "booking": {
                                   "firstname": "Ahmet",
                                 "lastname": "Bulut",
                                 "totalprice": 500,
                                 "depositpaid": false,
                                 "bookingdates": {
                                 "checkin": "2021-06-01",
                                 "checkout": "2021-06-10"
                                            },
                        "additionalneeds": "wi-fi"
                                    }
                         }
*/

        // 1- request body olustur
        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody = TestDataHerokuapp.jsonRequestBodyOlustur("2021-06-01","2021-06-10","Ahmet","Bulut",
                                                                            500,false, "wi-fi");

        // 2- soruda varsa expected data olustur

        JSONObject expectedData = TestDataHerokuapp.jsonExpectedBodyOlustur();

        // 3 - Request gonder donen response'i kaydet

        Response response = given()
                .spec(specHerokuapp)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post("{pp1}");


        // 4- Assertion

        JsonPath responseJP = response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").getString("firstname")
        ,responseJP.getString("booking.firstname"));


        assertEquals(expectedData.getJSONObject("booking").getString("lastname")
                ,responseJP.getString("booking.lastname"));

        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice")
                ,responseJP.getInt("booking.totalprice"));

        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid")
                ,responseJP.getBoolean("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds")
                ,responseJP.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin")
                ,responseJP.getString("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout")
                ,responseJP.getString("booking.bookingdates.checkout"));
    }
}
