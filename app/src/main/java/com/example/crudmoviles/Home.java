package com.example.crudmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Usuario> listadeActividades = new  ArrayList<>();
    RecyclerView listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado = findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

    }
}