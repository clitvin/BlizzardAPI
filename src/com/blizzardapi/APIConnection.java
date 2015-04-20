/**
 * Created by Cris on 19/04/2015.
 * Simple class that takes a string URL and returns a string json
 */
package com.blizzardapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIConnection {
    public static String getStringJSONFromRequest(String url) {
        String ret = "";
        BufferedReader reader = null;
        HttpURLConnection urlConnection;

        try {
            urlConnection = (HttpURLConnection) new URL(url).openConnection();
            String line;
            StringBuilder sb = new StringBuilder();
            int responseCode = urlConnection.getResponseCode();
            if((responseCode == 404) || (responseCode == 500)) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            ret = sb.toString();
        } catch (IOException e1) {
            ret = "{\"status\":\"nok\", \"reason\":\"URL Connection Error\"}";
        }
        finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException ignored) {
            }

        }
        return ret;
    }
}
