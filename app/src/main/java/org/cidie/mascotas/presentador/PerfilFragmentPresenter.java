package org.cidie.mascotas.presentador;

import android.content.Context;

import org.cidie.mascotas.db.ConstructorMascotas;
import org.cidie.mascotas.fragment.IPerfilFragment;
import org.cidie.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        ObtenerMascotasPerfil();
    }

    @Override
    public void ObtenerMascotasPerfil() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.ObtenerDatosPerfil();
        MostrarMascotasPerfilRV();
    }

    @Override
    public void MostrarMascotasPerfilRV() {
        iPerfilFragment.InicializarAdaptadorRV2(iPerfilFragment.crearAdaptador2(mascotas));
        iPerfilFragment.GenerarGridLayout();
    }
}
