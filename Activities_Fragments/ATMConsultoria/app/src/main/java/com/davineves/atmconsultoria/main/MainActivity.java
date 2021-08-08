package com.davineves.atmconsultoria.main;

import android.content.Intent;
import android.os.Bundle;

import com.davineves.atmconsultoria.R;
import com.davineves.atmconsultoria.ui.clientes.ClientesFragment;
import com.davineves.atmconsultoria.ui.principal.PrincipalFragment;
import com.davineves.atmconsultoria.ui.servicos.ServicosFragment;
import com.davineves.atmconsultoria.ui.sobre.SobreActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabEmail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                /*if(destination.getId() == R.id.nav_principal){

                    PrincipalFragment principalFragment = new PrincipalFragment();
                    FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
                    fragment.replace(R.id.frameContainer, principalFragment);
                    fragment.commit();

                } else if(destination.getId() == R.id.nav_servicos){

                    ServicosFragment servicosFragment = new ServicosFragment();
                    FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
                    fragment.replace(R.id.frameContainer, servicosFragment);
                    fragment.commit();

                } else if(destination.getId() == R.id.nav_clientes){

                    ClientesFragment clientesFragment = new ClientesFragment();
                    FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
                    fragment.replace(R.id.frameContainer, clientesFragment);
                    fragment.commit();

                } else */
                if(destination.getId() == R.id.nav_contato){
                    enviarEmail();
                } else if(destination.getId() == R.id.nav_sobre){
                    startActivity(new Intent(getApplicationContext(), SobreActivity.class));
                }

            }
        });

    }

    //Método enviar email (para tela de contatos e pro FloatButton)
    public void enviarEmail(){

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem automática..");

        //Configurar Apps para E-mail
            //email.setType("image/png");
        email.setType("message/rfc822"); //Aplicativos de Email
        startActivity(Intent.createChooser(email, "Escolha o App de E-Mail"));

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    //Botão voltar pressionado com a NavBar aberta (manter na tela ao invés de sair/voltar pra Main)
    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
