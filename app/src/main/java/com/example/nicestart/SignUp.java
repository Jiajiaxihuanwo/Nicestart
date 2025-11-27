package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        ImageView foton = findViewById(R.id.backViewSignup);
        Glide.with(this)
                .load(R.drawable.montana2)
                .centerCrop()
                .into(foton);
    }

    public void openPerfile(View v){
        EditText nombre = findViewById(R.id.nombre);
        String n = nombre.getText().toString();
        EditText email = findViewById(R.id.email);
        String e = email.getText().toString();
        EditText contrasena = findViewById(R.id.contrasena);
        String c = contrasena.getText().toString();
        if (n.isEmpty()) {
            Toast.makeText(this, "Falta el nombre de usuario", Toast.LENGTH_LONG).show();
        } else if (e.isEmpty()) {
            Toast.makeText(this, "Falta el correo", Toast.LENGTH_LONG).show();
        } else if (c.isEmpty()) {
            Toast.makeText(this, "Falta la contraseña", Toast.LENGTH_LONG).show();
        } else {
            // 全部字段都填了，跳转
            Intent intent = new Intent(SignUp.this, perfile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }

    public void openLogin(View v){
        Intent intent = new Intent(SignUp.this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
