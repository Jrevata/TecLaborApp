package com.jrevata.teclaborapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.adapters.TestAdapter;
import com.jrevata.teclaborapp.models.ResponseMessage;
import com.jrevata.teclaborapp.models.Test;
import com.jrevata.teclaborapp.models.Usuario;
import com.jrevata.teclaborapp.repositories.TestRepository;
import com.jrevata.teclaborapp.repositories.UsuarioRepository;
import com.jrevata.teclaborapp.services.ApiService;
import com.jrevata.teclaborapp.services.ApiServiceGenerator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private CircleImageView photoImage;
    private GridView gridView;
    private TextView fullnameText, emailText, listTestText;
    private List<Test> testList;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(UsuarioRepository.verifyLogeo()){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        initializeNavigatorMenu();

        listTestText = findViewById(R.id.textview_verify_list_test);


        gridView = findViewById(R.id.gridView_tests);
        gridView.setAdapter(new TestAdapter(this));

        testList = TestRepository.listTests();

        if(!testList.isEmpty())
            listTestText.setVisibility(View.INVISIBLE);

        TestAdapter adapter = (TestAdapter) gridView.getAdapter();
        adapter.setTestAdapter(testList);
        adapter.notifyDataSetChanged();







    }

    private void initializeNavigatorMenu(){
        Toolbar toolbar = findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_menu);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Change navigation header information
        photoImage = navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        Usuario user = UsuarioRepository.getUser();

        String url = ApiService.API_BASE_URL + "/foto/" + user.getToken() + "/"+user.getUsuario();
        Picasso.with(this).load(url).into(photoImage);


        fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(user.getNomuno() + " " + user.getNomdos() + " " + user.getPaterno() + " " + user.getMaterno());

        emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText(user.getCorreo());




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()) {
                    case R.id.nav_new_test:

                        Intent intent = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.nav_logout:

                        showAlertLogout();

                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void logout(){

        ApiService api = ApiServiceGenerator.createService(this, ApiService.class);

        Call<ResponseMessage> call = api.logout();

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode );


                    if (response.isSuccessful()) {

                        UsuarioRepository.logout();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {

            }
        });

    }

    private void showAlertLogout(){
        new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Finalizar Sesión")
                .setMessage("¿Está seguro de cerrar sesión?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        logout();


                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
