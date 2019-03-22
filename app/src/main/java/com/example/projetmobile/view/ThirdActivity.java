package com.example.projetmobile.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.projetmobile.AdapterDescription;
import com.example.projetmobile.R;
import com.example.projetmobile.controller.Controller;
import com.example.projetmobile.model.Planet;

import java.util.List;

public class ThirdActivity extends Activity {
    private RecyclerView recyclerView;
    private Controller controller;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = findViewById(R.id.recycler_view2);
        //loader = findViewById(R.id.loader_second_activity);

        controller = new Controller(this);
        controller.start2();

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }

    public void showList(List<Planet> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new AdapterDescription(list);
        recyclerView.setAdapter(mAdapter);
    }
}
