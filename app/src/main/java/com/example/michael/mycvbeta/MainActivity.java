package com.example.michael.mycvbeta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.michael.mycvbeta.fragments.CurriculumVitae;
import com.example.michael.mycvbeta.fragments.Anime;
import com.example.michael.mycvbeta.fragments.Diverse_Information;
import com.example.michael.mycvbeta.fragments.Games;
import com.example.michael.mycvbeta.fragments.MediaFun;
import com.example.michael.mycvbeta.fragments.Professional_Experience;
import com.example.michael.mycvbeta.fragments.TechnicalSkills;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    List<Fragment> listFragments;
    int selfmadeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listFragments = new ArrayList<Fragment>();
        listFragments.add(new CurriculumVitae());
        listFragments.add(new TechnicalSkills());
        listFragments.add(new Professional_Experience());
        listFragments.add(new Diverse_Information());
        listFragments.add(new Anime());
        listFragments.add(new Games());
        listFragments.add(new MediaFun());

        //load first fragment as default:
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, listFragments.get(0)).commit();


//        ImageView greenbytelogo = (ImageView)vq.findViewById(R.id.greenbyteInfoId);
//        greenbytelogo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setTitle("Test");
//                dialog.setContentView(R.layout.nav_header_main);
//            }
//        });

//
//        initViewPager();
//        initTabHost();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // First 4 menu columns
        if (id == R.id.personale__profile_id) {

            selfmadeId = 0;
            //Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_LONG).show();
            CreateFragmentManager(0,selfmadeId);
            // Handle the camera action
        } else if (id == R.id.techinal_skills_id) {
            selfmadeId = 1;
            CreateFragmentManager(1,selfmadeId);

        } else if (id == R.id.professional_id) {
            selfmadeId = 2;
            CreateFragmentManager(2,selfmadeId);

        } else if (id == R.id.diverse_id) {
            selfmadeId = 3;
            CreateFragmentManager(3,selfmadeId);
            // Anime and Games columns
        } else if (id == R.id.anime_id) {
            selfmadeId = 4;
            CreateFragmentManager(4,selfmadeId);

        } else if (id == R.id.games_id) {
            selfmadeId = 5;
            CreateFragmentManager(5,selfmadeId);

        } else if (id == R.id.facebook_id) {
            selfmadeId = 6;
            CreateFragmentManager(6,selfmadeId);
        } else if (id == R.id.youtube_id) {
            selfmadeId = 7;
            CreateFragmentManager(6,selfmadeId);

        } else if (id == R.id.snap_id) {
            selfmadeId = 8;
            CreateFragmentManager(6,selfmadeId);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private  void CreateFragmentManager(int fragmentId, int selfmadeId) {
//        Bundle bundle = new Bundle();
//        bundle.putInt("fragmentId", selfmadeId);
//        CurriculumVitae fragobj = new CurriculumVitae();
//        fragobj.setArguments(bundle);
//        CurriculumVitae argumentFragment = new CurriculumVitae();//Get Fragment Instance
//       //Use bundle to pass data
//        data.putString("data", "This is Argument Fragment");//put string, int, etc in bundle with a key value
//        argumentFragment.setArguments(data);//Finally set argument bundle to fragment

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, listFragments.get(fragmentId)).commit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


}
