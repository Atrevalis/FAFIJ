package com.example.fafij.models.Network;

import com.example.fafij.models.data.LogIn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitApiInterface {

    @POST("login")
    Call<LogIn> logInPost(@Body LogIn logIn);

    @POST("registration")
    Call<LogIn> regInPost(@Body LogIn logIn);



}
