package com.example.word_policing;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class killselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killselect);

        // プレイヤー名を取得（例：MemberInput.playerNames に保存されていると仮定）
        ArrayList<String> player = new ArrayList<>(MemberInput.playerNames);
        int playn = player.size(); // 3〜7人の想定

        // チェックボックスを追加するレイアウト
        LinearLayout container = findViewById(R.id.checkboxContainer);

        // 人数分のチェックボックスを動的に追加
        for (int i = 0; i < playn; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(player.get(i)); // 名前を表示
            checkBox.setId(View.generateViewId()); // 任意のID
            container.addView(checkBox);
        }
    }
}
