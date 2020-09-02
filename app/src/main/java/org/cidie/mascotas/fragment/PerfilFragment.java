package org.cidie.mascotas.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.adapter.RVAdapter2;
import org.cidie.mascotas.pojo.Mascota;
import org.cidie.mascotas.presentador.IPerfilFragmentPresenter;
import org.cidie.mascotas.presentador.PerfilFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Osman Villanueva García - osman@cidie.org (agosto 2020)
 */

public class PerfilFragment extends Fragment implements IPerfilFragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IPerfilFragmentPresenter presenter;

    public PerfilFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        CircularImageView circularImageView = v.findViewById(R.id.imgCircular);
        // Set Color
        circularImageView.setCircleColor(Color.WHITE);
        // or with gradient
        circularImageView.setCircleColorStart(Color.BLACK);
        circularImageView.setCircleColorEnd(Color.RED);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);
        // or with gradient
        circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Add Shadow with default param
        circularImageView.setShadowEnable(true);
        // or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.RED);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        presenter = new PerfilFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void GenerarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public RVAdapter2 crearAdaptador2(ArrayList<Mascota> mascotas) {
        RVAdapter2 adapter = new RVAdapter2(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void InicializarAdaptadorRV2(RVAdapter2 adaptador2) {
        listaMascotas.setAdapter(adaptador2);
    }
}

/*
    public void inicializarListaMiMascota() {

        miMascota = new ArrayList<Mascota>();

        miMascota.add(new Mascota("Rudo", 12, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 8, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 7, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 6, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 5, R.drawable.dog2));
        miMascota.add(new Mascota("Rudo", 3, R.drawable.dog2));
    }
*/
