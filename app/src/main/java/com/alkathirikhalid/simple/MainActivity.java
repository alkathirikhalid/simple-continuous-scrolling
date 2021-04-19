package com.alkathirikhalid.simple;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare View and Classes Needed
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private SimpleAdaptor recyclerViewAdapter;
    private ArrayList<String> dataList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the views
        progressBar = findViewById(R.id.pbLoading);
        recyclerView = findViewById(R.id.rvList);
        // Set up Layout manager, recycle view and adaptor
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new SimpleAdaptor(dataList);
        recyclerView.setAdapter(recyclerViewAdapter);
        // Add a scroll listener to the Recycle View
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // Only get data if its not getting already
                if (progressBar.getVisibility() == View.GONE) {
                    // The user has reached the end of the list
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == dataList.size() - 1) {
                        // Get More Data
                        loadMore();
                    }
                }
            }
        });
        // Get data for the first time on load
        loadMore();
    }

    // Since below method has not timer / delay the Progress bar effect won't be visible but functional
    private void loadMore() {
        // Ensure to set a que that the loading in progress
        progressBar.setVisibility(View.VISIBLE);
        // Below is not needed as its just a counter and can be represented as i.e page number and page size
        int nextLimit = dataList.size() + 20;
        for (int count = dataList.size(); count < nextLimit; count++) {
            // Add the new data on the existing data
            dataList.add("Data " + count);
        }
        // notify Recycler view to draw items, can be set to specific position
        recyclerViewAdapter.notifyDataSetChanged();
        // Ensure to set a que that the loading is completed
        progressBar.setVisibility(View.GONE);
    }
}