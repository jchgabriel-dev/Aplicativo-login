package com.example.idnp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PostulanteInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);
        Intent intent = getIntent();
        ArrayList<Postulante> registro = (ArrayList<Postulante>) intent.getSerializableExtra(MenuActivity.KEY_NAME);
        EditText editBuscar = findViewById(R.id.editBuscar);

        EditText editDNI = findViewById(R.id.editDNI);
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editApellidos = findViewById(R.id.editApellidos);
        EditText editFecha = findViewById(R.id.editFecha);
        EditText editColegio = findViewById(R.id.editColegio);
        EditText editCarrera = findViewById(R.id.editCarrera);
        TextView txtMensaje = findViewById(R.id.textMensaje);
        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buscar = editBuscar.getText().toString();
                boolean ver = false;

                if(!(TextUtils.isEmpty(buscar))){
                    for(Postulante pos : registro){
                        if(buscar.equals(pos.getDNI())){
                            txtMensaje.setText(" ");
                            editDNI.setText(pos.getDNI());
                            editNombres.setText(pos.getNombres());
                            editApellidos.setText(pos.getNombres());
                            editFecha.setText(pos.getNombres());
                            editApellidos.setText(pos.getApePaterno() + " " + pos.getApeMaterno());
                            editFecha.setText(pos.getFecha());
                            editColegio.setText(pos.getColegio());
                            editCarrera.setText(pos.getCarrera());
                            ver = true;
                            break;
                        }
                    }
                    if(ver == false){
                        txtMensaje.setText("DNI no encontrado");
                    } else {
                        txtMensaje.setText(" ");
                    }

                } else {
                    txtMensaje.setText("Ingrese DNI");
                }

            }
        });

    }
}