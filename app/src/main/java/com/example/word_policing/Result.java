package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import androidx.core.content.ContextCompat;

public class Result extends AppCompatActivity {

    ArrayList<String> playerNames = MemberInput.playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        boolean kill = killselect.saveordead;
        HashSet<Integer> wolfchecker = ThemeDisplay.wolfchecker;

        Button restart = (Button) findViewById(R.id.restartbutton);
        Button finish = (Button) findViewById(R.id.finishbutton);
        TextView resulttext = (TextView) findViewById(R.id.resulttext);
        TextView wintext = (TextView) findViewById(R.id.wintext);
        resulttext.setText("結果発表");

        ListView memberlist = (ListView) findViewById(R.id.resultmemberlist);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        for (int i = 0; i < playerNames.size(); i++) {
            HashMap<String, String> map = new HashMap<>();
            if(wolfchecker.contains(i + 1)) map.put("role", "ウルフ");     // ← 市民 or ウルフ（あなたが作ったリスト）
            else map.put("role", "市民");
            map.put("name", playerNames.get(i)); // ← 名前
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,                       //どこの画面（Activity）で表示するか
                list,                              //ListView に表示したいデータ
                R.layout.result_listview_layout,          //（XML）を指定
                new String[]{"role", "name"},
                new int[]{R.id.role, R.id.name}
        );
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (view.getId() == R.id.role) {
                    TextView roleText = (TextView) view;
                    String role = (String) data;
                    roleText.setText(role);

                    // 色分け
                    if (role.equals("市民")) {
                        roleText.setTextColor(ContextCompat.getColor(Result.this, R.color.blue));
                    } else if (role.equals("ウルフ")) {
                        roleText.setTextColor(ContextCompat.getColor(Result.this, R.color.red));
                    }
                    return true; // 自分で処理したので true
                }
                return false; // それ以外は SimpleAdapter に任せる
            }
        });

        memberlist.setAdapter(adapter);
        System.out.println(list);

        // 勝利チームの表示
        if (kill){
            wintext.setText("ウルフの勝ち！");
        } else {
            wintext.setText("市民の勝ち！");
        }


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemaSelect.reset();
                Intent member = new Intent(Result.this, ThemeDisplay.class);
                startActivity(member);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemaSelect.reset();
                Intent member = new Intent(Result.this, MainActivity.class);
                startActivity(member);
            }
        });
    }
}