package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactoAdapter adapter;
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    private ContactoManager contactoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        // Inicializar ContactoManager
        contactoManager = ContactoManager.getInstance(this);

        recyclerView = findViewById(R.id.recyclerContactos);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        // Cargar contactos desde la base de datos
        cargarContactosDesdeDB();

        adapter = new ContactoAdapter(listaContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnRegistrar.setOnClickListener(view -> {
            Intent intent = new Intent(ContactsActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btnRegresar.setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar contactos cuando se regrese de otra actividad
        cargarContactosDesdeDB();
        adapter.actualizarLista(listaContactos);
    }

    private void cargarContactosDesdeDB() {
        List<Contacto> contactosDB = contactoManager.getContactoDAO().obtenerTodosLosContactos();
        listaContactos.clear();
        listaContactos.addAll(contactosDB);
    }
}