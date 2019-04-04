package com.example.projetmobile;

import com.example.projetmobile.model.RestDescriptionResponse;
import com.example.projetmobile.model.RestPlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIPlanets {

    @GET("planets")
    Call<RestPlanetResponse> listPlanetId();

    //@GET("planets/{:id}")
    //Call<RestDescriptionResponse> getPlanetById(@Path("id") Integer id);
}

