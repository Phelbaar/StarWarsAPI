package com.example.projetmobile.view;

import android.accessibilityservice.GestureDescription;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.projetmobile.AdapterName;
import com.example.projetmobile.R;
import com.example.projetmobile.controller.Controller;
import com.example.projetmobile.model.Planet;
import com.example.projetmobile.view.ThirdActivity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class SecondActivity extends Activity{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ProgressBar loader;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);
        loader = findViewById(R.id.loader_second_activity);

        controller = new Controller(this);
        controller.start();
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }
/*
    public void description(){
        Intent intent = new Intent(this, ThirdActivity.class);

        startActivity(intent);
    }
*/
    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<Planet> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new AdapterName(list, new AdapterName.OnItemClickListener() {
            @Override
            public void onItemClick(Planet planet) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("jSonDetailPlanet", ObjectToJSon(planet));
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    public String ObjectToJSon(Planet planet){
        String jSonStr = "";
        ObjectMapper Obj = new ObjectMapper();
        try {
            jSonStr = Obj.writeValueAsString(planet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jSonStr;
    }


}
