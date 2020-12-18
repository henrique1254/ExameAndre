package com.example.exameandre;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>
{
    private List<Dog> listcachorro;

    public Adapter(List<Dog> lista)
    {
        this.listcachorro = lista;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_caes,parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Dog cachorro = listcachorro.get(position);
        holder.Nome.setText(cachorro.getNome());
        holder.Genero.setText(cachorro.getGenero());
        holder.Raca.setText((cachorro.getRaca()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Nome;
        TextView Raca;
        TextView Genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Nome = itemView.findViewById(R.id.nome);
            Raca = itemView.findViewById(R.id.raca);
            Genero = itemView.findViewById(R.id.genero);
        }
    }
}
