package org.cidie.mascotas.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cidie.mascotas.pojo.Mascota;
import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.presentador.IRecyclerViewFragmentPresenter;
import org.cidie.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {

    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        RVAdapter adapter = new RVAdapter(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void InicializarAdaptadorRV(RVAdapter adapter) {

        listaMascotas.setAdapter(adapter);
    }
}


    /*

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais", 0, R.drawable.dog1));
        mascotas.add(new Mascota("Sr Rudo", 0, R.drawable.dog2));
        mascotas.add(new Mascota("Negro", 0, R.drawable.dog3));
        mascotas.add(new Mascota("Bobby", 0, R.drawable.dog4));
        mascotas.add(new Mascota("Dj Tito", 0, R.drawable.dog5));
        mascotas.add(new Mascota("Sófocles", 0, R.drawable.dog6));
        mascotas.add(new Mascota("Quencho", 0, R.drawable.dog7));
        mascotas.add(new Mascota("Eratóstenes", 0, R.drawable.dog8));
        mascotas.add(new Mascota("Mr Sancho", 0, R.drawable.dog9));
        mascotas.add(new Mascota("Zira Lala Pink", 0, R.drawable.dog10));
    }
*/
