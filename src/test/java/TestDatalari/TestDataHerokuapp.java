package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    /*
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
     */

    
    public static JSONObject jsonRequestBodyOlustur(String checkIn, String checkOut, String firstName, String lastName,
                                                    int totalPrice, boolean depositPaid, String additionalneeds) {

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDateBody = new JSONObject();

        bookingDateBody.put("checkin", checkIn);
        bookingDateBody.put("checkout", checkOut);

        requestBody.put("firstname", firstName);
        requestBody.put("lastname", lastName);
        requestBody.put("totalprice", totalPrice);
        requestBody.put("depositpaid", depositPaid);
        requestBody.put("bookingdates", bookingDateBody);
        requestBody.put("additionalneeds", additionalneeds);

        return requestBody;

    }

    /*
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

    public static JSONObject jsonExpectedBodyOlustur() {

        JSONObject expectedBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur("2021-06-01", "2021-06-10", "Ahmet", "Bulut",
                500, false, "wi-fi");

        expectedBody.put("bookingid", 24);
        expectedBody.put("booking", bookingBody);

        return expectedBody;
    }

        /*
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

         */

    public static Map<String,Object> requestBodyMapOlustur()
    {
        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname","Ahmet");
        requestBodyMap.put("lastname","Bulut");
        requestBodyMap.put("totalprice",500.);
        requestBodyMap.put("depositpaid",false);
        requestBodyMap.put("bookingdates",bookingdatesMapOlustur());
        requestBodyMap.put("additionalneeds","wi-fi");

        return requestBodyMap;
    }

    public static Map<String,String> bookingdatesMapOlustur(){

        Map<String,String> bookingdatesMap = new HashMap<>();

        bookingdatesMap.put("checkin","2021-06-01");
        bookingdatesMap.put("checkout","2021-06-10");

        return bookingdatesMap;

    }

        /*
        Response Body // expected data
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

   public static Map<String, Object> responseBodyMapOlustur(){

       Map<String,Object> responseBodyMap = new HashMap<>();
       responseBodyMap.put("bookingid",24);
       responseBodyMap.put("booking",requestBodyMapOlustur());

       return responseBodyMap;

   }

}
