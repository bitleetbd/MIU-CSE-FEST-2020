package com.bitleet.miucsefest2020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bitleet.miucsefest2020.Adapter.ExhibitorRecyclerViewAdapter;
import com.bitleet.miucsefest2020.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;


public class Exhibitor extends AppCompatActivity {

    View view;
    private RecyclerView recyclerView;
    private List<Exhibitor> exhibitor_item;

    private String Exhibitor_name;
    private String Exhibitor_type;
    private String Exhibitor_venue;
    private int Exhibitor_logo;

    public Exhibitor() {

    }

    public Exhibitor(String exhibitor_name, String exhibitor_type, String exhibitor_venue, int exhibitor_logo) {
        Exhibitor_name = exhibitor_name;
        Exhibitor_type = exhibitor_type;
        Exhibitor_venue = exhibitor_venue;
        Exhibitor_logo = exhibitor_logo;
    }

    //This segment is not completed.
    //Exhibitor_Item java class may be required or create.
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhebitior);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public String getExhibitor_name() {
        return Exhibitor_name;
    }

    public void setExhibitor_name(String exhibitor_name) {
        Exhibitor_name = exhibitor_name;
    }

    public String getExhibitor_type() {
        return Exhibitor_type;
    }

    public void setExhibitor_type(String exhibitor_type) {
        Exhibitor_type = exhibitor_type;
    }

    public String getExhibitor_venue() {
        return Exhibitor_venue;
    }

    public void setExhibitor_venue(String exhibitor_venue) {
        Exhibitor_venue = exhibitor_venue;
    }

    public int getExhibitor_logo() {
        return Exhibitor_logo;
    }

    public void setExhibitor_logo(int exhibitor_logo) {
        Exhibitor_logo = exhibitor_logo;
    }
}
