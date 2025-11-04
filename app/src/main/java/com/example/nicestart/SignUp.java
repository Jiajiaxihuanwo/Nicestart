package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

    }

    public void openMain(View v){
        Intent intent = new Intent(SignUp.this,MainActivity.class);
        startActivity(intent);
    }

    public void openLogin(View v){
        Intent intent = new Intent(SignUp.this,Login.class);
        startActivity(intent);
    }
}
