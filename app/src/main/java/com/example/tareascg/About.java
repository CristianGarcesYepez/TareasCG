package com.example.tareascg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class About extends AppCompatActivity {

    private Button bnt_back;
    private Button bnt_follow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        bnt_back = findViewById(R.id.btn_back);
        bnt_follow = findViewById(R.id.btn_follow);
        bnt_back.setOnClickListener(view -> {
            Intent intent = new Intent(About.this, PortfolioActivity.class);
            startActivity(intent);
        });

        bnt_follow.setOnClickListener(view -> {
            Intent intent = new Intent(About.this, About1.class);
            startActivity(intent);
        });
    }

}
