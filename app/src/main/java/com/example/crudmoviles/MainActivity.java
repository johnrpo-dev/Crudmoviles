package com.example.crudmoviles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Atributos
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText cajaNombre, cajaEdad;
    Button botonRegistrar;
    Map<String, Object> usuario = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaNombre = findViewById(R.id.nombre);
        cajaEdad = findViewById(R.id.edad);
        botonRegistrar = findViewById(R.id.boton);


        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. valores a registrar
                String nombre = cajaNombre.getText().toString();
                String edad = cajaEdad.getText().toString();

                //2. llenar el objeto a enviar a la db
                usuario.put("nombre", nombre);
                usuario.put("edad", edad);

                //3. llamar la funcion registrar usuario
                registrarUsuario();
            }
        });
    }

    public void registrarUsuario() {

        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(MainActivity.this, "Usuario Registrado éxitosamente", Toast.LENGTH_SHORT).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this, "Error en el registro" + e, Toast.LENGTH_SHORT).show();
                    }


                });
    }
}