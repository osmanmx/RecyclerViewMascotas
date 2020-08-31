package org.cidie.mascotas.layout;

/**
 * Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;

import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.cidie.mascotas.pojo.Mascota;
import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.RVAdapter;

import java.util.ArrayList;

public class Detalle extends AppCompatActivity {

    ArrayList<Mascota> mascotasD;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detalle);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotasD = new ArrayList<Mascota>();
        mascotasD.add(new Mascota("Sr Rudo", 12, R.drawable.dog2));
        mascotasD.add(new Mascota("Negro", 10, R.drawable.dog3));
        mascotasD.add(new Mascota("Dj Tito", 8, R.drawable.dog5));
        mascotasD.add(new Mascota("Firulais", 8, R.drawable.dog1));
        mascotasD.add(new Mascota("Sófocles", 7, R.drawable.dog6));
        mascotasD.add(new Mascota("Quencho", 7, R.drawable.dog7));
        mascotasD.add(new Mascota("Mr Sancho", 4, R.drawable.dog9));
        mascotasD.add(new Mascota("Bobby", 4, R.drawable.dog4));


        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_detalle);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setClickable(false);
        rv.setEnabled(false);
        //rv.setLayoutFrozen(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        RVAdapter adapter = new RVAdapter(mascotasD, this);//se transfiere listado al adaptador
        rv.setAdapter(adapter);

    }

}
