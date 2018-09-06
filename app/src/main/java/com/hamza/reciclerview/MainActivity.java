package com.hamza.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initImageBitmaps();
        Log.d(TAG, "onCreate: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: prepairing bitmaps");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/0/06/Delicatearch1.jpg");
        mImageNames.add("Arches");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/d/df/Biscayne_NP_snorkeling.jpg");
        mImageNames.add("Biscayne");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/0/0a/Teton_Range_from_Glacier_View_Turnout-closeup.JPG");
        mImageNames.add("Grand Teton");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/4/40/Cassidy_Arch%2C_Capitol_Reef_National_Park.JPG");
        mImageNames.add("Capitol Reef");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/b/b5/Crater_lake_oregon.jpg");
        mImageNames.add("Crater Lake");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/a/a8/Cuyahoga_Valley_National_Park_03.jpg");
        mImageNames.add("Cuyahoga Valley");
    }
}
