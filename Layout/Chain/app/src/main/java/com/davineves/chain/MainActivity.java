/*
    Modos de Chain (horizontal):

    1°: ligados com espaçamento uniforme e da margem
    2°: os da ponta são colados nas margens da Constraint
    3°: os componentes são centralizados/colados ao meio

    Para vertical valem-se das mesmas regras
 */

/*
  Utilizar atalhos de alinhamento selecionando com botão direito
 */

/*
Aqui utilizar do XML em Texto:

 * Layout Relativo: alinhamento de componentes relacionados entre si; editar no XML em "androidx.constraintlayout.widget.ConstraintLayout" para "RelativeLayout"

 * Layout Linear (Vertical/Horizontal): alinhamento com base em linhas verticais ou horizontais (ocupar espaçamentos); mesmo processo do anterior (porém com "LinearLayout")
    ex: Tela de Login/Cadastro

 Recomendado sempre utilizar ConstraintLayout (pela Google)
 */



package com.davineves.chain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
