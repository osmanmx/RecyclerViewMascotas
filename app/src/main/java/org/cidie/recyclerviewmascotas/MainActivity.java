package org.cidie.recyclerviewmascotas;

/**
 *   Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import java.util.ArrayList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import static org.cidie.recyclerviewmascotas.R.id.rvMascotas;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
/*    boolean bandera;
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.Toolbar_name);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        /*GridLayout glm = new GridLayout(this,2);
        */
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdapter();

    }

    public void irDetalle(View v){
        Intent intent= new Intent(this, Detalle.class);
        startActivity(intent);

    }

    public void inicializarAdapter(){
        RVAdapter adapter = new RVAdapter(mascotas);
        listaMascotas.setAdapter(adapter);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais",0,R.drawable.dog1));
        mascotas.add(new Mascota("Sr Rudo",0,R.drawable.dog2));
        mascotas.add(new Mascota("Negro",0,R.drawable.dog3));
        mascotas.add(new Mascota("Bobby",0,R.drawable.dog4));
        mascotas.add(new Mascota("Dj Tito",0,R.drawable.dog5));
        mascotas.add(new Mascota("Sófocles",0,R.drawable.dog6));
        mascotas.add(new Mascota("Quencho",0,R.drawable.dog7));
        mascotas.add(new Mascota("Eratóstenes",0,R.drawable.dog8));
        mascotas.add(new Mascota("Mr Sancho",0,R.drawable.dog9));
        mascotas.add(new Mascota("Zira Lala Pink",0,R.drawable.dog10));
    }

}
