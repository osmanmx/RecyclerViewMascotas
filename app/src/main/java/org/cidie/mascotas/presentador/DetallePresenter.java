package org.cidie.mascotas.presentador;

import android.content.Context;

import org.cidie.mascotas.db.ConstructorMascotas;
import org.cidie.mascotas.layout.iDetalle;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class DetallePresenter implements IDetallePresenter {

    private iDetalle iDetalle;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public DetallePresenter(iDetalle iDetalle, Context context) {
        this.iDetalle = iDetalle;
        this.context = context;
        Obtener5Mascotas();
    }

    @Override
    public void Obtener5Mascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.Obtener5Mascotas();
        MostrarMascotasLikes();
    }

    @Override
    public void MostrarMascotasLikes() {
        iDetalle.InicializarAdaptadorLikes(iDetalle.crearAdaptador(mascotas));
        iDetalle.GenerarLLM();
    }
}
