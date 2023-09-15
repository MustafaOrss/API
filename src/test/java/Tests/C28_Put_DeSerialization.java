package Tests;

import TestDatalari.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceHolder {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
    oldugunu test ediniz

                Request Body
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
             }

        Expected Data :
            {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
            }
     */

    @Test
    public void test01(){
        // 1 - endpoint ve request body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);
        Map<String,Object> requestBody = TestDataJsonPlaceHolder.bodyOlustur();


        // 2- soruda varsa expedted data olustur
        Map<String, Object> expectedData = TestDataJsonPlaceHolder.bodyOlustur();


        // 3- request gonder donen response'i kaydet
        Response response = given(specJsonPlaceHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .put("{pp1}/{pp2}");

        // 4- Assertion
       // expected response body <=====> response
       //       Map                      Response
       // Assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (De-Serialization)

       Map<String, Object> responseMap = response.as(HashMap.class);
        assertEquals(expectedData.get("title"), responseMap.get("title"));

        assertEquals(expectedData.get("body"), responseMap.get("body"));
        assertEquals(expectedData.get("id"), responseMap.get("id"));
        assertEquals(expectedData.get("userId"), responseMap.get("userId"));
    }
}
