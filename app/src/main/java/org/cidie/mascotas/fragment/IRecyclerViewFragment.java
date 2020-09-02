package org.cidie.mascotas.fragment;

import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();

    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorRV(RVAdapter adapter);

}
