package com.example.sistemadecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class listagemActivity extends AppCompatActivity {
    Button btanterior, btproximo, btfechar;
    TextView txtstatus, txtnome, txtendereco, txttelefone;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        btanterior = findViewById(R.id.btanterior);
        btproximo = findViewById(R.id.btproximo);
        btfechar = findViewById(R.id.btfechar);
        txtendereco = findViewById(R.id.txtendereco);
        txtnome = findViewById(R.id.txtnome);
        txttelefone = findViewById(R.id.txttelefone);
        txtstatus = findViewById(R.id.txtstatus);

        PreencheCampos(index);
        AtualizeStatus(index);

        btanterior.setOnClickListener(view -> {
            if (index > 0 ){
                index --;
                PreencheCampos(index);
                AtualizeStatus(index);
            }else {

                Toast.makeText(this,"Não tem mais cadastro", Toast.LENGTH_SHORT).show();
            }
        });

        btproximo.setOnClickListener(view -> {
            if (index < RegistrosManager.getRegistros().size() - 1) {
                index++;
                PreencheCampos(index);
                AtualizeStatus(index);
            }else {

                Toast.makeText(this,"Não tem mais cadastro", Toast.LENGTH_SHORT).show();
            }
        });

        btfechar.setOnClickListener(view -> listagemActivity.this.finish());
    }

    private void PreencheCampos(int index) {
        txtnome.setText(RegistrosManager.getRegistros().get(index).getNome());
        txttelefone.setText(RegistrosManager.getRegistros().get(index).getTelefone());
        txtendereco.setText(RegistrosManager.getRegistros().get(index).getEndereco());
    }

    private void AtualizeStatus(int index) {
        int total = RegistrosManager.getRegistros().size();
        txtstatus.setText("Registros: " + (index + 1) + "/" + total);
    }
}