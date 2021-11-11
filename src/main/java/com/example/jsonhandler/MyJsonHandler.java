package com.example.jsonhandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.Iterator;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyJsonHandler {
    private static ObjectNode objectNode = null;
    private ObjectMapper objectMapper;
    private ObjectNode[] objectNodes;
    private JSONArray jsonArray;

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
//
//            if (nested.getValue().isArray()) {
//                ArrayNode arr = objectMapper.createArrayNode();
//                for (JsonNode a : arr)
//                    replaceParamValue((ObjectNode) nested.getValue(), key, value);
//            }
//        }
//    }


    public void replaceParamValue(ObjectNode objectNode, String key, String value) {
        if (objectNode.has(key))
            objectNode.put(key, value);


        for (Iterator<Map.Entry<String, JsonNode>> iterator = objectNode.fields(); iterator.hasNext(); ) {
            Map.Entry<String, JsonNode> nested = iterator.next();

            if (nested.getValue().isObject() && !nested.getValue().isArray()) {
                replaceParamValue((ObjectNode) nested.getValue(), key, value);
            }

//            if (nested.getValue().isArray()) {
//                jsonArray = new JSONArray();
//                jsonArray.put(nested.getValue());
//
//                for(int i = 0; i < jsonArray.length(); i++){
////                    jsonArray.put(i, value);
//                }
//            }
        }
    }
}