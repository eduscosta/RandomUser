package com.example.escosta.randomuser.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by escosta on 16/05/2017.
 */

public class Network {
    public static String getJson(String address){
        String result = "";
        InputStream is;
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new IOException("Got response code " + responseCode);
            }
            is = connection.getInputStream();

            result = inputStreamToString(is);

            is.close();

            connection.disconnect();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String inputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String row;

            br = new BufferedReader(new InputStreamReader(is));

            while ((row = br.readLine()) != null){
                buffer.append(row);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
