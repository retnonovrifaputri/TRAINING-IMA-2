package com.eno.userss.portalberita.Network;

import com.eno.userss.portalberita.BuildConfig;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getInstancee(){
        return setInit().create(ApiService.class);
    }
}
