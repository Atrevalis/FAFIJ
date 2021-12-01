package com.example.fafij.models.Network;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.fafij.FafijApp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    public static String BASE_URL ="http://192.168.0.103:8081/";
    private static Retrofit retrofit;
    public static RetrofitApiInterface getClient(){
        if(retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor);
            FafijApp q = new FafijApp();
            String header = "";
            header += "Bearer " + q.getToken();
            String finalHeader = header;
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("Authorization", finalHeader).build();
                return chain.proceed(request);
            });
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client.build())
                    .build();
        }
        return retrofit.create(RetrofitApiInterface.class);
    }
}
