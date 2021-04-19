package com.alkathirikhalid.simple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
 * Project : Strands FM for Android
 *
 * SENSITIVE AND CONFIDENTIAL
 *
 * TRADE SECRETS
 *
 * DO NOT DISCLOSE OR PUBLISH
 *
 * (c) Copyright 2003-2020 Strands, Inc
 *
 * This software and the related information is proprietary to and includes trade secrets of Strands, Inc. ("Strands").
 * Strands intends to preserve its trade secrets in the software and related information. It is released pursuant to a
 * written agreement, and any use or modification of the software is subject to the terms of the Agreement. If you are
 * not authorized under the agreement, any use or modification of the source code for this software by you is unauthorized.
 * Any disclosure, publication or distribution of the source code by you is prohibited unless expressly authorized in the Agreement.
 * Strands will prosecute unauthorized use or modification to the fullest extent allowable under applicable law.
 *
 * ALL RIGHTS RESERVED
 */
public class SimpleAdaptor extends RecyclerView.Adapter<SimpleAdaptor.ViewHolder> {

    private List<String> localDataSet;

    public SimpleAdaptor(List<String> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rv_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
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