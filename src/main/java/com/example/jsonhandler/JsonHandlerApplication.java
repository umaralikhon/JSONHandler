package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.Map;


public class JsonHandlerApplication {

    public static void main(String[] args) throws JSONException, ParseException, JsonProcessingException {

//        String jsonStr = "{\n" +
//                "\"name\":\"John\",\n" +
//                "\"age\":30,\n" +
//                "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]\n" +
//                "}";

//        String jsonStr = "{\"cars\": [\"Ford\", \"BMW\", \"Fiat\"]}";

        String jsonStr = "{\n" +
                "    \"countriesRoute\": {\n" +
                "        \"Name\": \"Get List Of Countries\",\n" +
                "        \"Description\": \"Returns all countries and associated provinces. The country_slug variable is used for country specific data\",\n" +
                "        \"Path\": \"/countries\"\n" +
                "    },\n" +
                "    \"countryDayOneRoute\": {\n" +
                "        \"Name\": \"Get List Of Cases Per Country Per Province By Case Type From The First Recorded Case\",\n" +
                "        \"Description\": \"Returns all cases by case type for a country from the first recorded case. \",\n" +
                "        \"Path\": \"/dayone/country/:country\"\n" +
                "    }\n" +
                "}";

//        String jsonStr = "{\n" +
//                "    \"name\":\"John\",\n" +
//                "    \"age\":30,\n" +
//                "    \"cars\": [\n" +
//                "        { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },\n" +
//                "        { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },\n" +
//                "        { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }\n" +
//                "     ]\n" +
//                " } ";

        System.out.println("###########################################################");

//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        System.out.println("OLD: " + jsonStr);

        MyJsonHandler jsonHandler = new MyJsonHandler();
        String newStr = jsonHandler.replaceParamValue(jsonStr, "Name", "******");

        System.out.println("NEW: " + newStr);
    }
}

