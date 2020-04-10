package com.example.exemplesharedpreferences.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class Functions {
    public static final boolean insertSharedPreferences(Context context, String key, String value) {
        // Fichier de stockage de données interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        // Ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (!sharedPreferences.contains(key)) {
            editor.putString(key, value);
        }

        return editor.commit();
    }

    public static final String getSharedPreferences(Context context, String key) {
        // Fichier de stockage de données interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, "");
    }

    public static final boolean removeSharedPreferences(Context context, String key) {
        // Fichier de stockage de données interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        // Ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (sharedPreferences.contains(key)) {
            editor.remove(key);
        }

        return editor.commit();
    }
}
