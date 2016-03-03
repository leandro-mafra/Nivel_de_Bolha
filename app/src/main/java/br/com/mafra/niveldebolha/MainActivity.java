package br.com.mafra.niveldebolha;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import android.os.Handler;

public class MainActivity extends Activity {

    private Tela tela;
    private MainActivity cont;
    private SensorManager smanager;
    private Sensor sensor;
    private static int posicaoTela;
    private Thread tr;
    private float x, y, z;

    private Handler hand = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
        tela.setOnTouchListener(tou);
        cont=this;

        smanager = (SensorManager) getSystemService(this.SENSOR_SERVICE);

        sensor = smanager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        if(this.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT && this.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            cont.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            posicaoTela = 0;
        }

        DisplayMetrics dis = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dis);
        tela.setTelaheight(dis.heightPixels);
        tela.setTelawidth(dis.widthPixels);

        tela.Proporssao(posicaoTela);

        tr = new Thread(rt);

    }



    public void Muda(){

        switch (cont.getRequestedOrientation()){
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
                cont.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                posicaoTela = 1;
                break;
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
                cont.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                posicaoTela = 0;
                break;
        };
    }

    private Runnable rt = new Runnable() {
        @Override
        public void run() {
            while (true) {
                long pulo = 0;
                    pulo = System.nanoTime() + 666666667;
                    if (pulo < System.nanoTime()) {
                        tela.Sensor(z, y, z);
                        hand.post(new Runnable() {
                        @Override
                        public void run() {
                            tela.invalidate();
                        }
                    });
                }
            }
        }
    };

    private View.OnTouchListener tou = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            System.out.println(System.nanoTime());
            if(tela.Touth(event)){
                System.out.println(System.nanoTime());
                Muda();
            };
            return false;
        }
    };

    private SensorEventListener sen = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        smanager.registerListener(sen, sensor, SensorManager.SENSOR_DELAY_GAME);
        tr.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        smanager.unregisterListener(sen);
    }
}
