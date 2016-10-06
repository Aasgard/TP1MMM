package com.kingdom.aasgard.mmmtp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nom = extras.getString("nom");
            String prenom = extras.getString("prenom");
            String dateDeNaissance = extras.getString("dateDeNaissance");
            String departement = extras.getString("departement");
            String villeDeNaissance = extras.getString("villeDeNaissance");

            TextView tvNom = (TextView) findViewById(R.id.tvNom);
            tvNom.setText("Nom : " + nom);

            TextView tvPrenom = (TextView) findViewById(R.id.tvPrenom);
            tvPrenom.setText("Prénom : " + prenom);

            TextView tvDateDeNaissance = (TextView) findViewById(R.id.tvDateDeNaissance);
            tvDateDeNaissance.setText("Date de naissance : " + dateDeNaissance);

            TextView tvVilleNaissance = (TextView) findViewById(R.id.tvVilleNaissance);
            tvVilleNaissance.setText("Ville de naissance : " + villeDeNaissance);

            TextView tvDepartement = (TextView) findViewById(R.id.tvDepartement);
            tvDepartement.setText("Département : " + departement);
        }

    }
}
