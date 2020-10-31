package com.ems.bdsqlite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlite.crud.Listar;
import com.ems.bdsqlite.crud.Novo;
import com.ems.bdsqlite.utils.Banco;

public class MainActivity extends AppCompatActivity {
    ImageButton btNovo, btListar, btSair;

    // criar uma variável para receber a instância do banco de dados
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Abertura ou Criação do Banco de Dados
        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null);

        // Criar a tabela no banco de dados, caso ela não exista
        db.execSQL(Banco.criaTabela());

        btNovo = findViewById(R.id.btNovo);
        btListar = findViewById(R.id.btListar_main);
        btSair = findViewById(R.id.btSair);

        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itNovo = new Intent(getApplicationContext(), Novo.class);
                startActivity(itNovo);
            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itListar = new Intent(getApplicationContext(), Listar.class);
                startActivity(itListar);
            }
        });

        // Associa e configura o botão para sair da aplicação
        btSair = findViewById(R.id.btSair);
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza a aplicação e remove da pilha
                finishAffinity();
            }
        });
    }
}
