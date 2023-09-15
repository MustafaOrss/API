package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test01() {

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adressJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();

        JSONObject cepTelefonuJsonObj = new JSONObject();
        JSONObject evTelefonuJsonObj = new JSONObject();

        adressJsonObj.put("streetAddress", "naist street");
        adressJsonObj.put("city", "Nara");
        adressJsonObj.put("postalCode", "630-0192");

        cepTelefonuJsonObj.put("type", "iPhone");
        cepTelefonuJsonObj.put("number", "0123-4567-8888");
        evTelefonuJsonObj.put("type", "home");
        evTelefonuJsonObj.put("number", "0123-4567-8910");

        telefonBilgileriArr.put(cepTelefonuJsonObj);
        telefonBilgileriArr.put(evTelefonuJsonObj);

        kisiBilgileriJsonObj.put("firstName", "John");
        kisiBilgileriJsonObj.put("lastName", "Doe");
        kisiBilgileriJsonObj.put("age", 26);

        kisiBilgileriJsonObj.put("address", adressJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", telefonBilgileriArr);


        System.out.println("firstName : " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("lastName : " + kisiBilgileriJsonObj.get("lastName"));

        System.out.println("cadde : "+kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("city : " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));

        System.out.println("cep telefon no : " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));
    }
}
