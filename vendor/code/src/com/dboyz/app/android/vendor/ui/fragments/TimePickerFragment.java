package com.dboyz.app.android.vendor.ui.fragments;

import com.dboyz.app.android.vendor.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class TimePickerFragment extends Fragment {

    public interface OnTimePickListener {
        public void onPickTime(int minutes);
    }

    private View mRootView = null;
    private Button mBtn10Min = null;
    private Button mBtn20Min = null;
    private Button mBtn30Min = null;
    private Button mBtn1Hr = null;
    private Button mBtnCustomTime = null;
    
    private OnTimePickListener mTimePickListener = null ;
    
    public OnTimePickListener getmTimePickListener() {
        return mTimePickListener;
    }

    public void setOnTimePickListener(OnTimePickListener mTimePickListener) {
        this.mTimePickListener = mTimePickListener;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        // TODO Auto-generated method stub
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_time_picker, null);
        initViewsFromRoot(mRootView);
        return mRootView;
    }

    private void initViewsFromRoot(View mRootView) {
        mBtn10Min = (Button) mRootView.findViewById(R.id.btn10Min);
        mBtn20Min = (Button) mRootView.findViewById(R.id.btn20Min);
        mBtn30Min = (Button) mRootView.findViewById(R.id.btn30Min);
        mBtn1Hr = (Button) mRootView.findViewById(R.id.btn1Hr);
        mBtnCustomTime = (Button) mRootView.findViewById(R.id.btnCustomTime);
        mBtn10Min.setOnClickListener(mOnClickListener);
        mBtn20Min.setOnClickListener(mOnClickListener);
        mBtn30Min.setOnClickListener(mOnClickListener);
        mBtn1Hr.setOnClickListener(mOnClickListener);
        mBtnCustomTime.setOnClickListener(mOnClickListener);

    }

    private OnClickListener mOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn10Min:
                    onSelectTime(10);
                    break;
                case R.id.btn20Min:
                    onSelectTime(20);

                    break;
                case R.id.btn30Min:
                    onSelectTime(30);

                    break;
                case R.id.btn1Hr:
                    onSelectTime(60);

                    break;
                case R.id.btnCustomTime:
                    onSelectTime(75);

                    break;
                default:
                    break;
            }

        }

        private void onSelectTime(int minutes) {
           if(mTimePickListener != null){
               mTimePickListener.onPickTime(minutes);
           }
            
        }
    };

}
