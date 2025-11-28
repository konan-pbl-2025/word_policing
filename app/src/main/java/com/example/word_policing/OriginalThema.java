package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OriginalThema extends AppCompatActivity {
    public static String Thema1;
    public static String Thema2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_thema);
        Button nextButton = (Button) findViewById(R.id.Nextbutton);
        Button Thema1_add = (Button) findViewById(R.id.Thema1Add);
        Button Thema2_add = (Button) findViewById(R.id.Thema2Add);
        EditText add1 = (EditText) findViewById(R.id.Thema1Name);
        EditText add2 = (EditText) findViewById(R.id.Thema2Name);

        Thema1_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thema1 = add1.getText().toString().trim();
            }
        });

        Thema2_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thema2 = add2.getText().toString().trim();
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(OriginalThema.this, MemberInput.class);
                startActivity(member);
            }
        });
    }
}