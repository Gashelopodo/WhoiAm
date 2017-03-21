package com.gashe.whoiam.Models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import com.gashe.whoiam.Activities.ResultsActivity;
import com.gashe.whoiam.R;

/**
 * Created by Gashe on 20/3/17.
 */

public class Gestures implements SensorEventListener {

    private Context context;
    private SensorManager sm;
    private float[] acce;
    private float[] bruj;
    private Word[] words;
    private TextView customWord;
    private int position;
    private boolean stop = false;
    private boolean[] results;

    public Gestures(Context context, Word[] words) {
        this.context = context;
        this.words = words;
        init();
    }

    public void init(){
        sm = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        if(sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size()!=0 && sm.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).size()!=0){
            sm.registerListener(this,sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0), SensorManager.SENSOR_DELAY_NORMAL);
            sm.registerListener(this,sm.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }
        // mostramos la primera palabra
        results = new boolean[words.length];
        position = 0;
        showWord(position);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (context){
            int type = event.sensor.getType();

            switch (type){
                case 1: acce = event.values;
                    break;
                case 2: bruj = event.values;
                    break;
                default: //nothing
            }

            float[] values = new float[3];
            float[] r = new float[9];
            float[] result;
            double roll;

            if(acce != null && bruj != null) {

                SensorManager.getRotationMatrix(r, null, acce, bruj);
                result = SensorManager.getOrientation(r, values);

                roll = Math.toDegrees(result[2]);

                if(roll < -145 || roll > -30){
                    if(!stop) {
                        Log.d(getClass().getCanonicalName(), "position: " + position);
                        // seteamos resultado
                        if(position < words.length) {
                            if (roll < -145) words[position].setSuccess(true);
                            else words[position].setSuccess(false);
                        }
                        // vamos a la siguiente palabra
                        position++;
                        showWord(position);
                    }
                }

            }

        }

    }

    public void showWord(int position){
        Activity activity = (Activity)context;
        if(position < words.length) {
            stop = true;
            customWord = (TextView) activity.findViewById(R.id.customWord);
            customWord.setText(words[position].getName());

            // esperamos 2 segundo para volver a comprobar la posición del teléfono
            new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        stop = false;
                    }
                },
            2000);

        }else resumeGame();
    }

    public void resumeGame(){
        // finalizamos evento sensor
        sm.unregisterListener(this);
        // vamos a actividad resultado
        Intent intent = new Intent(context, ResultsActivity.class);
        intent.putExtra("words", words);
        context.startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
