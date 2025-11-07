package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GeneralButton = (Button) findViewById(R.id.general);
        Button OriginalButton = (Button) findViewById(R.id.original);
        Button RuleButton = (Button) findViewById(R.id.rule);

        GeneralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(MainActivity.this, ThemaSelect.class);
                startActivity(member);
            }
        });

        OriginalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(MainActivity.this, MemberInput.class);
                startActivity(member);
            }
        });

    }
}


