package com.example.arraydeobjetos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
    TextView full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        full = findViewById(R.id.textViewFull);

        // recuperar os dados da Intent
        Intent it = getIntent();

        // recuperar os dados do ArrayList
        ArrayList<Pessoa> listaPessoas = (ArrayList) it.getSerializableExtra("pessoas");

        // variável para concatenar os objetos Pessoa
        String todos = new String();

        // itera (percorre) sobre o ArrayList "listaPessoas"
        // laço de repetição conhecido como foreach
        for (Pessoa p : listaPessoas) {
            todos += p.toString() + "\n";
        }

        // atribui o resultado do processamento para a TextView (full)
        full.setText(todos);
    }
}
