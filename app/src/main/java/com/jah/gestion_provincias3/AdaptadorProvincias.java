package com.jah.gestion_provincias3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AdaptadorProvincias extends RecyclerView.Adapter<AdaptadorProvincias.HolderProvincia> {
    
    List<Provincia> dataSet;
    Provincia p;
    Context context;

    public AdaptadorProvincias(List<Provincia> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdaptadorProvincias.HolderProvincia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        return new HolderProvincia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProvincias.HolderProvincia holder, int position) {
        p = dataSet.get(position);
        
        holder.imgvFoto.setImageResource(p.getFoto());
        holder.lblNombreCom.setText(p.getNombreCom());
        holder.lblNombreProv.setText(p.getNombreProv());
        holder.lblNumHabitantes.setText(String.valueOf(p.getnHabitantes()));
        holder.cvCard.setOnClickListener(view -> irAInternet(holder.getAdapterPosition()));
        holder.cvCard.setOnLongClickListener(view ->{
            verWiki(holder.getAdapterPosition());
            return false;
        });
    }

    private void verWiki(int posicion) {
        Intent intent = new Intent(context, WikiWebView.class);
        intent.putExtra("posicion", posicion);
        context.startActivity(intent);
    }

    private void irAInternet(int posicion) {
        String url = "https://es.wikipedia.org/wiki/" + dataSet.get(posicion).getNombreProv();
        Uri enlace = Uri.parse(url);
        Intent internet = new Intent(Intent.ACTION_VIEW, enlace);
        context.startActivity(internet);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class HolderProvincia extends RecyclerView.ViewHolder {
        
        MaterialCardView cvCard;
        TextView lblNombreCom, lblNombreProv, lblNumHabitantes;
        ImageView imgvFoto;
        
        public HolderProvincia(@NonNull View itemView) {
            super(itemView);
            cvCard = itemView.findViewById(R.id.cvCard);
            lblNombreCom = itemView.findViewById(R.id.lblNombreCom);
            lblNombreProv = itemView.findViewById(R.id.lblNombreProv);
            lblNumHabitantes = itemView.findViewById(R.id.lblNumHabitantes);
            imgvFoto = itemView.findViewById(R.id.imgvFoto);
        }
    }
}
