package com.dboyz.app.android.vendor.ui.activities;

import com.dboyz.app.android.vendor.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class VendorHome extends AppCompatActivity {

    private Toolbar mToolbar = null;
    private DrawerLayout mDrawerLayout = null;
    private NavigationView mNavigationView = null;
    private FloatingActionButton mFabNewOrder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_home);
        initViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dlVendorHome);
        mNavigationView = (NavigationView) findViewById(R.id.navHome);
        mFabNewOrder = (FloatingActionButton) findViewById(R.id.fabNewOrder);
        mFabNewOrder.setOnClickListener(mOnClickListener);
        initActionBar();
        setUpNavDrawer();
    }

    private void setUpNavDrawer() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_launcher);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mNavigationView.setNavigationItemSelectedListener(mNavigationSelectionListener);
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

    }

    private void initActionBar() {
        setUpToolbar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vendor_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_drawer_vendor_home_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private OnClickListener mOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fabNewOrder:
                    onClickNewOrder();
                    break;

                default:
                    break;
            }

        }
    };
    private OnNavigationItemSelectedListener mNavigationSelectionListener = new OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            boolean result = false;
            switch (menuItem.getItemId()) {
                case R.id.menu_drawer_vendor_home_myprofile:
                    result = true;
                    break;
                case R.id.menu_drawer_vendor_home_placeorders:
                    onClickNewOrder();
                    result = true;
                    break;
                case R.id.menu_drawer_vendor_home_myorders:
                    result = true;
                    break;
                case R.id.menu_drawer_vendor_home_settings:
                    result = true;
                    break;
                case R.id.menu_drawer_vendor_home_help:
                    onClickHelp();
                    result = true;
                    break;
                case R.id.menu_drawer_vendor_home_aboutus:
                    onClickAboutUs();
                    result = true;
                    break;
                default:
                    break;
            }
            mDrawerLayout.closeDrawers();
            return result;
        }
    };

    private void onClickAboutUs() {
        AboutUs.launchAboutUs(this);
    }

    private void onClickHelp() {
        Help.launchHelp(this);
    }

    private void onClickNewOrder() {
        Intent intent = new Intent(VendorHome.this, TimePicker.class);
        startActivity(intent);
    }

}
