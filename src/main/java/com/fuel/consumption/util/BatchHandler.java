/**
package com.fuel.consumption.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BatchHandler {

    private Map<String, Object> keyValuePairs;

    public BatchHandler() {
        keyValuePairs = new HashMap<>();
    }

    public void handleJSONArray(JSONArray jsonArray, String key) {
        jsonArray.iterator().forEachRemaining(element -> handleValue(key, element));
    }

    void handleValue(String key, Object value) {
        if (value instanceof JSONObject) {
            handleJSONObject((JSONObject) value);
        } else if (value instanceof JSONArray) {
            handleJSONArray((JSONArray) value, key);
        }
        keyValuePairs.put(key, value);
    }

    void handleJSONObject(JSONObject jsonObject) {
        jsonObject.keys().forEachRemaining(key -> {
            Object value = jsonObject.get(key);
            handleValue(key, value);
        });
    }
}
*/
