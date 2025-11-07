package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWithVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_vote);

        // TextView と Button を ID で取得
        TextView topicText = findViewById(R.id.topic);
        Button button1 = findViewById(R.id.topic1);
        Button button2 = findViewById(R.id.topic2);
        Button button3 = findViewById(R.id.topic3);

        // ボタン1のクリック処理
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicText.setText("ぶっちゃけやばい？");
            }
        });

        // ボタン2のクリック処理
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicText.setText("ひとでいうたらどいつ？");
            }
        });

        // ボタン3のクリック処理
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicText.setText("すごいよね。");
            }
        });
    }
}
