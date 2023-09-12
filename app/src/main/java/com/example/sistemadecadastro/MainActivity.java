package com.example.sistemadecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_cadastrar_usuario, bt_listar_usuarios_cadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_cadastrar_usuario= findViewById(R.id.btcadastrar_usuario);
        bt_listar_usuarios_cadastrados = findViewById(R.id.bt_listar_usuarios_cadastrados);

        bt_cadastrar_usuario.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, cadastroActivity.class);
            startActivity(intent);
        });

        bt_listar_usuarios_cadastrados.setOnClickListener(view -> {
            if (RegistrosManager.getRegistros().size() == 0){
                (new AlertDialog.Builder(MainActivity.this)).setTitle("Aviso")
                        .setMessage("Não existe nenhum registro cadastro.").setNeutralButton("OK",null).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, listagemActivity.class);
            startActivity(intent);
        });
    }
}