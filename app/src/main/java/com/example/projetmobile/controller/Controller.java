package com.example.projetmobile.controller;

import android.app.Activity;
import android.util.Log;

import com.example.projetmobile.APIData;
import com.example.projetmobile.view.SecondActivity;
import com.example.projetmobile.view.ThirdActivity;
import com.example.projetmobile.model.Planet;
import com.example.projetmobile.model.RestPlanetResponse;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller{

    private SecondActivity secondActivity;
    private int count;

    private static Controller controller = null;

    public static Controller getInstance(SecondActivity secondActivity){
        if(controller == null){
            controller = new Controller(secondActivity);
        }
        return controller;
    }

    public Controller(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }


    public void start() {

        secondActivity.showLoader();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIData apiData = retrofit.create(APIData.class);


        Call<RestPlanetResponse> call = apiData.listPlanetId();

        call.enqueue(new Callback<RestPlanetResponse>() {
            @Override
            public void onResponse(Call<RestPlanetResponse> call, Response<RestPlanetResponse> response) {
                RestPlanetResponse restPlanetResponse = response.body();
                List<Planet> planetList = restPlanetResponse.getResults();

                secondActivity.showList(planetList);
                secondActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<RestPlanetResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }
}
