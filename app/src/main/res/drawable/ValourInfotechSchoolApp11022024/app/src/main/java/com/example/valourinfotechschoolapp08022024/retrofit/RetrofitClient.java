package com.example.valourinfotechschoolapp08022024.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static ApiServices getClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://schoolmobile.allsoft.online/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices apiServices=retrofit.create(ApiServices.class);
        return apiServices;
    }
}
