package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    /*

    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
    gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
                  Request body
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" :
            {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                         },
            "additionalneeds" : "wi-fi"
            }
 Response Body
                {
                "bookingid": 24,
                "booking":{
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


    @Test
    public void test01() {

        //1 - Endpoint ve request body olustur

        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezTarihleriJson = new JSONObject();

        rezTarihleriJson.put("checkin", "2021-06-01");
        rezTarihleriJson.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", rezTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");


        //2- Expected data olustur

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 24);
        expectedData.put("booking", requestBody);

        //3- request gonderip, donen response'i kaydet

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);

         // 4- Assertion

        JsonPath responseJSonPath= response.jsonPath();
        // ilk yazilan expected --> olusturdugumuz JSonObject : expectedData
        // ikinci yazilan actual --> response : responseJSonPath
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                responseJSonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responseJSonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responseJSonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responseJSonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJSonPath.get("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJSonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJSonPath.get("booking.bookingdates.checkout"));
    }


}

