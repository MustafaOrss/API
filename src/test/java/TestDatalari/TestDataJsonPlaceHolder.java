package TestDatalari;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestDataJsonPlaceHolder {


           public static int basariliSorguStatusCode=200;
           public static String contentType = "application/json; charset=utf-8";
           public static String headerConnection = "keep-alive";

    public static JSONObject responseBodyOlustur22() {
        JSONObject expectedDATA = new JSONObject();
            expectedDATA.put("userId", 3);
            expectedDATA.put("id", 22);
            expectedDATA.put("title", "dolor sint quo a velit explicabo quia nam");
            expectedDATA.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

            return expectedDATA;
        }

        public static JSONObject responseJsonBodyOlustur(int userId,int id, String title, String body){
            JSONObject expectedDATA = new JSONObject();
            expectedDATA.put("userId",userId);
            expectedDATA.put("id",id);
            expectedDATA.put("title", title);
            expectedDATA.put("body", body);

            return expectedDATA;
        }

        /*
        Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

         */

        public static Map<String, Object> bodyOlustur(){
            Map<String, Object> bodyMap= new HashMap<>();
            bodyMap.put("title","Ahmet");
            bodyMap.put("body","Merhaba");
            bodyMap.put("userId",10.0);
            bodyMap.put("id",70.0);

            return bodyMap;
        }
}


