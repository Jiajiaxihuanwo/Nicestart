package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ImageView foton = findViewById(R.id.backViewLogin);
        Glide.with(this)
                .load(R.drawable.montana)
                .centerCrop()
                .into(foton);
    }


    public void openPerfile(View v){
        EditText nom = findViewById(R.id.nombre);
        String nombre = nom.getText().toString();
        EditText contra= findViewById(R.id.contraseña);
        String contraseña = contra.getText().toString();
        if(!nombre.isEmpty()&&!contraseña.isEmpty()){
            Intent intent = new Intent(Login.this,perfile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).//para limpiar
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            intent.putExtra("NOMBRE", nombre);
            startActivity(intent);
        }
    }
    public void openSignUp(View v){
        Intent intent = new Intent(Login.this,SignUp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).//para limpiar
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}