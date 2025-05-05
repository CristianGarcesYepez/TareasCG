package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class PortfolioActivity  extends AppCompatActivity {

    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(view -> {
            Intent intent = new Intent(PortfolioActivity.this, About.class);
            startActivity(intent);
        });
    }



}
