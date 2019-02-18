package com.example.projetmobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetmobile.model.Planet;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Planet> values;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public View layout;

        public ViewHolder(View v){
            super(v);
            layout = v;
            name = (TextView) v.findViewById(R.id.cell_planet);
        }
    }

    public void add(int position, Planet planet){
        values.add(position, planet);
        notifyItemInserted(position);
    }

    public void remove(int position){
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Planet> mDataset) {values = mDataset;}

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Planet selectedPokemon = values.get(position);
        final String name = selectedPokemon.getName();
        holder.name.setText(name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }


}
