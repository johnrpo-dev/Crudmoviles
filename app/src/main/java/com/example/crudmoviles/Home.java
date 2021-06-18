package com.example.crudmoviles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Usuario> listadeActividades = new  ArrayList<>();
    RecyclerView listado;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado = findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        llenarListado();

    }

    public void llenarListado() {

        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())   {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String nombre = document.get("nombre").toString();
                                String edad = document.get("edad").toString();
                                String foto = document.get("foto").toString();
                                
                                listadeActividades.add(new Usuario(nombre,edad,foto));
                            }
                            AdaptadorLista adaptador = new AdaptadorLista(listadeActividades);
                            listado.setAdapter(adaptador);

                        }else{
                            Toast.makeText(Home.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


}