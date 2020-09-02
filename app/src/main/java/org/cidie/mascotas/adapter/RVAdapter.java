package org.cidie.mascotas.adapter;

/**
 * Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.cidie.mascotas.db.ConstructorMascotas;
import org.cidie.mascotas.pojo.Mascota;
import org.cidie.mascotas.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public RVAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NotNull
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        MascotaViewHolder pvh = new MascotaViewHolder(v);
        return pvh;
    }

    //Inflar el layout y lo pasará al viewHolder para obtener a su vez cada elemento, i.e., los views

    //Asocia cada elemento de la lista con su respectiva view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.mascotaPhoto.setImageResource(mascota.getImage());
        mascotaViewHolder.mascotaName.setText(mascota.getName());
        mascotaViewHolder.mascotaRating.setText(String.valueOf(mascota.getRating()));
        mascotaViewHolder.mascotaBone.setTag(mascotaViewHolder);

        mascotaViewHolder.mascotaBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getName(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.DarLike(mascota);
                mascotaViewHolder.mascotaRating.setText(String.valueOf(constructorMascotas.ObtenerLikes(mascota)));
/*
        if (mascota.getRating() == 0)
            mascotaViewHolder.mascotaBone.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    MascotaViewHolder mH = (MascotaViewHolder) v.getTag();
                    mH.mascotaRating.setText(String.valueOf(1 + Integer.parseInt(mH.mascotaRating.getText().toString())));

*/
            }
        });

    }

    @Override
    public int getItemCount() { //cantidad de elemtos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        CardView cvMascota;
        TextView mascotaName;
        TextView mascotaRating;
        ImageView mascotaPhoto;
        ImageButton mascotaBone;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            cvMascota = (CardView) itemView.findViewById(R.id.cvMascota);
            mascotaPhoto = (ImageView) itemView.findViewById(R.id.imageDog);
            mascotaName = (TextView) itemView.findViewById(R.id.name_dog);
            mascotaRating = (TextView) itemView.findViewById(R.id.rating);
            mascotaBone = (ImageButton) itemView.findViewById(R.id.iconBone);
        }

    }

}
