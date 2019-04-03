package com.example.projetmobile;

import com.example.projetmobile.model.RestDescriptionResponse;
import com.example.projetmobile.model.RestPlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIData {

    @GET("planets")
    Call<RestPlanetResponse> listPlanetId();

    @GET("planets")
    Call<RestDescriptionResponse> getPlanetById(@Query("id") Integer id);


}
