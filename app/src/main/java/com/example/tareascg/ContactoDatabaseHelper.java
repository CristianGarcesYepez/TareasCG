package com.example.tareascg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactoDatabaseHelper extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "contactos.db";
    private static final int DATABASE_VERSION = 1;
    
    // Tabla contactos
    public static final String TABLE_CONTACTOS = "contactos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_CORREO = "correo";
    public static final String COLUMN_CELULAR = "celular";
    
    // SQL para crear la tabla
    private static final String CREATE_TABLE_CONTACTOS = 
        "CREATE TABLE " + TABLE_CONTACTOS + " (" +
        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        COLUMN_NOMBRE + " TEXT NOT NULL, " +
        COLUMN_APELLIDO + " TEXT NOT NULL, " +
        COLUMN_CORREO + " TEXT NOT NULL, " +
        COLUMN_CELULAR + " TEXT NOT NULL" +
        ")";
    
    public ContactoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACTOS);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(db);
    }
}
