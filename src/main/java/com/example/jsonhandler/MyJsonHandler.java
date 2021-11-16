package com.example.jsonhandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyJsonHandler {
    private static ObjectNode objectNode = null;
    private ObjectMapper objectMapper;
    private ObjectNode[] objectNodes;
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    private JSONParser jsonParser;

    private String str = null;
    //TODO: Working code
//    public void replaceParamValue(ObjectNode objectNode, String key, String value) {
//        if (objectNode.has(key))
//            objectNode.put(key, value);
//
//        for (Iterator<Map.Entry<String, JsonNode>> it = objectNode.fields(); it.hasNext(); ) {
//            Map.Entry<String, JsonNode> nested = it.next();
//
//            if (nested.getValue().isObject()) {
//                replaceParamValue((ObjectNode) nested.getValue(), key, value);
//            }
//        }
//
//        System.out.println(objectNode.toPrettyString());
//    }

    public void replaceParamValue(ObjectNode objectNode, String key, String value) throws JSONException {
        if (objectNode.has(key)) {
            JsonNode keyObj = objectNode.get(key);
            if (keyObj.isArray()) {
                System.out.println(key + " - IS ARRAY");
            } else if (keyObj.isObject()) {
                System.out.println(key + " - IS OBJECT");
            } else {
                System.out.println(key + " - ERROR PARSE");
            }
        }
        jsonArray.put(objectNode);

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonArray.put(i, value);
        }
//            objectNode.put(key, value);

//        else if(objectNode.has(key)&&objectNode.isObject()){
//            objectNode.put(key, value);
//        }


        for (Iterator<Map.Entry<String, JsonNode>> it = objectNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> nested = it.next();

            if (nested.getValue().isObject()) {
                replaceParamValue((ObjectNode) nested.getValue(), key, value);
            }
        }

        System.out.println(objectNode.toPrettyString());
    }
}
