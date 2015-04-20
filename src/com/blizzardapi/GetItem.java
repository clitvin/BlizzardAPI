/**
 * Created by Cris on 19/04/2015.
 * Simple class that takes a string id and returns an item object
 */
package com.blizzardapi;

import com.google.gson.Gson;

public class GetItem {

        public static WowItem getItem(String Id) {
            String json = APIConnection.getStringJSONFromRequest("http://us.battle.net/api/wow/item/" + Id);
            Gson gson = new Gson();
            return gson.fromJson(json, WowItem.class);
        }

}
