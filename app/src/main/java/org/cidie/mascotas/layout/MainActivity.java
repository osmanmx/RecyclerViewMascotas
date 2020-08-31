package org.cidie.mascotas.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;

import com.google.android.material.tabs.TabLayout;

import org.cidie.mascotas.R;
import org.cidie.mascotas.adapter.PageAdapter;
import org.cidie.mascotas.fragment.PerfilFragment;
import org.cidie.mascotas.fragment.RecyclerViewFragment;
import org.cidie.mascotas.pojo.Mascota;

/**
 * Created by Osman Villanueva García - osman@cidie.org (julio 2020)
 */

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    /*    boolean bandera;
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mContact:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            case R.id.mFav:
                Intent j = new Intent(this, Detalle.class);
                startActivity(j);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.contact);

    }

}
