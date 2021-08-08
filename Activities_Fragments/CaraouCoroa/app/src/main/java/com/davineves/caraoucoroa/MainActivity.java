package com.davineves.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJogar = findViewById(R.id.btJogar);
        btJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JogarActivity.class);

                //Gerando número aleatório e passando para a próxima tela
                int numero = new Random().nextInt(2);
                intent.putExtra("Numero", numero);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
