package com.davineves.progressbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar barra_horizontal, barra_circular;
    //private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra_horizontal = findViewById(R.id.progressbarHorizontal);
        barra_circular = findViewById(R.id.progressbarCarregando);

        barra_circular.setVisibility(View.GONE);
    }

    public void carregarProgressBar(View view){

        barra_circular.setVisibility(View.VISIBLE);

        //Criação de uma Thread (plano de fundo independente)
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<=100; i++)
                {
                    final int progresso = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            barra_horizontal.setProgress(progresso);
                            if(progresso == 100){
                                barra_circular.setVisibility(View.GONE);
                            }
                        }
                    });
                    try {
                        Thread.sleep(100); //delay para execução do for
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


}
