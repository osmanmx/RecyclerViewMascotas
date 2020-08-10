package org.cidie.recyclerviewmascotas;

/**
 *   Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.appcompat.app.AppCompatActivity;
import android.media.Image;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

public class Detalle extends AppCompatActivity {
    ImageView imagenstar;

    ArrayList<Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.Toolbar_name);

        imagenstar=((ImageView)findViewById(R.id.imagenStar));
        imagenstar.setVisibility(View.INVISIBLE);



        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Negro", 10, R.drawable.dog3));
        mascotas.add(new Mascota("Dj Tito", 8, R.drawable.dog5));
        mascotas.add(new Mascota("Quencho", 6, R.drawable.dog7));
        mascotas.add(new Mascota("Mr Sancho", 4, R.drawable.dog9));
        mascotas.add(new Mascota("Sr Rudo", 2, R.drawable.dog2));

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_detalle);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setClickable(false);
        rv.setEnabled(false);
        //rv.setLayoutFrozen(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        RVAdapter adapter = new RVAdapter(mascotas);//se transfiere listado al adaptador
        rv.setAdapter(adapter);

    }
}
