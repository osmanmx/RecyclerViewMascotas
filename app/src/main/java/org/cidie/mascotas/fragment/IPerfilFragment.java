package org.cidie.mascotas.fragment;

import org.cidie.mascotas.adapter.RVAdapter2;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragment {

    public void GenerarGridLayout();

    public RVAdapter2 crearAdaptador2(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorRV2(RVAdapter2 adapter2);

}