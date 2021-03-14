package com.example.encontro29;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.nome.setText(listaDados.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaDados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.idNome);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listaDados.size() > 0){
                        Item item = listaDados.get(getLayoutPosition());
                        Intent it = new Intent(itemView.getContext(), MainActivity.class);
                        it.putExtra("DADOS", item);
                        itemView.getContext().startActivity(it);
                    }
                }
            });
        }
    }
}
