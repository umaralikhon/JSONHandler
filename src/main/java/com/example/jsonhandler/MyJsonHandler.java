package com.example.jsonhandler;

import java.util.List;

public class MyJsonHandler {
    public String replaceParamValue(String jsonStr, String key, String value) {
        String result;
        result = jsonStr.replaceAll("(\\s*?\"" + key + "\"\\s*?:)(\\s*?\".*?\"\\s*?,)", "$1\"S:" + value + "\",");
        result = result.replaceAll("(\\s*?\"" + key + "\"\\s*?:)(\\s*?\\d*?\\.?\\d*?\\s*?,)", "$1\"D:" + value + "\",");
        return result;
    }

    public String replaceParamValueByList(String jsonStr, List<String> keyList, String value) {
        String result = jsonStr;
        for (String key: keyList) {
            result = result.replaceAll("(\\s*?\"" + key + "\"\\s*?:)(\\s*?\".*?\"\\s*?,)", "$1\"S:" + value + "\",");
            result = result.replaceAll("(\\s*?\"" + key + "\"\\s*?:)(\\s*?\\d*?\\.?\\d*?\\s*?,)", "$1\"D:" + value + "\",");
        }
        return result;
    }
}
