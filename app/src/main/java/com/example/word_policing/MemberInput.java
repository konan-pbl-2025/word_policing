package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MemberInput extends AppCompatActivity {

    private int currentNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_input);

        Button leftbutton = (Button) findViewById(R.id.left);
        Button rightbutton = (Button) findViewById(R.id.right);
        Button addbutoon = (Button) findViewById(R.id.AddButton);
        Button nextbutton = (Button) findViewById(R.id.NextButton);
        TextView numtext = (TextView) findViewById(R.id.num);
        numtext.setText(String.valueOf(3));   // 初期値
        EditText nametext = (EditText) findViewById(R.id.NameText);
        String playerName = getString(R.string.player_name, 1);  // "プレイヤー1" を設定
        nametext.setText(playerName);  // nametextに設定
        ListView memberlist = (ListView) findViewById(R.id.MemberListText);

        // TextViewから文字列を取得
        String currentText = numtext.getText().toString();
        // 文字列から数字を取り出す（整数に変換）
        currentNumber = Integer.parseInt(currentText);

        ArrayList<String> playerNames = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);
        memberlist.setAdapter(adapter);;


        leftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を減算する
                if (currentNumber > 3 ) {
                    currentNumber -= 1;  // 現在人数-1
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(currentNumber));
            }
        });
        rightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算する
                if (currentNumber < 6 ) {
                    currentNumber += 1;  // 現在人数+1
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(currentNumber));
            }
        });

        addbutoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int playerCount = playerNames.size();
                if (playerCount < currentNumber){
                    // EditTextから文字列を取得
                    String playerName = nametext.getText().toString().trim();

                    // 文字列が空でない場合のみ追加
                    if (!playerName.isEmpty()) {
                        // ListViewのデータに追加
                        playerNames.add(playerName);
                        // Adapterに変更を通知してリストを更新
                        adapter.notifyDataSetChanged();

                        // EditTextを空にする
                        nametext.setText("");
                    }
                }
//                // 名前入力をプレイヤーなんとか(数字)にする
//                nametext.setText(getString(R.string.player_name, String.valueOf(currentNumber)));
            }
        });

    }
}