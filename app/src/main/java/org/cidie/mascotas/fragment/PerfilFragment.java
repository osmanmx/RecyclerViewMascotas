package org.cidie.mascotas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Osman Villanueva García - osman@cidie.org (agosto 2020)
 */

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> miMascota;
    private RecyclerView imagesMiMascota;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        imagesMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        imagesMiMascota.setLayoutManager(gridLayoutManager);
        inicializarListaMiMascota();
        inicializarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    public void inicializarListaMiMascota() {

        miMascota = new ArrayList<Mascota>();

        miMascota.add(new Mascota("Rudo", 12, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 8, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 7, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 6, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 5, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 3, R.drawable.dog2));
    }

    public void inicializarAdaptador() {

        RVAdapter adapter = new RVAdapter(miMascota, getActivity());//se transfiere listado al adaptador
        imagesMiMascota.setAdapter(adapter);
    }

}
