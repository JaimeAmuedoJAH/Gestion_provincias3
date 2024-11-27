package com.jah.gestion_provincias3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddProvincia extends AppCompatActivity {

    EditText txtNombreProv, txtNombreCom, txtNumHabitantes;
    Button btnAdd;
    Provincia p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provincia);
        initComponents();
        btnAdd.setOnClickListener(view -> agregarProvincia());
    }

    private void agregarProvincia() {
        String provincia = txtNombreProv.getText().toString();
        String comunidad = txtNombreCom.getText().toString();
        int numHabitantes = Integer.parseInt(txtNumHabitantes.getText().toString());
        int foto = R.drawable.ciudad;

        p = new Provincia(provincia, comunidad, numHabitantes, foto);
        GestionProvincia.anhadirProvincia(p);
        finish();
    }

    private void initComponents() {
        txtNombreCom = findViewById(R.id.txtNombreCom);
        txtNombreProv = findViewById(R.id.txtNombreProv);
        txtNumHabitantes = findViewById(R.id.txtNumHabitantes);
        btnAdd = findViewById(R.id.btnAdd);
    }
}