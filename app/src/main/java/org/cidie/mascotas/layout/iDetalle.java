package org.cidie.mascotas.layout;

import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface iDetalle {

    public void GenerarLLM();

    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorLikes(RVAdapter adapter);

}
