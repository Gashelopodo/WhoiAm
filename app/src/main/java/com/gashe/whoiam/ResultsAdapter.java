package com.gashe.whoiam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gashe on 20/3/17.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsViewHolder> {

    private Word[] words;

    public ResultsAdapter(Word[] words) {
        this.words = words;
    }

    @Override
    public ResultsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ResultsViewHolder resultsViewHolder = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_activity_results, parent, false);
        resultsViewHolder = new ResultsViewHolder(view);
        return resultsViewHolder;
    }

    @Override
    public void onBindViewHolder(ResultsViewHolder holder, int position) {
        Word word = words[position];
        holder.loadDataHolder(word);
    }

    @Override
    public int getItemCount() {
        return words.length;
    }

}
