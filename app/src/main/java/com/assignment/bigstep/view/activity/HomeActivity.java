package com.assignment.bigstep.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.assignment.bigstep.R;

import com.assignment.bigstep.adapter.HomeViewPager;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private HomeViewPager walletViewPager;
    private ViewPager viewPager_tab;
    private boolean doubleBackPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("BigStep Task");
        initId();
        setHomeViewPager();
    }

    private void initId() {
        tabLayout = findViewById(R.id.leader_board_tab);
        viewPager_tab = findViewById(R.id.vpMain);
    }

    private void setHomeViewPager() {
        walletViewPager = new HomeViewPager(getSupportFragmentManager());
        viewPager_tab.setAdapter(walletViewPager);
        tabLayout.setupWithViewPager(viewPager_tab);
    }


    @Override
    public void onBackPressed() {
        // super.onBackPressed();

        if (tabLayout.getSelectedTabPosition() > 0) {
            tabLayout.selectTab(tabLayout.getTabAt(0));
        } else {
            if (doubleBackPressed) {
                finishAffinity();
            } else {
                doubleBackPressed = true;
                Toast.makeText(this, R.string.press_back_to_exit, Toast.LENGTH_SHORT).show();
                //delay
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Your Code
                        doubleBackPressed = false;
                    }
                }, 2000);

            }
        }
    }

}