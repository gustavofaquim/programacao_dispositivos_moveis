package com.example.encontro25;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDados extends RecyclerView.Adapter<AdapterDados.ViewHolder> {

    ArrayList<Item> listaDados;

    public AdapterDados(ArrayList<Item> listaDados){
        this.listaDados = listaDados;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.descricao.setText(listaDados.get(position).getDescricao());
        holder.foto.setImageResource(listaDados.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaDados.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descricao;
        ImageView foto;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            descricao = itemView.findViewById(R.id.idDescricao);
            foto = itemView.findViewById(R.id.idFoto);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Toast.makeText(itemView.getContext(), descricao.getText(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


}


