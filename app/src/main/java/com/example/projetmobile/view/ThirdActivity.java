package com.example.projetmobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.projetmobile.R;
import com.example.projetmobile.controller.Controller;
import com.example.projetmobile.model.Planet;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ThirdActivity extends Activity {
    public TextView terrain;
    public TextView climate;
    public TextView gravity;
    public TextView name;
    private RecyclerView recyclerView;
    private Controller controller;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //private static final String name = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {





        //int id = (int) getIntent().getSerializableExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        name = (TextView) findViewById(R.id.name);
        terrain = (TextView) findViewById(R.id.terrain);
        climate = (TextView) findViewById(R.id.climate);
        gravity = (TextView) findViewById(R.id.gravity);

        Intent intent= getIntent();
        String jSonDetail = intent.getStringExtra("jSonDetailPlanet");
        //Toast.makeText(getApplicationContext(), jSonDetail, Toast.LENGTH_LONG).show();

        ObjectMapper obj = new ObjectMapper();
        try {
            Planet planet = obj.readValue(jSonDetail, Planet.class);

            final String climateStr = planet.getClimate();
            final String gravityStr = planet.getGravity();
            final String nameStr = planet.getName();
            //Toast.makeText(getApplicationContext(), nameStr, Toast.LENGTH_LONG).show();
            final String terrainStr = planet.getTerrain();
            name.setText(String.valueOf(nameStr));
            climate.setText(climateStr);
            terrain.setText(terrainStr);
            gravity.setText(gravityStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*recyclerView = findViewById(R.id.recycler_view2);

        controller = new Controller(this);
        String name = controller.getPlanet();
        controller.start();

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView*/
    }

    /*public void showList(List<Planet> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new AdapterDescription(list);
        recyclerView.setAdapter(mAdapter);
    }*/
}
