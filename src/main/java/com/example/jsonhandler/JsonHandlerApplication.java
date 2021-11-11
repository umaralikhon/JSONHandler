package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;


public class JsonHandlerApplication {

    public static void main(String[] args) throws JSONException, ParseException, JsonProcessingException {

        String jsonStrArr = "{\n" +
                "\"name\":\"John\",\n" +
                "\"age\":30,\n" +
                "\"cars\":[\"Ford\", \"BMW\", \"Fiat\"]\n" +
                "}";

//        String jsonStr = "{\n" +
//                "    \"countriesRoute\": {\n" +
//                "        \"Name\": \"Get List Of Countries\",\n" +
//                "        \"Description\": \"Returns all countries and associated provinces. The country_slug variable is used for country specific data\",\n" +
//                "        \"Path\": \"/countries\"\n" +
//                "    },\n" +
//                "    \"countryDayOneRoute\": {\n" +
//                "        \"Name\": \"Get List Of Cases Per Country Per Province By Case Type From The First Recorded Case\",\n" +
//                "        \"Description\": \"Returns all cases by case type for a country from the first recorded case. Country must be the country_slug from /countries. Cases must be one of: confirmed, recovered, deaths\",\n" +
//                "        \"Path\": \"/dayone/country/:country\"\n" +
//                "    },\n" +
//                "    \"countryDayOneTotalRoute\": {\n" +
//                "        \"Name\": \"Get List Of Cases Per Country By Case Type From The First Recorded Case\",\n" +
//                "        \"Description\": \"Returns all cases by case type for a country from the first recorded case. Country must be the country_slug from /countries. Cases must be one of: confirmed, recovered, deaths\",\n" +
//                "        \"Path\": \"/total/dayone/country/:country\"\n" +
//                "    },\n" +
//                "    \"countryRoute\": {\n" +
//                "        \"Name\": \"Get List Of Cases Per Country Per Province By Case Type\",\n" +
//                "        \"Description\": \"Returns all cases by case type for a country. Country must be the country_slug from /countries. Cases must be one of: confirmed, recovered, deaths\",\n" +
//                "        \"Path\": \"/country/:country\"\n" +
//                "    },\n" +
//                "    \"countryRoutePremium\": {\n" +
//                "        \"Name\": \"Premium Data: Get List Of Cases Per Country By Case Type\",\n" +
//                "        \"Description\": \"Returns all cases by case type for a country. Country must be the country_slug from /countries. Cases must be one of: confirmed, recovered, deaths\",\n" +
//                "        \"Path\": \"/premium/country/:country\"\n" +
//                "    }" +
//                "}";


        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectNode objectNode = (ObjectNode) objectMapper.readTree(jsonStr);
        ObjectNode objectNode2 = (ObjectNode) objectMapper.readTree(jsonStrArr);
        MyJsonHandler jsonHandler = new MyJsonHandler();

//        jsonHandler.replaceParamValue(objectNode, "Name", "*****");
//        jsonHandler.replaceParamValue(objectNode, "Description", "######");
//        jsonHandler.replaceParamValue(objectNode, "Path", "@@@@@@@");

        jsonHandler.replaceParamValue(objectNode2, "cars", "*****");

//        System.out.println(objectNode.toPrettyString());
        System.out.println("######################");
        System.out.println(objectNode2.toPrettyString());
    }
}

