package com.example.khalisavirra.khalisavirra_1202154312_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    //deklarasi untuk berapa lama splashnya. 1000=1detik.
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                //Toast.makeText(SplashActivity.this,"KHALISAVIRRA_1202154312", Toast.LENGTH_LONG).show();
                this.finish();
            }
            private void finish(){
            }
        }, splashInterval);
    }
}
