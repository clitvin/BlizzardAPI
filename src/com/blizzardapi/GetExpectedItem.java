
/**
 * Created by Cris on 19/04/2015.
 * Class takes a id for a file name and returns a WowItem Object
 */

package com.blizzardapi;
import com.google.gson.Gson;

import java.io.*;

public class GetExpectedItem {
    public static WowItem getExpectedItem(String id) {
        String path = ("/com/blizzardapi/expectedresults/expected" +id+".txt");
        Gson gson = new Gson();
        InputStream fs = GetExpectedItem.class.getResourceAsStream(path.toString());
        Reader fr = new InputStreamReader(fs);
        return gson.fromJson(fr, WowItem.class);
    }
}
