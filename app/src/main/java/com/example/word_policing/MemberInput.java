package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MemberInput extends AppCompatActivity {

    int currentNumber = 0;
    public static int wolfcount = 1;
    public static ArrayList<String> playerNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_input);

        playerNames.clear();

        Button leftbutton = (Button) findViewById(R.id.left);
        Button rightbutton = (Button) findViewById(R.id.right);
        Button pluswolfbutton = (Button) findViewById(R.id.pluswolf);
        Button lesswolfbutton = (Button) findViewById(R.id.lesswolf);
        Button addbutoon = (Button) findViewById(R.id.AddButton);
        Button nextbutton = (Button) findViewById(R.id.NextButton);
        TextView numtext = (TextView) findViewById(R.id.num);
        TextView wolfnumbertext = (TextView) findViewById(R.id.wolfnumber);
        numtext.setText(String.valueOf(3));   // 初期値
        wolfnumbertext.setText(String.valueOf(1));   // 初期値
        EditText nametext = (EditText) findViewById(R.id.NameText);
        nametext.setHint("プレイヤー１"); // プレイヤー１を表示
        ListView memberlist = (ListView) findViewById(R.id.MemberListText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);
        memberlist.setAdapter(adapter);;

        // TextViewから文字列を取得
        String currentText = numtext.getText().toString();
        // 文字列から数字を取り出す（整数に変換）
        currentNumber = Integer.parseInt(currentText);

        // 人数減少ボタン
        leftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を減算する
                if (currentNumber > 3 ) {
                    currentNumber -= 1;  // 現在人数-1
                }
                if (currentNumber < playerNames.size()) {
                    playerNames.remove(playerNames.size()-1);
                    adapter.notifyDataSetChanged();
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(currentNumber));
            }
        });

        lesswolfbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を減算する
                if (wolfcount > 1) {
                    wolfcount -= 1;  // 現在人数-1
                }
                // 結果をTextViewにセット
                wolfnumbertext.setText(String.valueOf(wolfcount));
            }
        });

        // 人数増加ボタン
        rightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算する
                if (currentNumber < 6 ) {
                    currentNumber += 1;  // 現在人数+1
                    // 名前入力ができるようにする
                    nametext.setEnabled(true);
                    nametext.setHint("プレイヤー" + currentNumber);
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(currentNumber));
            }
        });

        pluswolfbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算する
                int ttmmp = currentNumber / 2;
                if(ttmmp *2 == currentNumber) ttmmp--;
                if(wolfcount < ttmmp){
                    wolfcount ++;
                    // 結果をTextViewにセット
                    wolfnumbertext.setText(String.valueOf(wolfcount));
                }
            }
        });


        // メンバー確定ボタン

        addbutoon.setOnClickListener(v -> addPlayer(nametext, adapter));
        // エンターキーでもメンバー追加
        nametext.setOnEditorActionListener((v, actionId, event) -> {
            addPlayer(nametext, adapter);
            return true; // キー入力を消費
        });

        // 次の画面に遷移
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (playerNames.size() == currentNumber){
                    Intent member = new Intent(MemberInput.this, ThemeDisplay.class);
                    startActivity(member);
                }
            }
        });


    }
    private void addPlayer(EditText nametext, ArrayAdapter<String> adapter) {
        int playerCount = playerNames.size();
        if (playerCount < currentNumber) {
            String playerName = nametext.getText().toString().trim();
            if (!playerName.isEmpty()) {
                playerNames.add(playerName);
                adapter.notifyDataSetChanged();
                nametext.setText("");
            }
            if (playerCount >= currentNumber) {
                nametext.setEnabled(false);
                nametext.setHint("これ以上入力できません！");
            }
        } else {
            nametext.setHint("これ以上入力できません！");
        }
    }
}