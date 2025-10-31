package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThemeDisplay extends AppCompatActivity {

    int playerIndex = 0;
    int playerNum = 5;
    String theme = "お題の内容";

    boolean isConfirmPhase = true; // true: 確認画面, false: お題画面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_display);

        TextView themetext = findViewById(R.id.text);
        Button personcheck = findViewById(R.id.person);

        // 初期表示
        themetext.setText("aさんですか");
        personcheck.setText("確定");

        personcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerIndex >= playerNum) {
                    themetext.setText("全員にお題が渡りました");
                    personcheck.setEnabled(false);
                    return;
                }

                if (isConfirmPhase) {
                    // お題表示フェーズへ
                    themetext.setText("お題 : " + theme);
                    personcheck.setText("次の人に回す");
                    isConfirmPhase = false;
                } else {
                    // 次の人の確認フェーズへ
                    playerIndex++;
                    if (playerIndex < playerNum) {
                        themetext.setText("次の人に変わりましたか");
                        personcheck.setText("確定");
                        isConfirmPhase = true;
                    } else {
                        themetext.setText("全員にお題が渡りました");
                        personcheck.setEnabled(false);
                    }
                }
            }
        });
    }
}
