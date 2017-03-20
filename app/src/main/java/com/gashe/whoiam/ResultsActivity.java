package com.gashe.whoiam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class ResultsActivity extends AppCompatActivity {

    private Word[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        words = (Word[]) intent.getSerializableExtra("words");


        /*for(int i = 0; i < words.length; i++){
            Log.d(getClass().getCanonicalName(), "RESULT 1: " + words[i].getName() + ": " + words[i].getSuccess());
        }*/

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.resultadosRecycler);
        ResultsAdapter adapter = new ResultsAdapter(words);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
