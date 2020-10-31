package com.ems.bdsqlite.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlite.R;
import com.ems.bdsqlite.pojo.Aluno;


public class Detalhes extends AppCompatActivity {
    ImageButton btEditar, btExcluir, btVoltar, btHome;
    TextView id, ra, nome, curso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Detalhes do Aluno");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.textViewId_detalhes);
        ra = findViewById(R.id.textViewRa_detalhes);
        nome = findViewById(R.id.textViewNome_detalhes);
        curso = findViewById(R.id.textViewCurso_detalhes);

        btEditar = findViewById(R.id.btEditar);
        btExcluir = findViewById(R.id.btExcluir);
        btVoltar = findViewById(R.id.btVoltar);
        btHome = findViewById(R.id.btHome);

        // ler os dados da Intent Listar
        Intent itAluno = getIntent();
        final Aluno aluno = (Aluno) itAluno.getExtras().getSerializable("objAluno");
        id.setText(String.valueOf(aluno.getId()));
        ra.setText(aluno.getRa());
        nome.setText(aluno.getNome());
        curso.setText(aluno.getCurso());

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itEditar = new Intent(
                        getApplicationContext(),
                        Editar.class);
                itEditar.putExtra("objAluno", aluno);
                startActivity(itEditar);
            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itEditar = new Intent(
                        getApplicationContext(),
                        Excluir.class);
                itEditar.putExtra("objAluno", aluno);
                startActivity(itEditar);
            }
        });
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    // Configura o botão (seta) na ActionBar (Barra Superior)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}