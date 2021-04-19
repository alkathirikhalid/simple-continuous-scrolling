package com.alkathirikhalid.simple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * typical RecyclerView.Adapter nothing changed
 */
public class SimpleAdaptor extends RecyclerView.Adapter<SimpleAdaptor.ViewHolder> {
    // Declare Data
    private List<String> localDataSet;

    // Constructor with Data
    public SimpleAdaptor(List<String> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Get the view holder for the items to be shown
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rv_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // populate the item with data
        viewHolder.getTextView().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tvItem);
        }

        public TextView getTextView() {
            return textView;
        }
    }

}