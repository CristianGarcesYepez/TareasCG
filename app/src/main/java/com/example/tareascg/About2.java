package com.example.tareascg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class About2 extends AppCompatActivity {

    private Button bnt_back2;
    private Button bnt_follow2;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about2);

        bnt_back2 = findViewById(R.id.btn_back2);
        bnt_follow2 = findViewById(R.id.btn_follow2);
        bnt_back2.setOnClickListener(view -> {
            Intent intent = new Intent(About2.this, About1.class);
            startActivity(intent);
        });

        bnt_follow2.setOnClickListener(view -> {
            Intent intent = new Intent(About2.this, About3.class);
            startActivity(intent);
        });
    }

}
