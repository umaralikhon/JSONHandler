package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class JsonHandlerApplication {

    public static void main(String[] args) throws JSONException, JsonProcessingException, ParseException {

//        String jsonStr = "{\n" +
//                "\"name\":\"John\",\n" +
//                "\"age\":30,\n" +
//                "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]\n" +
//                "}";

//        String jsonStr = "{\"cars\": [\"Ford\", \"BMW\", \"Fiat\"]}";

//        String jsonStr = "{\n" +
//                "    \"countriesRoute\": {\n" +
//                "        \"Name\": \"Get List Of Countries\",\n" +
//                "        \"Description\": \"Returns all countries and associated provinces. The country_slug variable is used for country specific data\",\n" +
//                "        \"Path\": \"/countries\"\n" +
//                "   }" +
//                "}";

        String jsonStr = "{\n" +
                "    \"name\":\"John\",\n" +
                "    \"age\":302,\n" +
                "    \"cars\": [\n" +
                "        { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },\n" +
                "        { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },\n" +
                "        { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }\n" +
                "     ]\n" +
                " } ";

        System.out.println("###########################################################");

        List<String> keyList = new ArrayList<>();
        keyList.add("name");
        keyList.add("age");

        MyJsonHandler handler = new MyJsonHandler();
        System.out.println(handler.replaceParamValueByList(jsonStr, keyList, "****"));
    }
}
