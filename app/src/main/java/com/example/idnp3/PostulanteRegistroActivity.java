package com.example.idnp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PostulanteRegistroActivity extends AppCompatActivity {
    public static final String KEY_NAME = "REGISTRO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        EditText editDNI = findViewById(R.id.editDNI);
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editAPaterno = findViewById(R.id.editAPaterno);
        EditText editAMaterno = findViewById(R.id.editAMaterno);
        EditText editFecha = findViewById(R.id.editFecha);
        EditText editColegio = findViewById(R.id.editColegio);
        EditText editCarrera = findViewById(R.id.editCarrera);
        TextView txtMensaje = findViewById(R.id.textMensaje);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d = editDNI.getText().toString();
                String nom = editNombres.getText().toString();
                String apeP = editAPaterno.getText().toString();
                String apeM= editAMaterno.getText().toString();
                String fec = editFecha.getText().toString();
                String col = editColegio.getText().toString();
                String car = editCarrera.getText().toString();

                if(!(TextUtils.isEmpty(d) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(apeP) ||
                        TextUtils.isEmpty(apeM) || TextUtils.isEmpty(fec) || TextUtils.isEmpty(col) ||
                        TextUtils.isEmpty(car))) {
                    Postulante pos = new Postulante(d, nom, apeP, apeM, fec, col, car);
                    Intent intent = new Intent();
                    intent.putExtra(KEY_NAME, pos);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    txtMensaje.setText("Registro invalido");
                }
            }
        });
    }
}