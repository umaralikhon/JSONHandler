package com.example.jsonhandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    private ArrayNode arrayNode;
    private JsonNode jsonNode;

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

    public String replaceParamValue(String jsonStr, String key, String value) throws JSONException, JsonProcessingException {
        objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(jsonStr);

        jsonObject = new JSONObject();

        JsonNode resultValue = objectMapper.readerFor(JsonNode.class).readValue("{\"value\":\"" + value + "\"}");

        if (jsonNode.isTextual()) {
            System.out.println("STATUS: PRIMITIVE \tKEY: " + jsonNode.toString());
        } else if (jsonNode.isInt()) {
            System.out.println("STATUS: PRIMITIVE \tKEY: " + jsonNode.toString());
        }

        jsonNode.fields().forEachRemaining(
                f -> {
                    if (f.getValue().isTextual()) {
                        System.out.println("STATUS: TEXT \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                        if (f.getKey().equals(key)) {
                            f.setValue(resultValue.get("value"));
                            System.out.println("CHANGE: TEXT \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                        }
                    } else if (f.getValue().isInt()) {
                        System.out.println("STATUS: INT \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                        if (f.getKey().equals(key)) {
                            f.setValue(resultValue.get("value"));
                            System.out.println("CHANGE: TEXT \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                        }
                    } else if (f.getValue().isValueNode()) {
                        System.out.println("STATUS: NODE \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                    } else if (f.getValue().isArray()) {
                        System.out.println("STATUS: ARRAY \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());

                        f.getValue().forEach(
                                t -> {
                                    try {
                                        replaceParamValue(t.toString(), key, value);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (JsonProcessingException e) {
                                        e.printStackTrace();
                                    }
                                }
                        );
                    } else if (f.getValue().isObject()) {
                        System.out.println("STATUS: OBJECT \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());

                        try {
                            replaceParamValue(f.getValue().toString(), key, value);
                        } catch (JSONException | JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("STATUS: NONE \tKEY: " + f.getKey() + "\t VALUE: " + f.getValue().toString());
                    }
                }
        );
        return jsonNode.toString();
/*
        while (jsonNode.fields().hasNext()) {
            Map.Entry<String, JsonNode> nested = jsonNode.fields().next();
        }

        if (jsonNode.has(key)) {

            if (jsonNode.get(key).isArray()) {
                for (int i = 0; i < jsonNode.get(key).size(); i++) {
                    arrayNode.insert(i, value);
                }

                objectNode.remove(key);
                objectNode.put(key, arrayNode.toPrettyString());
            } else if (jsonNode.get(key).isObject()) {
                objectNode.put(key, value);
                System.out.println("Object");
            } else if (jsonNode.get(key) != null) {
                objectNode.put(key, value);
            } else {
                System.out.println("Error parse");
            }
        }

        for (Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields(); iter.hasNext(); ) {
            Map.Entry<String, JsonNode> nested = iter.next();

            if (nested.getValue().isArray()) {
                replaceParamValue(nested.getValue().toString(), key, value);
            } else if (nested.getValue().isObject()) {
                replaceParamValue(nested.getValue().toString(), key, value);
            }
        }

        System.out.println(jsonNode.toPrettyString());*/
    }
}
