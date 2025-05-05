package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactoAdapter adapter;
    private static ArrayList<Contacto> listaContactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        recyclerView = findViewById(R.id.recyclerContactos);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnRegresar = findViewById(R.id.btnRegresar);

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
        adapter.actualizarLista(listaContactos);
    }

    public static void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
    }
}