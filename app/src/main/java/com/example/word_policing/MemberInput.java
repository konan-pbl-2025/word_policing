package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_input);

        Button leftbutton = (Button) findViewById(R.id.left);
        leftbutton.setText(R.string.direction_left);
        Button rightbutton = (Button) findViewById(R.id.right);
        leftbutton.setText(R.string.direction_right);
        TextView numtext = (TextView) findViewById(R.id.num);
        numtext.setText(String.valueOf(2));   // 初期値

        // TextViewから文字列を取得
        String currentText = numtext.getText().toString();
        // 文字列から数字を取り出す（整数に変換）
        int currentNumber = Integer.parseInt(currentText);
        leftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算または減算する
                int newNumber = currentNumber + 1;  // +1

                // 結果をTextViewにセット
                numtext.setText(String.valueOf(newNumber));
            }
        });
        rightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算または減算する
                int newNumber = currentNumber - 1;  // -1

                // 結果をTextViewにセット
                numtext.setText(String.valueOf(newNumber));
            }
        });

    }
}