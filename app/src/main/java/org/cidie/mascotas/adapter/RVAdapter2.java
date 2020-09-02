package org.cidie.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.cidie.mascotas.R;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter2.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public RVAdapter2(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota2, parent, false);
        return new RVAdapter2.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RVAdapter2.MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.mascotaPhoto.setImageResource(mascota.getImage());
        mascotaViewHolder.mascotaRating.setText(String.valueOf(mascota.getRating()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        ImageView mascotaPhoto;
        TextView mascotaRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            mascotaPhoto = (ImageView) itemView.findViewById(R.id.imageDog2);
            mascotaRating = (TextView) itemView.findViewById(R.id.rating2);
        }
    }
}
