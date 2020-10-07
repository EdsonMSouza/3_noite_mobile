package com.example.objetointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView nome, sobrenome, todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        nome = findViewById(R.id.textViewNome);
        sobrenome = findViewById(R.id.textViewSobrenome);
        todos = findViewById(R.id.textViewTodos);

        // recuperar a intent
        Intent it = getIntent();

        // vamos pegar o objeto pessoa usando a tag "pessoa"
        Pessoa p = (Pessoa) it.getSerializableExtra("pessoa");

        // agora é tudo igual a aula passada
        nome.setText(p.getNome());
        sobrenome.setText(p.getSobrenome());
    }
}