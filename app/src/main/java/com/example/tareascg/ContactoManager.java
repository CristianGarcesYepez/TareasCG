package com.example.tareascg;

import android.content.Context;

/**
 * Clase manager para gestionar las operaciones de base de datos de contactos
 * Implementa el patrón Singleton para asegurar una sola instancia de la base de datos
 */
public class ContactoManager {
    private static ContactoManager instance;
    private ContactoDAO contactoDAO;
    private Context context;

    private ContactoManager(Context context) {
        this.context = context.getApplicationContext();
        this.contactoDAO = new ContactoDAO(this.context);
        this.contactoDAO.open();
    }

    public static synchronized ContactoManager getInstance(Context context) {
        if (instance == null) {
            instance = new ContactoManager(context);
        }
        return instance;
    }

    public ContactoDAO getContactoDAO() {
        return contactoDAO;
    }

    /**
     * Método para cerrar la conexión de la base de datos
     * Debe llamarse cuando la aplicación se cierre completamente
     */
    public void closeDatabase() {
        if (contactoDAO != null) {
            contactoDAO.close();
        }
    }

    /**
     * Método para reabrir la conexión si se cerró accidentalmente
     */
    public void reopenDatabase() {
        if (contactoDAO != null) {
            contactoDAO.open();
        }
    }
}
