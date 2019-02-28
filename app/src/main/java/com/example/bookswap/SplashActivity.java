package com.example.bookswap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private int totalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_main); // change to splash screen setup in a bit
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        totalCount = prefs.getInt("counter", 0);
        totalCount++;
        editor.putInt("counter", totalCount);
        editor.apply();
        System.out.println("Total Application Counter Reach To " + totalCount); // gets total amount app is opened
        generateSplash();

    }
    public void generateSplash(){
        //    ImageView splashImage = findViewById(R.id.secondSplash);
        //  splashImage.setImageResource(R.drawable.logo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(totalCount == 1){
                   intent = new Intent(getApplicationContext(),MainActivity.class);
                }else{
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}