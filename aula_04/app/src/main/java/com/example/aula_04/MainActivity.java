//pacote da aplicação
package com.example.aula_04;

//importação de bibliotecas do Android

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// a linha abaixo é a declaração da classe principal do programa
public class MainActivity extends AppCompatActivity {
    EditText nome, sobrenome;
    Button concatenar;
    TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // aqui as variáveis são de escopo LOCAL
        super.onCreate(savedInstanceState);

        // A linha abaixo mostra a TELA que criamos (layout)
        setContentView(R.layout.activity_main);

        // aqui vamos associar os componentes do layout com as variáveis que declaramos acima
        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        concatenar = findViewById(R.id.buttonConcatenar);
        saida = findViewById(R.id.textViewSaida);

        // vamos usar o botão para capturar o evento do click
        concatenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pega o valor digitado no campo (componente) nome
                String vNome = nome.getText().toString();
                String vSobrenome = sobrenome.getText().toString();

                // atribui um valor texto para o objeto saida, usando o método setText()
                saida.setText(vNome + " " + vSobrenome);

            }

        });
    }
}
