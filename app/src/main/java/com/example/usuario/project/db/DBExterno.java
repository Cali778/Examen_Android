package com.example.usuario.project.db;

import android.content.Context;

import pe.edu.upeu.dbexterno.ExternalSQLiteOpenHelper;

public class DBExterno extends ExternalSQLiteOpenHelper{

    public DBExterno(Context context) {
        super(context, "asistenciadb.db", null, 1);
    }
}
