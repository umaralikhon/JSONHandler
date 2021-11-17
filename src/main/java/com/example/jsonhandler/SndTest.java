package com.example.jsonhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map;

public class SndTest {
    private JsonNode jsonNode;
    private ObjectNode objectNode;
    private ObjectMapper objectMapper;
    private ArrayNode arrayNode;

    public void replaceParamValue(String jsonStr, String key, String value) throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(jsonStr);
        objectNode = (ObjectNode) jsonNode;

        for (Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields(); iter.hasNext(); ) {
            Map.Entry<String, JsonNode> nested = iter.next();

//            if (jsonNode.has(key)) {
//                objectNode.put(key, value);
//            }

            if(nested.getValue().isArray()){
                arrayNode = objectMapper.createArrayNode();

                for (int i = 0; i < nested.getValue().size(); i++) {
                    arrayNode.insert(i, value);
                }

                objectNode.put(key, String.valueOf(arrayNode));
            }else if(nested.getValue().isObject()){
                replaceParamValue(jsonNode.toPrettyString(), key, value);
            }
        }

        System.out.println(objectNode.toPrettyString());
        System.out.println(jsonNode.toPrettyString());
    }
}
