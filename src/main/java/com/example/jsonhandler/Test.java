package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
public class Test {
    private JSONObject jsonObject;
    private JSONParser jsonParser;
    private String jsonStr;
    private ObjectNode objectNode;
    private ObjectMapper objectMapper;
    private List<String> list;
    private JSONArray jsonArray;
    private ArrayNode arrayNode;

    public Test(String jsonStr) throws JsonProcessingException {
        this.jsonStr = jsonStr;
        objectMapper = new ObjectMapper();
        objectNode = (ObjectNode) objectMapper.readTree(jsonStr);
        arrayNode = objectMapper.createArrayNode();
    }

    public void parseJsonArray(String key, String value) {
//        if (objectNode.has(key)) {
//            JsonNode keyObj = objectNode.get(key);
//            if (keyObj.isArray()) {
//                System.out.println(key + " - IS ARRAY");
//            } else if (keyObj.isObject()) {
//                System.out.println(key + " - IS OBJECT");
//            } else {
//                System.out.println(key + " - ERROR PARSE");
//            }
//        }

        for (Iterator<Map.Entry<String, JsonNode>> it = objectNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> nested = it.next();

            if (nested.getValue().isArray()) {

                System.out.println("ArrayNode: ");
                for (int i = 0; i < nested.getValue().size(); i++) {
                    arrayNode.insert(i, nested.getValue().get(i));
                    arrayNode.insert(i, value);
                    System.out.print(arrayNode.get(i) + " ");
                }

                System.out.println("\n" + "Node: " + objectNode.toPrettyString());
            } else if (nested.getValue() != null) {
                System.out.println(nested.getValue() + " - IS OBJECT");
            } else {
                System.out.println(nested.getValue() + " - ERROR PARSE");
            }
        }
    }
}