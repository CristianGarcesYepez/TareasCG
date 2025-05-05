package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView curriculumCardView;
    CardView registerCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curriculumCardView = findViewById(R.id.curriculumCardView);
        registerCardView = findViewById(R.id.registerCardView);

        curriculumCardView.setOnClickListener(view -> {
            // Abre la primera pantalla
            Intent intent = new Intent(MainActivity.this, PortfolioActivity.class);
            startActivity(intent);
        });

        registerCardView.setOnClickListener(view -> {
            // Abre la segunda pantalla
            Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
            startActivity(intent);
        });
    }
}
