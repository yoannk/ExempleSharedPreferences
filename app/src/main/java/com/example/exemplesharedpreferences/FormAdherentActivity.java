package com.example.exemplesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.exemplesharedpreferences.Entities.Adherent;
import com.example.exemplesharedpreferences.Utilities.Functions;
import com.google.gson.Gson;

public class FormAdherentActivity extends AppCompatActivity {

    Context context;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_adherent);
        context = this;

        final EditText txtNom = findViewById(R.id.txtNom);
        final EditText txtPrenom = findViewById(R.id.txtPrenom);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtTelephone = findViewById(R.id.txtTelephone);

        final CheckBox chkSeSouvenir = findViewById(R.id.chkSeSouvenir);

        Button btnValider = findViewById(R.id.btnValider);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txtNom.getText().toString().trim();
                String prenom = txtPrenom.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String tel = txtTelephone.getText().toString().trim();

                Adherent adherent = new Adherent();
                adherent.setNom(nom);
                adherent.setPrenom(prenom);
                adherent.setEmail(email);
                adherent.setTelephone(tel);

                if (chkSeSouvenir.isChecked()) {
                    gson = new Gson();
                    String adherentJson = gson.toJson(adherent);
                    Functions.insertSharedPreferences(context, "adherent", adherentJson);
                }

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
