package com.example.idnp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editUsuario = findViewById(R.id.editUsuario);
        EditText editPassword = findViewById(R.id.editPassword);
        TextView txtMensaje = findViewById(R.id.textMensaje);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editUsuario.getText().toString();
                String password = editPassword.getText().toString();

                if(usuario.equals("test") && password.equals("1234")) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                } else {
                    txtMensaje.setText("Autenticacion no valida");
                }
            }
        });
    }
}