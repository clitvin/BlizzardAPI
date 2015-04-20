package com.blizzardapi;

/**
 * Created by Cris on 19/04/2015.
 * Simple class that takes a string id and returns an WowItemSet object
 */
import com.google.gson.Gson;

public class GetItemSet {

    public static WowItemSet getItemSet(String Id) {
        String json = APIConnection.getStringJSONFromRequest("http://us.battle.net/api/wow/item/set/" + Id);
        Gson gson = new Gson();
        return gson.fromJson(json, WowItemSet.class);
    }

}