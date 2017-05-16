package com.example.escosta.randomuser.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.escosta.randomuser.model.DataUser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by escosta on 14/05/2017.
 */

public class MyService {

    public DataUser getInformation(String end){

        String json;
        DataUser response;
        json = Network.getJson(end);
        Log.i("Result", json);

        response = JSON.parseObject(json, DataUser.class);

        Log.i("Object", response.toString());

        return response;
    }

//    @TargetApi(android.os.Build.VERSION_CODES.N)
//    private DataItem parseJson(String json) {
//        DataItem person = null;
//        try {
//            person = new DataItem();
//
//            JSONObject jsonObj = new JSONObject(json);
//            JSONArray array = jsonObj.getJSONArray("results");
//
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date data;
//
//            JSONObject objArray = array.getJSONObject(0);
//
//            JSONObject obj = objArray.getJSONObject("user");
//
//            //Atribui os objetos que estão nas camadas mais altas
//            person.setEmail(obj.getString("email"));
//            person.setUsername(obj.getString("username"));
//            person.setPassword(obj.getString("password"));
//            person.setPhone(obj.getString("phone"));
//            data = new Date(obj.getLong("dob") * 1000);
//            person.setbDate(sdf.format(data));
//
//            //Nome da person é um objeto, instancia um novo JSONObject
//            JSONObject name = obj.getJSONObject("name");
//            person.setName(name.getString("first"));
//            person.setLastname(name.getString("last"));
//
//            //Endereco tambem é um Objeto
//            JSONObject address = obj.getJSONObject("location");
//            person.setAddress(address.getString("street"));
//            person.setState(address.getString("state"));
//            person.setCity(address.getString("city"));
//
//            //Imagem eh um objeto
//            JSONObject photo = obj.getJSONObject("picture");
//            person.setPicture(downloadImage(photo.getString("large")));
//
//            return person;
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return person;
//        }
//    }

    private Bitmap downloadImage(String url) {
        try {
            URL address;
            InputStream inputStream;
            Bitmap image;
            address = new URL(url);
            inputStream = address.openStream();
            image = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return image;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
