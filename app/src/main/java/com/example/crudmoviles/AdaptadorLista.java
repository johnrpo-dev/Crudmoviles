package com.example.crudmoviles;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolder> {

    ArrayList<Usuario> listadeDatos;

    public AdaptadorLista(ArrayList<Usuario> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public AdaptadorLista.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaItemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent, false);

        return new ViewHolder(vistaItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLista.ViewHolder holder, int position) {
        holder.actualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreUsuario;
        TextView edadUsuario;
        ImageView fotoUsuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreUsuario = itemView.findViewById(R.id.nombreUsuario);
            edadUsuario = itemView.findViewById(R.id.edadUsuario);
            fotoUsuario = itemView.findViewById(R.id.foto);

        }

        public void actualizarDatos(Usuario usuario) {
            nombreUsuario.setText(usuario.getNombre() );
            edadUsuario.setText(usuario.getEdad());

        }
    }
}