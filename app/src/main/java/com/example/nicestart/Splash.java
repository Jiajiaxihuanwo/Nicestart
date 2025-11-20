package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        ImageView thunder = findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.blink);
        thunder.startAnimation(myanim);
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