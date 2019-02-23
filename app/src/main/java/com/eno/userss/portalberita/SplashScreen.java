package com.eno.userss.portalberita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(SplashScreen.this, "Error!!", Toast.LENGTH_SHORT).show();
                } finally {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}







