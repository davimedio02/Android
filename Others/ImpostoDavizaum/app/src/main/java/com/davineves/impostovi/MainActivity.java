package com.davineves.impostovi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int aux = 1;
    public void TextoImposto(View view){
        TextView texto_robo = findViewById(R.id.robo_texto);

        if(aux == 1) {
            texto_robo.setVisibility(View.VISIBLE);
            aux = 0;
        }
        else if(aux == 0){
            texto_robo.setVisibility(View.INVISIBLE);
            aux = 1;
        }

    }

}
