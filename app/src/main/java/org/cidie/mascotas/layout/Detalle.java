package org.cidie.mascotas.layout;

/**
 * Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.cidie.mascotas.pojo.Mascota;
import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.RVAdapter;
import org.cidie.mascotas.presentador.DetallePresenter;
import org.cidie.mascotas.presentador.IDetallePresenter;

import java.util.ArrayList;

public class Detalle extends AppCompatActivity implements iDetalle {

    //    Toolbar toolbar;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IDetallePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_detalle);

        presenter = new DetallePresenter(this, this);

//        toolbar = (Toolbar) findViewById(R.id.miActionBar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
        /*
        mascotasD = new ArrayList<Mascota>();
        mascotasD.add(new Mascota("Sr Rudo", 12, R.drawable.dog2));
        mascotasD.add(new Mascota("Negro", 10, R.drawable.dog3));
        mascotasD.add(new Mascota("Dj Tito", 8, R.drawable.dog5));
        mascotasD.add(new Mascota("Firulais", 8, R.drawable.dog1));
        mascotasD.add(new Mascota("Sófocles", 7, R.drawable.dog6));
        mascotasD.add(new Mascota("Quencho", 7, R.drawable.dog7));
        mascotasD.add(new Mascota("Mr Sancho", 4, R.drawable.dog9));
        mascotasD.add(new Mascota("Bobby", 4, R.drawable.dog4));

        */


    @Override
    public void GenerarLLM() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        RVAdapter adapter = new RVAdapter(mascotas, Detalle.this);
        return adapter;
    }

    @Override
    public void InicializarAdaptadorLikes(RVAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}