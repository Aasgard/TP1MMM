package com.kingdom.aasgard.mmmtp1;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.Nullable;


public class LibraryContentProvider extends ContentProvider {


    public Client data[];

    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String DATENAISSANCE = "dateNaissance";
    public static final String VILLENAISSANCE = "villeNaissance";

    static final String AUTHORITY = "librarycontentprovider";
    public static final String PROVIDER_NAME = "librarycontentprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);


    @Override
    public boolean onCreate() {
        // initialiser des données ici (on simule l'existence d'une BD)

        data = new Client[3];
        data[0] = new Client("Lancien", "Francçois-Régis", "11/09/1991", "Vannes");
        data[1] = new Client("Jouvance - Le Bail", "Alexia", "12/06/1991", "Vannes");
        data[2] = new Client("Le Pévédic", "William", "10/10/1992", "Lorient");

        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        MatrixCursor c = new MatrixCursor(new String[]{NOM, PRENOM, DATENAISSANCE, VILLENAISSANCE});

        int row_index = 0;

        for (int i = 0; i < data.length; i++) {

            c.newRow()
                    .add(row_index)
                    .add(data[row_index].nom)
                    .add(data[row_index].prenom)   // Only create data for the first series.
                    .add(data[row_index].dateNaissance)
                    .add(data[row_index].villeNaissance);
            row_index++;
        }

        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return ContentResolver.CURSOR_DIR_BASE_TYPE + '/' + "com.clients";
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
