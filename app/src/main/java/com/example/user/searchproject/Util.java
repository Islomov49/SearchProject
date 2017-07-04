package com.example.user.searchproject;

import com.example.user.searchproject.Model.SearchItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03.07.17.
 */

public class Util {
    public static List<SearchItem> parseJson(String json) throws JSONException {
        String title;
        String snippet;
        JSONObject item;
        List<SearchItem> items = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        JSONArray array = obj.getJSONArray("items");

        for (int i = 0; i < array.length(); i++) {
            item = array.getJSONObject(i);
            title = item.getString("title");
            snippet = item.getString("snippet");
            items.add(new SearchItem(title, snippet));
        }

        return items;
    }
}
