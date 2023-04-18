package com.example.bottomnavbarfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public int fragmentCycle=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navBar= findViewById(R.id.bottomNavigationView);
        FragmentHome home= new FragmentHome();
        FragmentFavourites favourites=new FragmentFavourites();
        FragmentDashboard dashboard=new FragmentDashboard();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,home).commit();
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        if (fragmentCycle!=0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,home).commit();
                            fragmentCycle=0;
                        }
                        else if (fragmentCycle==0){
                            Toast.makeText(MainActivity.this, "Already on "+item.getTitle(), Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case R.id.favourites:

                        if (fragmentCycle!=1){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,favourites).commit();
                            fragmentCycle=1;
                        }else if (fragmentCycle==1){
                            Toast.makeText(MainActivity.this, "Already on "+item.getTitle(), Toast.LENGTH_SHORT).show();

                        }
                        break;
                    case R.id.dashboard:

                        if (fragmentCycle!=2){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,dashboard).commit();
                            fragmentCycle=2;
                        }else if (fragmentCycle==2){
                            Toast.makeText(MainActivity.this, "Already on "+item.getTitle(), Toast.LENGTH_SHORT).show();

                        }
                        break;

                }
                return true;
            }
        });


    }
}