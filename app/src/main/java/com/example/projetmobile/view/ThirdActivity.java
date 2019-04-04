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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

public class ThirdActivity extends Activity {
    public TextView terrain;
    public TextView climate;
    public TextView gravity;
    public TextView name;
    public TextView rotation_period;
    public TextView orbital_period;
    public TextView diameter;
    public TextView surface_water;
    public TextView population;
    public TextView residents;
    public TextView films;
    public TextView created;
    public TextView edited;
    public TextView url;


    private RecyclerView recyclerView;
    private Controller controller;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //private static final String name = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        name = (TextView) findViewById(R.id.name);
        terrain = (TextView) findViewById(R.id.terrain);
        climate = (TextView) findViewById(R.id.climate);
        gravity = (TextView) findViewById(R.id.gravity);
        gravity = (TextView) findViewById(R.id.gravity);
        rotation_period = (TextView) findViewById(R.id.rotation);
        orbital_period = (TextView) findViewById(R.id.orbital);
        diameter = (TextView) findViewById(R.id.diameter);
        surface_water= (TextView) findViewById(R.id.water);
        population = (TextView) findViewById(R.id.pop);
        created = (TextView) findViewById(R.id.created);
        edited = (TextView) findViewById(R.id.edited);
        url = (TextView) findViewById(R.id.url);

        Intent intent= getIntent();
        String jSonDetail = intent.getStringExtra("jSonDetailPlanet");

        ObjectMapper obj = new ObjectMapper();
        try {
            Planet planet = obj.readValue(jSonDetail, Planet.class);
            planetDetails(planet);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void planetDetails(Planet planet){
        final String climateStr = planet.getClimate();
        final String gravityStr = planet.getGravity();
        final String nameStr = planet.getName();
        final String terrainStr = planet.getTerrain();
        final String rotation_periodStr = planet.getRotation_period();
        final String orbital_periodStr = planet.getOrbital_period();
        final String diameterStr = planet.getDiameter();
        final String surface_waterStr = planet.getSurface_water();
        final String populationStr = planet.getPopulation();
        final List<String> residentsStr = planet.getResidents();
        final List<String> filmsStr = planet.getFilms();
        final String createdStr = planet.getCreated();
        final String editedStr = planet.getEdited();
        final String urlStr = planet.getUrl();

        name.setText("Name : "+String.valueOf(nameStr));
        climate.setText("Climate : "+climateStr);
        terrain.setText("Terrain : "+terrainStr);
        gravity.setText("Gravity : "+gravityStr);
        rotation_period.setText("Rotation period : "+rotation_periodStr+" rot/h");
        orbital_period.setText("Orbital period : "+orbital_periodStr+" orbit/day");
        diameter.setText("Diameter : "+diameterStr+" km");
        surface_water.setText("Surface of water : "+surface_waterStr+"%");
        population.setText("Population : "+populationStr);
        created.setText("Date of creation : "+createdStr);
        edited.setText("Date of edition : "+editedStr);
        url.setText("Url on Swapi : "+urlStr);
        //residents.setText(residentsStr); car liste
        //films.setText(filmsStr); idem
    }
}
