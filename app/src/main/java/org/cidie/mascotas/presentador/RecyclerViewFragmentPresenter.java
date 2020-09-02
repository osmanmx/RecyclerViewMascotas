package org.cidie.mascotas.presentador;

import android.content.Context;

import org.cidie.mascotas.db.ConstructorMascotas;
import org.cidie.mascotas.fragment.IRecyclerViewFragment;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        ObtenerMascotasBD();
    }

    @Override
    public void ObtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.ObtenerDatos();
        MostrarMascotasRV();
    }

    @Override
    public void MostrarMascotasRV() {
        iRecyclerViewFragment.InicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}