package com.example.fafij.models.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    public static String BASE_URL ="http://:8081/";
    private static Retrofit retrofit;
    public static RetrofitApiInterface getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiInterface.class);
    }
}
