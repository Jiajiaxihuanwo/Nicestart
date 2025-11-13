package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        openApp();

        ImageView foton = findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.ski)
                .centerCrop()
                .into(foton);
    }
    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(()-> {
                Intent intent = new Intent(Splash.this,Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
        },5000);
    }
}