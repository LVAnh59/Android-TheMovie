package com.lvanh.themovie;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lvanh.themovie.ui.account.ProfileFragment;
import com.lvanh.themovie.ui.discover.DiscoverFragment;
import com.lvanh.themovie.ui.upcoming.UpcomingFragment;
import com.lvanh.themovie.ui.watchlist.WatchFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    final Fragment fragDiscover = new DiscoverFragment();
    final Fragment fragUpcoming = new UpcomingFragment();
    final Fragment fragWatchList = new WatchFragment();
    final Fragment fragAccount = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragDiscover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fm.beginTransaction().add(R.id.nav_host_fragment, fragAccount, "4").hide(fragAccount).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, fragWatchList, "3").hide(fragWatchList).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, fragUpcoming, "2").hide(fragUpcoming).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment,fragDiscover, "1").commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_discover:
                    fm.beginTransaction().hide(active).show(fragDiscover).commit();
                    active = fragDiscover;
                    item.setChecked(true);
                    break;
                case R.id.navigation_upcoming:
                    fm.beginTransaction().hide(active).show(fragUpcoming).commit();
                    active = fragUpcoming;
                    item.setChecked(true);
                    break;
                case R.id.navigation_watchlist:
                    fm.beginTransaction().hide(active).show(fragWatchList).commit();
                    active = fragWatchList;
                    item.setChecked(true);
                    break;
                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(fragAccount).commit();
                    active = fragAccount;
                    item.setChecked(true);
                    break;
            }
            return false;
        }
    };

}