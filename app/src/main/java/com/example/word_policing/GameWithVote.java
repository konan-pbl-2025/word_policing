package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameWithVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_vote);

        // CSV 読み込みを実行（確実にここで呼ぶ）
        ThemaSelect.select(getAssets());

        // UI 要素取得
        TextView topicText = findViewById(R.id.topic);
        Button button1 = findViewById(R.id.topic1);
        Button button2 = findViewById(R.id.topic2);
        Button button3 = findViewById(R.id.topic3);
        Button finish = findViewById(R.id.kill);

        // 読み込んだ質問をセット
        button1.setText("話題１");
        button2.setText("話題２");
        button3.setText("話題３");

        // ボタン1
        button1.setOnClickListener(v ->
                topicText.setText(ThemaSelect.Question1));

        // ボタン2
        button2.setOnClickListener(v ->
                topicText.setText(ThemaSelect.Question2));

        // ボタン3
        button3.setOnClickListener(v ->
                topicText.setText(ThemaSelect.Question3));

        // 次の画面へ
        finish.setOnClickListener(v -> {
            Intent member = new Intent(GameWithVote.this, killselect.class);
            startActivity(member);
        });
    }
}

