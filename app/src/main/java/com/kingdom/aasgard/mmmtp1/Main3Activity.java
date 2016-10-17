package com.kingdom.aasgard.mmmtp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {

    private ListView maListViewPerso;
    private SimpleAdapter mListAdapter;
    private ArrayList<HashMap<String, String>> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        maListViewPerso = (ListView) findViewById(R.id.lvData);

        listItem = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> item;
        item = new HashMap<String, String>();
        item.put("nom", "Lancien");
        item.put("prenom","François-Régis");
        item.put("villeNaissance","Vannes");
        item.put("dateNaissance","11/09/1991");

        listItem.add(item);

        item = new HashMap<String, String>();
        item.put("nom", "Jouvance - Le Bail");
        item.put("prenom","Alexia");
        item.put("villeNaissance","Vannes");
        item.put("dateNaissance","12/06/1991");

        listItem.add(item);

        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        mListAdapter = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.item,
                new String[] {"nom", "prenom", "villeNaissance", "dateNaissance"}, new int[] {R.id.nom, R.id.prenom, R.id.villeNaissance, R.id.dateNaissance});

        //On attribue à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mListAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
