package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;


public class JsonHandlerApplication {

    public static void main(String[] args) throws JSONException, ParseException, JsonProcessingException {

        String jsonStr = "{\n" +
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
//                "        \"Description\": \"Returns all cases by case type for a country from the first recorded case. \",\n" +
//                "        \"Path\": \"/dayone/country/:country\"\n" +
//                "    }\n" +
//                "}";

        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectNode objectNode = (ObjectNode) objectMapper.readTree(jsonStr);
        ObjectNode objectNode2 = (ObjectNode) objectMapper.readTree(jsonStr);
        MyJsonHandler jsonHandler = new MyJsonHandler();

//        jsonHandler.replaceParamValue(objectNode, "Name", "*****");
//        jsonHandler.replaceParamValue(objectNode, "Description", "######");
//        jsonHandler.replaceParamValue(objectNode, "Path", "@@@@@@@");

//        jsonHandler.replaceParamValue(objectNode2, "cars", "*****");

//        System.out.println(objectNode.toPrettyString());
//        System.out.println("######################");
//        System.out.println(objectNode2.toPrettyString());

        System.out.println("##################################################");

        Test test = new Test(jsonStr);
        test.parseJsonArray("cars", "***");
    }
}

