package com.dboyz.app.android.vendor.ui.activities;

import com.dboyz.app.android.vendor.R;
import com.dboyz.app.android.vendor.ui.fragments.TimePickerFragment;
import com.dboyz.app.android.vendor.ui.fragments.TimePickerFragment.OnTimePickListener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class TimePicker extends AppCompatActivity {
    private Toolbar mToolbar = null;
    private TimePickerFragment mTimeFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        initViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        initActionBar();
        addTimeFragment();
    }

    private void addTimeFragment() {
        mTimeFragment = new TimePickerFragment();
        mTimeFragment.setOnTimePickListener(mTimePickListener);
        getSupportFragmentManager().beginTransaction().add(R.id.flFragmentContainer, mTimeFragment, "time_picker").commit();

    }

    private void initActionBar() {
        setUpToolbar();
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private OnTimePickListener mTimePickListener = new OnTimePickListener() {

        @Override
        public void onPickTime(int minutes) {
            // TODO start select location

        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
                return true ;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    
    
}
