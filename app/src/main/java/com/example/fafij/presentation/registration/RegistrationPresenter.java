package com.example.fafij.presentation.registration;

import android.os.AsyncTask;

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

public class RegistrationPresenter implements RegistrationContract.RegistrationPresenterInterface {

    public RegistrationContract.RegistrationViewInterface view;

    public RegistrationPresenter(RegistrationContract.RegistrationViewInterface view) {
        this.view = view;
    }

    public class postRequest extends AsyncTask<String, String, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            int code = 0;
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("login", strings[0]);
                jsonObject.put("password", strings[1]);
                OkHttpClient httpClient = new OkHttpClient();
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = RequestBody.create(jsonObject.toString(), JSON);
                Request request = new Request.Builder()
                        .url("http://:8081" + strings[2])
                        .post(requestBody)
                        .build();
                Response response = httpClient.newCall(request).execute();

                int networkResponse = response.code();
                if (networkResponse != 0) {
                    code = networkResponse;
                }
            } catch (Exception e) {
                return 0;
            }
            return code;
        }

        @Override
        protected void onPostExecute(Integer code) {
            super.onPostExecute(code);
            String toast = "";
            if (code == 0) toast = "Неизвестная ошибка";
            if (code == 201) toast = "Аккаунт создан";
            if (code == 202) toast = "Вход успешен";
            if (code == 406) toast = "Ошибка входа. Неправильное имя пользователя или пароль.";
            if (code == 500) toast = "Пользователь уже существует.";
            view.testtest(toast);
        }
    }
    /**
     * Проверяет на наличие логина в БД,
     * хэширует пароль,
     * создаёт и входит в аккаунт.
     * @param login логин пользователя
     * @param password пароль пользователя
     */
    @Override
    public void onRegistrationClick(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        new postRequest().execute(login, hashPass(password), "/registration");
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
