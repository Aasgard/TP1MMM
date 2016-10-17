package com.kingdom.aasgard.mmmtp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText nomField = (EditText) findViewById(R.id.etNom);
        EditText numeroTelephoneField = (EditText) findViewById(R.id.edNumeroTelephone);
        nomField.requestFocus();
        numeroTelephoneField.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.miResetForm:

                EditText nomField = (EditText) findViewById(R.id.etNom);
                nomField.getText().clear();
                EditText prenomField = (EditText) findViewById(R.id.etPrenom);
                prenomField.getText().clear();
                EditText dateNaissanceField = (EditText) findViewById(R.id.etDateDeNaissance);
                dateNaissanceField.getText().clear();
                EditText villeNaissanceField = (EditText) findViewById(R.id.etVilleNaissance);
                villeNaissanceField.getText().clear();

                nomField.requestFocus();

                return true;

            case R.id.miAddPhoneNumber:

                EditText numeroTelephoneField = (EditText) findViewById(R.id.edNumeroTelephone);
                numeroTelephoneField.setVisibility(View.VISIBLE);

                return true;

            case R.id.miWikiSearch:

                Spinner spinner = (Spinner) findViewById(R.id.spinnerDepartements);
                String URLToVisit = "https://fr.wikipedia.org/wiki/" + spinner.getSelectedItem().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URLToVisit));
                startActivity(intent);

                return true;

            case R.id.miListeClients:

                Intent openList = new Intent(getBaseContext(), Main3Activity.class);
                startActivity(openList);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void validateForm(View view) {

        EditText nomField = (EditText) findViewById(R.id.etNom);
        String nomContent = nomField.getText().toString();

        EditText prenomField = (EditText) findViewById(R.id.etPrenom);
        String prenomContent = prenomField.getText().toString();

        EditText dateNaissanceField = (EditText) findViewById(R.id.etDateDeNaissance);
        String dateNaissanceContent = dateNaissanceField.getText().toString();

        EditText villeNaissanceField = (EditText) findViewById(R.id.etVilleNaissance);
        String villeNaissanceContent = villeNaissanceField.getText().toString();

        Spinner spinnerField = (Spinner) findViewById(R.id.spinnerDepartements);
        String spinnerDepartementsContent = spinnerField.getSelectedItem().toString();

        String displayedContent = "Nom : " + nomContent + "\nPrénom : " + prenomContent + "\nDate de naissance : " + dateNaissanceContent + "\nVille de naissance : " + villeNaissanceContent;

        //Toast.makeText(getApplicationContext(), displayedContent, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        intent.putExtra("nom", nomContent);
        intent.putExtra("prenom", prenomContent);
        intent.putExtra("dateDeNaissance", dateNaissanceContent);
        intent.putExtra("departement", spinnerDepartementsContent);
        intent.putExtra("villeDeNaissance", villeNaissanceContent);
        startActivity(intent);

    }
}
