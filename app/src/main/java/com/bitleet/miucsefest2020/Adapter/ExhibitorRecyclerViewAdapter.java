package com.bitleet.miucsefest2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bitleet.miucsefest2020.Exhibitor;
import com.bitleet.miucsefest2020.R;

import java.util.List;

public class ExhibitorRecyclerViewAdapter extends RecyclerView.Adapter<ExhibitorRecyclerViewAdapter.EventViewHolder> {
    Context context;
    List<Exhibitor> data;

    public ExhibitorRecyclerViewAdapter(Context context, List<Exhibitor> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ExhibitorRecyclerViewAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.exhibitor_item, parent, false);
        ExhibitorRecyclerViewAdapter.EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.exhibitor_name.setText(data.get(position).getExhibitor_name());
        holder.exhibitor_type.setText(data.get(position).getExhibitor_type());
        holder.exhibitor_venue.setText(data.get(position).getExhibitor_venue());
        holder.exhibitor_logo.setImageAlpha(data.get(position).getExhibitor_logo());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {

        private TextView exhibitor_name;
        private TextView exhibitor_type;
        private TextView exhibitor_venue;
        private ImageView exhibitor_logo;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            exhibitor_name = itemView.findViewById(R.id.exhibitor_name);
            exhibitor_type = itemView.findViewById(R.id.exhibitor_type);
            exhibitor_venue = itemView.findViewById(R.id.exhibitor_venue);
            exhibitor_logo = itemView.findViewById(R.id.exhibitor_logo);
        }
    }
}
