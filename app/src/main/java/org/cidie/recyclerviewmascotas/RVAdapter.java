package org.cidie.recyclerviewmascotas;

/**
 *   Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
//    Activity activity;

    public RVAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
  //      this.activity = activity;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        CardView cvMascota;
        TextView mascotaName;
        TextView mascotaRating;
        ImageView mascotaPhoto;
        ImageView iconBone;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            cvMascota 		= (CardView)itemView.findViewById(R.id.cvMascota);
            mascotaPhoto 	= (ImageView)itemView.findViewById(R.id.imageDog);
            mascotaName 	= (TextView)itemView.findViewById(R.id.name_dog);
            mascotaRating 	= (TextView)itemView.findViewById(R.id.rating);
            iconBone 		= (ImageView)itemView.findViewById(R.id.iconBone);
        }

    }

    @Override
    public int getItemCount() { //cantidad de elemtos que contiene mi lista de mascotas
        return mascotas.size();
    }

    //Inflar el layout y lo pasará al viewHolder para obtener a su vez cada elemento, i.e., los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        MascotaViewHolder pvh = new MascotaViewHolder(v);
        return pvh;
    }
    //Asocia cada elemento de la lista con su respectiva view
    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.mascotaPhoto.setImageResource(mascota.getImage());
        mascotaViewHolder.mascotaName.setText(mascota.getName());
        mascotaViewHolder.mascotaRating.setText(String.valueOf(mascota.getRating()));
        mascotaViewHolder.iconBone.setTag(mascotaViewHolder);

       if (mascota.getRating()==0)
        mascotaViewHolder.iconBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MascotaViewHolder mH = (MascotaViewHolder) v.getTag();
                mH.mascotaRating.setText(String.valueOf(1 + Integer.parseInt(mH.mascotaRating.getText().toString())));

            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
