package com.jah.gestion_provincias3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar mtbMenu;
    RecyclerView rvProvincias;
    LinearLayoutManager disposicionP;
    GridLayoutManager disposicionL;
    AdaptadorProvincias adaptadorProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setSupportActionBar(mtbMenu);

        if(savedInstanceState != null){
            GestionProvincia.setArrProvincias((ArrayList<Provincia>) savedInstanceState.getSerializable("provincias"));
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        adaptadorProvincias = new AdaptadorProvincias(GestionProvincia.getArrProvincias());
        rvProvincias.setAdapter(adaptadorProvincias);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("provincias", new ArrayList<>(GestionProvincia.getArrProvincias()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_nueva){
            Intent nueva = new Intent(getApplicationContext(), AddProvincia.class);
            startActivity(nueva);
        }else if(item.getItemId() == R.id.item_com){
            GestionProvincia.ordenarPorCom();
            adaptadorProvincias = new AdaptadorProvincias(GestionProvincia.getArrProvincias());
            rvProvincias.setAdapter(adaptadorProvincias);
        }else if(item.getItemId() == R.id.item_prov){
            GestionProvincia.ordenarPorProv();
            adaptadorProvincias = new AdaptadorProvincias(GestionProvincia.getArrProvincias());
            rvProvincias.setAdapter(adaptadorProvincias);
        }else if(item.getItemId() == R.id.item_salir){
            createDialogSalir();
        }
        return false;
    }

    private void createDialogSalir() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.dialog_salir_title)
                .setMessage(R.string.dialog_salir_message)
                .setNegativeButton(R.string.dialog_negative, null)
                .setPositiveButton(R.string.dialog_positive, (dialogInterface, i) -> finishAffinity())
                .create()
                .show();
    }

    private void initComponents() {
        rvProvincias = findViewById(R.id.rvProvincias);
        mtbMenu = findViewById(R.id.mtbMenu);
        GestionProvincia.cargarDatos();
        initDisposicion();
        adaptadorProvincias = new AdaptadorProvincias(GestionProvincia.getArrProvincias());
        rvProvincias.setAdapter(adaptadorProvincias);
    }

    private void initDisposicion() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            disposicionP = new LinearLayoutManager(getApplicationContext());
            rvProvincias.setLayoutManager(disposicionP);
        }else{
            disposicionL = new GridLayoutManager(getApplicationContext(), 2);
            rvProvincias.setLayoutManager(disposicionL);
        }
    }
}