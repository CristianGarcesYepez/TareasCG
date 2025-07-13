package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {

    CardView curriculumCardView;
    CardView registerCardView;
    CardView mealsCardView;
    ExtendedFloatingActionButton fabExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curriculumCardView = findViewById(R.id.curriculumCardView);
        registerCardView = findViewById(R.id.registerCardView);
        mealsCardView = findViewById(R.id.curriculumCardView3);
        fabExit = findViewById(R.id.fab_exit);

        curriculumCardView.setOnClickListener(view -> {
            // Abre la primera pantalla - Curriculum
            Intent intent = new Intent(MainActivity.this, PortfolioActivity.class);
            startActivity(intent);
        });

        registerCardView.setOnClickListener(view -> {
            // Abre la segunda pantalla - Registro de Contactos
            Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
            startActivity(intent);
        });

        mealsCardView.setOnClickListener(view -> {
            // Abre la tercera pantalla - Recetas de Cocina
            Intent intent = new Intent(MainActivity.this, MealsActivity.class);
            startActivity(intent);
        });

        fabExit.setOnClickListener(view -> {
            // Cierra la aplicación completamente
            finishAffinity();
            System.exit(0);
        });
    }
}
