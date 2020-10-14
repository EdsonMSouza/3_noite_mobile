package com.example.projetolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView nome, sobrenome, curso;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resutlado);
        nome = findViewById(R.id.textViewNome);
        sobrenome = findViewById(R.id.textViewSobrenome);
        curso = findViewById(R.id.textViewCurso);
        btVoltar = findViewById(R.id.buttonVoltar);

        Intent it = getIntent();
        Pessoa p = (Pessoa) it.getSerializableExtra("pessoa");

        nome.setText(p.getNome());
        sobrenome.setText(p.getSobrenome());
        curso.setText(p.getCurso());

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}