package com.example.projetmobile.controller;

import android.util.Log;

import com.example.projetmobile.APIData;
import com.example.projetmobile.model.Description;
import com.example.projetmobile.model.Planet;
import com.example.projetmobile.model.RestDescriptionResponse;
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

    private ThirdActivity thirdActivity;
    private int count;

    private static Controller controller = null;

    public static Controller getInstance(SecondActivity secondActivity){
        if(controller == null){
            controller = new Controller(secondActivity);
        }
        return controller;
    }

    public DetailController(ThirdActivity thirdActivity){ this.thirdActivity = thirdActivity;}

    public void start(int id) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIData apiData = retrofit.create(APIData.class);


        Call<RestDescriptionResponse> call = apiData.getPlanetById(id);

        call.enqueue(new Callback<RestDescriptionResponse>() {
            @Override
            public void onResponse(Call<RestDescriptionResponse> call, Response<RestDescriptionResponse> response) {
                RestDescriptionResponse restDescriptionResponse = response.body();
                List<Description> descriptionList = restDescriptionResponse.getResults();

                thirdActivity.showList(descriptionList);
            }

            @Override
            public void onFailure(Call<RestDescriptionResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }
}
