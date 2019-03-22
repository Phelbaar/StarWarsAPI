package com.example.projetmobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetmobile.model.Planet;

import java.util.List;

public class AdapterName extends RecyclerView.Adapter<AdapterName.ViewHolder> {
    private List<Planet> values;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Planet item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        //public TextView description;
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

    public AdapterName(List<Planet> mDataset, OnItemClickListener listener) {values = mDataset;
        this.listener = listener;
    }

    @Override
    public AdapterName.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
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
        final Planet planet = values.get(position);
        final String name = planet.getName();
        //final String climate = planet.getClimate();
        holder.name.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(planet);
            }
        });
        //holder.description.setText(climate);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }


}
