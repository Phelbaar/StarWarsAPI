package com.example.projetmobile;

import com.example.projetmobile.model.RestPlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIData {
    public static final String ENDPOINT = "https://swapi.co/api/";

    @GET("planets/")
    Call<RestPlanetResponse> listPlanetId();
}
