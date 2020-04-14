package com.bitleet.miucsefest2020;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.transition.Slide;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Button eventButton, speakerButton, VenueButton, ExhibitorButton, KeyfactsButton, AttractionButton, getMyPass;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.closeDrawer(GravityCompat.START);


        eventButton = findViewById(R.id.eventButton);
        speakerButton = findViewById(R.id.SpeakerButton);
        VenueButton = findViewById(R.id.VenueButton);
        ExhibitorButton = findViewById(R.id.ExhibitorsButton);
        KeyfactsButton = findViewById(R.id.KeyfactButton);
        AttractionButton = findViewById(R.id.AttractionButton);
        getMyPass = findViewById(R.id.get_my_pass_button);

        txtTimerDay = findViewById(R.id.txtTimerDay);
        txtTimerHour = findViewById(R.id.txtTimerHour);
        txtTimerMinute = findViewById(R.id.txtTimerMinute);
        txtTimerSecond = findViewById(R.id.txtTimerSecond);
        tvEvent = findViewById(R.id.tvhappyevent);

        countDownStart();

        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Event.class);
                startActivity(intent);

            }
        });
        speakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Speaker.class);
                startActivity(intent);

            }
        });
        VenueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Venue.class);
                startActivity(intent);

            }
        });
        ExhibitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exhibitor.class);
                startActivity(intent);

            }
        });
        AttractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Attraction.class);
                startActivity(intent);

            }
        });

        KeyfactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KeyFact.class);
                startActivity(intent);
            }
        });
        getMyPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cse.manarat.ac.bd/csefest20/"));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.nav_home) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
        if (menuItem.getItemId() == R.id.nav_event) {
            startActivity(new Intent(MainActivity.this, Event.class));
        }
        if (menuItem.getItemId() == R.id.nav_speaker) {
            startActivity(new Intent(MainActivity.this, Speaker.class));
        }
        if (menuItem.getItemId() == R.id.nav_Venue) {
            startActivity(new Intent(MainActivity.this, Venue.class));
        }

        if (menuItem.getItemId() == R.id.nav_Exhibitor) {
            startActivity(new Intent(MainActivity.this, Exhibitor.class));
        }
        if (menuItem.getItemId() == R.id.nav_Keyfact) {
            startActivity(new Intent(MainActivity.this, KeyFact.class));
        }
        if (menuItem.getItemId() == R.id.nav_Attraction) {
            startActivity(new Intent(MainActivity.this, Attraction.class));
        }
        if (menuItem.getItemId() == R.id.nav_about) {
            startActivity(new Intent(MainActivity.this, AboutUs.class));
        }
        if (menuItem.getItemId() == R.id.nav_about_dev) {
            startActivity(new Intent(MainActivity.this, AboutDev.class));
        }
        if (menuItem.getItemId() == R.id.nav_Rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
        }
        if (menuItem.getItemId() == R.id.nav_Share) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setType("text/plain");
            String shareBody = "Download MIU CSE FEST 2020 app now: http://play.google.com/store/apps/details?id=com.bitleet.miucsefest2020";
            String shareSubject = "MIU CSE FEST 2020";

            intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
            intent.putExtra(Intent.EXTRA_TEXT, shareBody);

            startActivity(Intent.createChooser(intent, "Share Using"));

        }
        return true;


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }


    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    Date futureDate = dateFormat.parse("2020-03-14");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        tvEvent.setText("See you next time!");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }

    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        findViewById(R.id.textView1).setVisibility(View.GONE);
        findViewById(R.id.textView2).setVisibility(View.GONE);

    }
}