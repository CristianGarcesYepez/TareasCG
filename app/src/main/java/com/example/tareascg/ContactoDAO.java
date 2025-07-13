package com.example.tareascg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    
    private ContactoDatabaseHelper dbHelper;
    private SQLiteDatabase database;
    
    public ContactoDAO(Context context) {
        dbHelper = new ContactoDatabaseHelper(context);
    }
    
    public void open() {
        database = dbHelper.getWritableDatabase();
    }
    
    public void close() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
    
    // Insertar un nuevo contacto
    public long insertarContacto(Contacto contacto) {
        ContentValues values = new ContentValues();
        values.put(ContactoDatabaseHelper.COLUMN_NOMBRE, contacto.getNombre());
        values.put(ContactoDatabaseHelper.COLUMN_APELLIDO, contacto.getApellido());
        values.put(ContactoDatabaseHelper.COLUMN_CORREO, contacto.getCorreo());
        values.put(ContactoDatabaseHelper.COLUMN_CELULAR, contacto.getCelular());
        
        return database.insert(ContactoDatabaseHelper.TABLE_CONTACTOS, null, values);
    }
    
    // Obtener todos los contactos
    public List<Contacto> obtenerTodosLosContactos() {
        List<Contacto> contactos = new ArrayList<>();
        
        Cursor cursor = database.query(
            ContactoDatabaseHelper.TABLE_CONTACTOS,
            null, // todas las columnas
            null, // sin WHERE
            null, // sin argumentos WHERE
            null, // sin GROUP BY
            null, // sin HAVING
            ContactoDatabaseHelper.COLUMN_NOMBRE + " ASC" // ORDER BY nombre
        );
        
        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_NOMBRE));
                String apellido = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_APELLIDO));
                String correo = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_CORREO));
                String celular = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_CELULAR));
                
                Contacto contacto = new Contacto(id, nombre, apellido, correo, celular);
                contactos.add(contacto);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        return contactos;
    }
    
    // Obtener un contacto por ID
    public Contacto obtenerContactoPorId(long id) {
        Cursor cursor = database.query(
            ContactoDatabaseHelper.TABLE_CONTACTOS,
            null,
            ContactoDatabaseHelper.COLUMN_ID + " = ?",
            new String[]{String.valueOf(id)},
            null, null, null
        );
        
        Contacto contacto = null;
        if (cursor.moveToFirst()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_NOMBRE));
            String apellido = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_APELLIDO));
            String correo = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_CORREO));
            String celular = cursor.getString(cursor.getColumnIndexOrThrow(ContactoDatabaseHelper.COLUMN_CELULAR));
            
            contacto = new Contacto(id, nombre, apellido, correo, celular);
        }
        
        cursor.close();
        return contacto;
    }
    
    // Actualizar un contacto
    public int actualizarContacto(Contacto contacto) {
        ContentValues values = new ContentValues();
        values.put(ContactoDatabaseHelper.COLUMN_NOMBRE, contacto.getNombre());
        values.put(ContactoDatabaseHelper.COLUMN_APELLIDO, contacto.getApellido());
        values.put(ContactoDatabaseHelper.COLUMN_CORREO, contacto.getCorreo());
        values.put(ContactoDatabaseHelper.COLUMN_CELULAR, contacto.getCelular());
        
        return database.update(
            ContactoDatabaseHelper.TABLE_CONTACTOS,
            values,
            ContactoDatabaseHelper.COLUMN_ID + " = ?",
            new String[]{String.valueOf(contacto.getId())}
        );
    }
    
    // Eliminar un contacto
    public int eliminarContacto(long id) {
        return database.delete(
            ContactoDatabaseHelper.TABLE_CONTACTOS,
            ContactoDatabaseHelper.COLUMN_ID + " = ?",
            new String[]{String.valueOf(id)}
        );
    }
    
    // Eliminar todos los contactos
    public int eliminarTodosLosContactos() {
        return database.delete(ContactoDatabaseHelper.TABLE_CONTACTOS, null, null);
    }
}
