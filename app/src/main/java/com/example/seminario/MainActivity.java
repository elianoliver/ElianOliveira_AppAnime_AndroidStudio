package com.example.seminario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagem;
    private TextView saudacao;
    private static final int REQUEST_CODE_ALTERAR_NOME = 1;
    private static final String PREF_NOME_USUARIO = "NOME_USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem = findViewById(R.id.ic_perfil);
        saudacao = findViewById(R.id.saudacao);

        // Recuperar nome do usuário ao iniciar a atividade principal
        String nomeUsuario = obterNomeUsuario();
        saudacao.setText("Bem vindo novamente, " + nomeUsuario + "!");
    }

    public void abreSobre(View view) {
        Intent i = new Intent(MainActivity.this, SobreActivity.class);
        startActivityForResult(i, REQUEST_CODE_ALTERAR_NOME);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ALTERAR_NOME && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("NOME_ATUALIZADO")) {
                String nomeAtualizado = data.getStringExtra("NOME_ATUALIZADO");

                // Salvar o nome do usuário nas preferências
                salvarNomeUsuario(nomeAtualizado);

                saudacao.setText("Bem vindo novamente, " + nomeAtualizado + "!");
            }
        }
    }

    private void salvarNomeUsuario(String nome) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREF_NOME_USUARIO, nome);
        editor.apply();
    }

    private String obterNomeUsuario() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getString(PREF_NOME_USUARIO, "Elian");
    }
}
