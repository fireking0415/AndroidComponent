package org.fireking.commons.mvp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * JsonUtils implement by Gson.
 */
public class GSON {

    public static Gson getGson = new GsonBuilder().disableInnerClassSerialization().create();

    public static String toJsonString(Object object) {
        return getGson.toJson(object);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        if (json == null) return null;
        return getGson.fromJson(json, clazz);
    }

    public static <T> T parseObject(String json, Type type) {
        if (json == null) return null;
        return getGson.fromJson(json, type);
    }

    public static <T> List<T> parseList(String json, Class<T> clazz) {
        if (json == null || json.equals("null") || json.equals("[]")) return new ArrayList<>();
        Type listType = TypeToken.get(List.class).getType();
        Type parameterType = TypeToken.get(clazz).getType();
        Type type = TypeToken.getParameterized(listType, parameterType).getType();
        return getGson.fromJson(json, type);
    }

    public static <T> ArrayList<T> parseArrayList(String json, Class<T> clazz) {
        if (json == null || json.equals("null") || json.equals("[]")) return new ArrayList<>();
        Type listType = TypeToken.get(ArrayList.class).getType();
        Type parameterType = TypeToken.get(clazz).getType();
        Type type = TypeToken.getParameterized(listType, parameterType).getType();
        return getGson.fromJson(json, type);
    }

}