package Tests;

import TestDatalari.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01() {


        // 1- endpoint ve request body olustur

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody = TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //2- expected data olustur
        JSONObject expectedData = TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //3- request gonder ve donen response'i kaydet

        Response response = given().spec(specJsonPlaceHolder)
                .when().body(requestBody.toString()).contentType(ContentType.JSON)
                .put("{pp1}/{pp2}");

        //4-Assertion
        JsonPath responseJP = response.jsonPath();

        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));


    }

}
