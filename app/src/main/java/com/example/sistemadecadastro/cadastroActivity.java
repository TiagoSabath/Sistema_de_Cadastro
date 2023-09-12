package com.example.sistemadecadastro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cadastroActivity extends AppCompatActivity {
    EditText ednome, edendereco, edtelefone;
    Button btcadastrar, btcancelar_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ednome = findViewById(R.id.ednome);
        edendereco = findViewById(R.id.edendereco);
        edtelefone = findViewById(R.id.edtelefone);
        btcadastrar = findViewById(R.id.btcadastrar);
        btcancelar_cadastro = findViewById(R.id.btcancelar_cadastro);

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialago = new AlertDialog.Builder(cadastroActivity.this);
                dialago.setTitle("Aviso");
                dialago.setMessage("Cadastrar usuário ?");
                dialago.setNegativeButton("Não", null);
                dialago.setPositiveButton("Sim", (dialogInterface, i) -> {
                    String nome = ednome.getText().toString();
                    String endereco = edendereco.getText().toString();
                    String telefone = edtelefone.getText().toString();

                    RegistrosManager.getRegistros().add(new Registro(nome, endereco,telefone));

                    (new android.app.AlertDialog.Builder(cadastroActivity.this)).setTitle("Aviso").setMessage("Cadastro efetuado com sucesso!")
                            .setNeutralButton("Ok", (dialogInterface1, i1) -> {
                                cadastroActivity.this.finish();
                           })
                            .show();


                });
                dialago.show();
            }
        });

        btcancelar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroActivity.this.finish();
            }
        });
    }
}