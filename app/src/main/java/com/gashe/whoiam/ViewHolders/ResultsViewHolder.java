package com.gashe.whoiam.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gashe.whoiam.R;
import com.gashe.whoiam.Word;

/**
 * Created by Gashe on 20/3/17.
 */

public class ResultsViewHolder extends RecyclerView.ViewHolder {

    private TextView numWord;
    private TextView nameWord;
    private TextView resultWord;

    public ResultsViewHolder(View itemView) {
        super(itemView);
        // seteamos los datos
        numWord = (TextView)itemView.findViewById(R.id.numWord);
        nameWord = (TextView)itemView.findViewById(R.id.nameWord);
        resultWord = (TextView)itemView.findViewById(R.id.resultWord);
    }

    public void loadDataHolder(Word word){
        numWord.setText("" + word.getNum());
        nameWord.setText(word.getName());
        resultWord.setText("" + word.getSuccess());
    }

}
