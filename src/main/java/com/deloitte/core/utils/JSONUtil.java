package com.deloitte.core.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JSONUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static boolean isValidJSON(String jsonStr) {
        try {
            OBJECT_MAPPER.readTree(jsonStr);
        } catch (IOException ie) {
            return false;
        }
        return true;
    }

    public static <T> T convertValue(Map map, Class<T> valueType) {
        return CallableUtil.call(() -> OBJECT_MAPPER.convertValue(map, valueType));
    }

    public static <T> T readValue(String content, Class<T> valueType) {
        return CallableUtil.call(() -> OBJECT_MAPPER.readValue(content, valueType));
    }

    public static String writeValue(Object obj) {
        return CallableUtil.call(() -> OBJECT_MAPPER.writeValueAsString(obj));
    }

    public static JsonNode readTree(String content) {
        return CallableUtil.call(() -> OBJECT_MAPPER.readTree(content));
    }
}
