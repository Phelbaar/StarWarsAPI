package com.example.projetmobile.controller;

import android.util.Log;

import com.example.projetmobile.APIPlanets;
import com.example.projetmobile.model.Planet;
import com.example.projetmobile.model.RestPlanetResponse;
import com.example.projetmobile.view.SecondActivity;
import com.example.projetmobile.view.ThirdActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailController {

    private SecondActivity secondActivity;
    private ThirdActivity thirdActivity;
    private int count;

    private static DetailController detailController = null;

    public static DetailController getInstance(ThirdActivity thirdActivity){
        if(detailController == null){
            detailController = new DetailController(thirdActivity);
        }
        return detailController;
    }

    public DetailController(ThirdActivity thirdActivity){ this.thirdActivity = thirdActivity;}

    public void start() {
        final String name = secondActivity.getIntent().getStringExtra("name");


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIPlanets apiPlanets = retrofit.create(APIPlanets.class);

        Call<RestPlanetResponse> call = apiPlanets.listPlanetId();

        call.enqueue(new Callback<RestPlanetResponse>() {

            @Override
            public void onResponse(Call<RestPlanetResponse> call, Response<RestPlanetResponse> response) {
                RestPlanetResponse restPlanetResponse = response.body();
                List<Planet> descriptionList = restPlanetResponse.getResults();

                //thirdActivity.showList(descriptionList);
            }

            @Override
            public void onFailure(Call<RestPlanetResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }

}
