package com.ems.bdsqlite.crud;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlite.MainActivity;
import com.ems.bdsqlite.R;
import com.ems.bdsqlite.pojo.Aluno;
import com.ems.bdsqlite.utils.Banco;

public class Editar extends AppCompatActivity {

    EditText ra, nome, curso;
    ImageButton btSalvar, btVoltar;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Editar Aluno");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ra = findViewById(R.id.editTextRa);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);

        // ler os dados da Intent Listar
        Intent itAluno = getIntent();
        final Aluno aluno = (Aluno) itAluno.getExtras().getSerializable("objAluno");
        ra.setText(aluno.getRa());
        nome.setText(aluno.getNome());
        curso.setText(aluno.getCurso());

        btSalvar = findViewById(R.id.btSalvar);
        btVoltar = findViewById(R.id.btVoltar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abertura ou Criação do Banco de Dados
                db = openOrCreateDatabase(
                        Banco.banco(),
                        Context.MODE_PRIVATE,
                        null);

                // cria o SQL para atualizar no banco
                db.execSQL(
                        "UPDATE " + Banco.tabela() + " SET " +
                                "ra=" + Integer.parseInt(ra.getText().toString()) + ", " +
                                "nome='" + nome.getText().toString() + "', " +
                                "curso='" + curso.getText().toString() + "' " +
                                "WHERE id=" + aluno.getId()
                );
                showLockTaskEscapeMessage();

                Toast.makeText(Editar.this, "Registro alterado com sucesso!",
                        Toast.LENGTH_LONG).show();

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                finish();
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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