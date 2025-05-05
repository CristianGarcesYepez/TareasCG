package com.example.tareascg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class About1 extends AppCompatActivity {

    public Button bnt_back1;
    public Button bnt_follow1;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about1);

        bnt_back1 = findViewById(R.id.btn_back1);
        bnt_follow1 = findViewById(R.id.btn_follow1);
        bnt_back1.setOnClickListener(view -> {
            Intent intent = new Intent(About1.this, About.class);
            startActivity(intent);
        });

        bnt_follow1.setOnClickListener(view -> {
            Intent intent = new Intent(About1.this, About2.class);
            startActivity(intent);
        });
    }

}
