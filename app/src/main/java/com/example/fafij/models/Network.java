package com.example.fafij.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Network {

    public static JSONObject postRequest(JSONObject json, String type) throws JSONException {
        JSONObject jsonResponse = null;
        try {
        OkHttpClient httpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(json.toString(), JSON);
        Request request = new Request.Builder()
                .url("localhost:8081" + type)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(request).execute();

        String networkResponse = response.body().string();

        if (!networkResponse.isEmpty()) {
            jsonResponse = new JSONObject(networkResponse);
        }
        } catch (Exception e) {
            String error = String.format("{\"Error\":\"%s\"}", e.getMessage());
            jsonResponse = new JSONObject(error);
        }
        return jsonResponse;
    }

    public static String hashPass(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 512, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        BigInteger bi = new BigInteger(1, hash);
        String hex = bi.toString(16);
        int paddingLength = (hash.length * 2) - hex.length();
        if(paddingLength > 0) return String.format("%0"  +paddingLength + "d", 0) + hex;
        else return hex;
    }
}
