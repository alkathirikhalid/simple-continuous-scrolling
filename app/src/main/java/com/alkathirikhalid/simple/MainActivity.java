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

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private SimpleAdaptor recyclerViewAdapter;
    private ArrayList<String> dataList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pbLoading);
        recyclerView = findViewById(R.id.rvList);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new SimpleAdaptor(dataList);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (progressBar.getVisibility() == View.GONE) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == dataList.size() - 1) {
                        loadMore();
                    }
                }
            }
        });
        loadMore();
    }

    private void loadMore() {
        progressBar.setVisibility(View.VISIBLE);
        int nextLimit = dataList.size() + 20;
        for (int count = dataList.size(); count < nextLimit; count++) {
            dataList.add("Data " + count);
        }
        recyclerViewAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}