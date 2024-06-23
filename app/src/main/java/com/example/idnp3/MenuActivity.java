package com.example.idnp3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_NAME = "MENU";
    TextView txtResult;
    ArrayList<Postulante> registro;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
    @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                Postulante pos = (Postulante) intent.getSerializableExtra(PostulanteRegistroActivity.KEY_NAME);
                registro.add(pos);
                txtResult.setText("Registro completo");
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        registro = new ArrayList<>();

        txtResult = findViewById(R.id.textResult);
        Button btnNuevo = (Button) findViewById(R.id.btnNuevo);
        Button btnInfo = (Button) findViewById(R.id.btnInfo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(" ");
                Intent intentA = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startForResult.launch(intentA);
            }
        });

        btnInfo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(" ");
                Intent intentB = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                intentB.putExtra(KEY_NAME, registro);
                startActivity(intentB);
            }
        }));
    }
}