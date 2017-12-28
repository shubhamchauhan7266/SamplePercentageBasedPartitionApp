package com.kelltontech.samplepercentagebasedpartitionapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CustomProgressBar seekbar;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = findViewById(R.id.seekBar0);
        seekbar.getThumb().mutate().setAlpha(0);
        initDataToSeekbar();
    }

    private void initDataToSeekbar() {
        ArrayList<ProgressItem> progressItemList = new ArrayList<ProgressItem>();

        progressItemList.add(addProgressItem(20,R.color.red));
        progressItemList.add(addProgressItem(30,R.color.blue));
        progressItemList.add(addProgressItem(20,R.color.green));
        progressItemList.add(addProgressItem(30,R.color.yellow));
        seekbar.initData(progressItemList);
        seekbar.invalidate();
    }

    ProgressItem addProgressItem(int progressItemPercentage,int color){
        ProgressItem progressItem = new ProgressItem();
        progressItem.progressItemPercentage = progressItemPercentage;
        progressItem.color = color;
        return progressItem;
    }
}
