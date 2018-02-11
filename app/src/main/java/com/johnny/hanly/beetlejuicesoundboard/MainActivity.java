package com.johnny.hanly.beetlejuicesoundboard;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;



public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(this, "ca-app-pub-5391088306797652~2345210904");
mAdView= findViewById(R.id.adView);
        AdRequest adRequest =new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        setTitle("");
        Context context=getApplicationContext();
        TabLayout tabLayout= findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText("Classic"));
        tabLayout.addTab(tabLayout.newTab().setText("Insults"));
        tabLayout.addTab(tabLayout.newTab().setText("Misc."));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager= findViewById(R.id.viewpager);

        final PagerAdapter adapter= new com.johnny.hanly.beetlejuicesoundboard.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
      viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
