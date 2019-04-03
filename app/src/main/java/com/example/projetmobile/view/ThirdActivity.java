package com.example.projetmobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.projetmobile.AdapterDescription;
import com.example.projetmobile.R;
import com.example.projetmobile.controller.DetailController;
import com.example.projetmobile.model.Description;
import com.example.projetmobile.model.Planet;

import java.util.List;

public class ThirdActivity extends Activity {
    private RecyclerView recyclerView;
    private DetailController detailController;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int id = (int) getIntent().getSerializableExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = findViewById(R.id.recycler_view2);
        //loader = findViewById(R.id.loader_second_activity);

        detailController = new DetailController(this);
        detailController.start(id);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }

    public void showList(List<Description> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new AdapterDescription(list);
        recyclerView.setAdapter(mAdapter);
    }
}
