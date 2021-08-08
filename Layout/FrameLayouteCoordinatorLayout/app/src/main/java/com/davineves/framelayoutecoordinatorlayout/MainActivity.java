/*
   Frame e Coordinator Layout: "empilhar" componentes (sobrepor um ao outro)
   Ambos necessitam ir até o próprio XML (texto) e alterar o componente de ConstraintLayout
   ("androidx.constraintlayout.widget.ConstraintLayout") para as opções abaixo


   Frame Layout: separado por frames (anterior ao ConstraintLayout).
                *layout gravity nos componentes para alinhamento

   Coordinator Layout: separado por coordenadas. Descontinuado pela Google (substituído pelo AndroidX)

   OBS: ambos funcionam da mesma maneira para o empilhamento de componentes

*/

package com.davineves.framelayoutecoordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //frameLayout = findViewById(R.id.frameCarregando);
        //frameLayout.setVisibility(View.GONE); //Gone = não fica presente - Invisible = não aparece para o user mas está lá
    }

    /*public void abrir(View view){
        frameLayout.setVisibility(View.VISIBLE);
    }*/
}
