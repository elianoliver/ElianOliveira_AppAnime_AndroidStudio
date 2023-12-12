package com.example.seminario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SobreActivity extends AppCompatActivity {

    EditText editNome;
    EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        editNome = findViewById(R.id.EditNome);
        editEmail = findViewById(R.id.EditEmail);
    }

    public void alterarNome(View view) {
        String novoNome = editNome.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("NOME_ATUALIZADO", novoNome);
        setResult(RESULT_OK, intent);

        // Exibir Toast informando que as informações foram alteradas
        Toast toast = Toast.makeText(this, "Informações alteradas com sucesso!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        toast.show();
    }
}