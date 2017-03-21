package com.gashe.whoiam.Activities;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

import com.gashe.whoiam.Gestures;
import com.gashe.whoiam.R;
import com.gashe.whoiam.Word;

public class MainActivity extends AppCompatActivity{


    Word[] words = new Word[]{
            new Word(1, "Espada", false),
            new Word(2, "Pelota", false),
            new Word(3, "Pinguino", false),
            new Word(4, "Maceta", false),
            new Word(5, "Ordenador", false),
            new Word(6, "Ratón", false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gestures gestures = new Gestures(this, words);

    }

}
