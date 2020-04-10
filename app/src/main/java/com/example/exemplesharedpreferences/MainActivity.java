package com.example.exemplesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplesharedpreferences.Entities.Adherent;
import com.example.exemplesharedpreferences.Utilities.Constants;
import com.example.exemplesharedpreferences.Utilities.Functions;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        final Button btnCreateAdherent = findViewById(R.id.btnCreateAdherent);
        final Button btnDeconnection = findViewById(R.id.btnDeconnection);
        final TextView txtAdherent = findViewById(R.id.txtAdherent);

        String adherentJson = Functions.getSharedPreferences(context, Constants.SHARED_ADHERENT);

        if (!adherentJson.isEmpty()) {
            Gson gson = new Gson();
            Adherent adherent = gson.fromJson(adherentJson, Adherent.class);

            txtAdherent.setText("Bonjour " + adherent.getPrenom() + " + " + adherent.getNom());

            btnCreateAdherent.setVisibility(View.INVISIBLE);
            btnDeconnection.setVisibility(View.VISIBLE);
        }

        btnCreateAdherent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FormAdherentActivity.class);
                startActivity(intent);
            }
        });

        btnDeconnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.removeSharedPreferences(context, Constants.SHARED_ADHERENT);
                btnCreateAdherent.setVisibility(View.VISIBLE);
                btnDeconnection.setVisibility(View.INVISIBLE);
                txtAdherent.setText("");
            }
        });
    }
}
