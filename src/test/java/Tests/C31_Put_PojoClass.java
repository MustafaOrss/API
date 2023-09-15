package Tests;

import TestDatalari.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceHolder {

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

        // 1- request url ve body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 2- soruda varsa expected data olustur

        PojoJsonPlaceholder expectedDataPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);



        // 3- response olustur ve request gonderip sonucu response'a ata

        Response response = given()
                .spec(specJsonPlaceHolder)
                .contentType(ContentType.JSON)
                .body(requestBodyPojo)
                .when()
                .put("{pp1}/{pp2}");
     PojoJsonPlaceholder responsePojo = response.as(PojoJsonPlaceholder.class);

        // 4- Assert
        // expected data (Pojo) <====> response (Pojo)

        // status kodunun 200
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());

        // content type'nin "application/json; charset = utf-8",
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());

        // connection header degerinin "keep-alive"

        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));

        // response body'sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());


    }

}
