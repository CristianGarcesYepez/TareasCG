package com.example.tareascg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class About3 extends AppCompatActivity {

    private Button bnt_back3;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about3);

        bnt_back3 = findViewById(R.id.btn_back3);
        bnt_back3.setOnClickListener(view -> {
            Intent intent = new Intent(About3.this, About2.class);
            startActivity(intent);
        });

    }

}
