package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThemeDisplay extends AppCompatActivity {

    int playerIndex = 0;
    int playerNum = 5; //プレイヤーの人数
    int wolfnum = 1; //狼の人数
    String maintheme = "無問題";
    String wolftheme = "がお";
    String theme;


    boolean isConfirmPhase = true; // true: 確認画面, false: お題画面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_display);

        TextView themetext = findViewById(R.id.text);
        Button personcheck = findViewById(R.id.person);
        int n = playerNum; // 数字の範囲（1〜n）
        int k = wolfnum;  // 選ぶ個数
        // 1〜nの数字をリストに追加
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // シャッフルして先頭からk個を選ぶ
        Collections.shuffle(numbers);
        HashSet<Integer> wolfchecker = new HashSet<>();
        for (int i = 0; i < k; i++) {
            wolfchecker.add(numbers.get(i));
        }

        // 初期表示
        themetext.setText(MemberInput.playerNames.get(0) +"ですか");
        personcheck.setText("確定");

        personcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personcheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String buttonText = personcheck.getText().toString();

                        if (buttonText.equals("会議を始める")) {
                            // 会議画面へ遷移
                            Intent intent = new Intent(ThemeDisplay.this, GameWithVote.class);
                            startActivity(intent);
                            return;
                        }

                        if (playerIndex >= playerNum) {
                            themetext.setText("全員にお題が渡りました");
                            personcheck.setText("会議を始める");
                            return;
                        }

                        if (isConfirmPhase) {
                            // お題表示フェーズへ
                            if (wolfchecker.contains(playerIndex + 1)) theme = wolftheme;
                            else theme = maintheme;
                            themetext.setText("お題 : " + theme);
                            personcheck.setText("次の人に回す");
                            isConfirmPhase = false;
                        } else {
                            // 次の人の確認フェーズへ
                            playerIndex++;
                            if (playerIndex < playerNum) {
                                themetext.setText(MemberInput.playerNames.get(playerIndex) + "ですか");
                                personcheck.setText("確定");
                                isConfirmPhase = true;
                            } else {
                                themetext.setText("全員にお題が渡りました");
                                personcheck.setText("会議を始める");
                            }
                        }
                    }
                });

            }
        });
    }
}
