package com.projetomobile.conexomental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    public void irParaRegistro(View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    };

    public void irParaMeditacao(View v){

        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText senha = findViewById(R.id.senha);

        String usrname = String.valueOf(username.getText());
        String ema = String.valueOf(email.getText());
        String sen = String.valueOf(senha.getText());

        Boolean allow = Boolean.TRUE;
        if(usrname.equals("")){
            username.setHint("Username obrigatório");
            allow = Boolean.FALSE;
        }
        if(ema.equals("")){
            email.setHint("Email obrigatório");
            allow = Boolean.FALSE;
        }
        if(sen.equals("")){
            senha.setHint("Senha obrigatória");
            allow = Boolean.FALSE;
        }
        if(allow.equals(Boolean.TRUE)){
            Intent intent = new Intent(this,MeditationActivity.class);
            startActivity(intent);
        }
    }
}