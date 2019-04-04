package com.example.projetmobile;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetmobile.model.Description;
import com.example.projetmobile.model.Planet;
import com.example.projetmobile.model.RestPlanetResponse;

import java.util.List;

public class AdapterDescription extends RecyclerView.Adapter<AdapterDescription.ViewHolder> {
    private List<Planet> values;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView terrain;
        public TextView climate;
        public TextView gravity;
        public TextView name;
        public View layout;

        public ViewHolder(View v){
            super(v);
            layout = v;
            name = (TextView) v.findViewById(R.id.name);
            terrain = (TextView) v.findViewById(R.id.terrain);
            climate = (TextView) v.findViewById(R.id.climate);
            gravity = (TextView) v.findViewById(R.id.gravity);
        }
    }
/*
    public void add(int position, Planet planet){
        values.add(position, planet);
        notifyItemInserted(position);
    }

    public void remove(int position){
        values.remove(position);
        notifyItemRemoved(position);
    }
*/
    public AdapterDescription(List<Planet> mDataset) {values = mDataset;}

    @Override
    public AdapterDescription.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_layout2, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Planet planet = values.get(position);



        //Planet planet = values.get(position);
        //final String climate = description.getClimate();
        //final String gravity = description.getGravity();
        final String name = planet.getName();
        //final String terrain = description.getTerrain();
        holder.name.setText(name);
        //holder.climate.setText(climate);
        //holder.terrain.setText(terrain);
        //holder.gravity.setText(gravity);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }


}
