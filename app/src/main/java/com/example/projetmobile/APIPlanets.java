package com.example.projetmobile;

import com.example.projetmobile.model.RestPlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIPlanets {

    @GET("planets")
    Call<RestPlanetResponse> listPlanetId();

}

