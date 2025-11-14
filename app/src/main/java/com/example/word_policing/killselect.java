package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;



public class killselect extends AppCompatActivity {
    int currentNumber = 0;
    int max;
    int min = 0;
    int indexNum = min;
    ArrayList<String> player = new ArrayList<>(MemberInput.playerNames);
    //int tmp = MemberInput.playerNames.get(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killselect);

        ThemaSelect.select(this.getAssets());
        String t1 = ThemaSelect.ThemaOne;

        Button leftbutton = (Button) findViewById(R.id.left);
        Button rightbutton = (Button) findViewById(R.id.right);
        //Button addbutoon = (Button) findViewById(R.id.AddButton);
        Button nextbutton = (Button) findViewById(R.id.NextButton);
        TextView numtext = (TextView) findViewById(R.id.num);
        TextView killPlayer = (TextView) findViewById(R.id.textView);
        numtext.setText(String.valueOf(3));   // 初期値
        //EditText nametext = (EditText) findViewById(R.id.NameText);
        //nametext.setHint("プレイヤー１"); // プレイヤー１を表示
        //ListView memberlist = (ListView) findViewById(R.id.MemberListText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, player);
        //memberlist.setAdapter(adapter);;

        // TextViewから文字列を取得
        String currentText = numtext.getText().toString();
        // 文字列から数字を取り出す（整数に変換）
        currentNumber = Integer.parseInt(currentText);
        max = currentNumber - 1;
        numtext.setText(String.valueOf(indexNum));
        killPlayer.setText(player.get(indexNum));
        // 人数減少ボタン
        leftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を減算する
                if (indexNum > min ) {
                    indexNum -= 1;  // 現在人数-1
                }
                if (currentNumber < player.size()) {
                    player.remove(player.size()-1);
                    adapter.notifyDataSetChanged();
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(indexNum));
                killPlayer.setText(player.get(indexNum));
            }
        });

        // 人数増加ボタン
        rightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 数字を加算する
                if (indexNum < max) {
                    indexNum += 1;  // 現在人数+1
                    // 名前入力ができるようにする
                    //nametext.setEnabled(true);
                    //nametext.setHint("プレイヤー" + currentNumber);
                }
                // 結果をTextViewにセット
                numtext.setText(String.valueOf(indexNum));
                killPlayer.setText(player.get(indexNum));
            }
        });

        // メンバー確定ボタン
//        addbutoon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int playerCount = player.size();
//                if (playerCount < currentNumber){
//                    // EditTextから文字列を取得
//                    String playerName = nametext.getText().toString().trim();
//
//                    // 文字列が空でない場合のみ追加
//                    if (!playerName.isEmpty()) {
//                        // ListViewのデータに追加
//                        player.add(playerName);
//                        // Adapterに変更を通知してリストを更新
//                        adapter.notifyDataSetChanged();
//
//                        // EditTextを空にする
//                        nametext.setText("");
//                    }
//                    // 設定人数になったら名前を設定できないようにする
//                    if (playerCount == currentNumber - 1) {
//                        nametext.setEnabled(false);
//                        nametext.setHint("これ以上入力できません！");
//                    }
//                } else {
//                    nametext.setHint("これ以上入力できません！");
//                }
//            }
//        });

        // 次の画面に遷移
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(killselect.this, MainActivity.class);
                member.putExtra("voteOutPlayer", indexNum); // プレイヤー番号を渡す
                startActivity(member);

            }
        });


    }
}