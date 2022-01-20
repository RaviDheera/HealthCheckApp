package com.mobile.healthcheck.service;

import com.mobile.healthcheck.model.Object;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceInterface {

    String BASE_URL = "https://dev.smef.online/api/otp-mgmt/";
    @GET("health-check")
    Call<Object> healthCheck();
}
