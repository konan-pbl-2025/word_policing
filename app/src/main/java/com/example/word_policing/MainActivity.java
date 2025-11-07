package com.example.word_policing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GeneralButton = (Button) findViewById(R.id.general);
        Button OriginalButton = (Button) findViewById(R.id.original);
        Button RuleButton = (Button) findViewById(R.id.rule);

        GeneralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(MainActivity.this, MemberInput.class);
                startActivity(member);
            }
        });

        OriginalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ✅ 1. カスタムレイアウトを読み込む
                LayoutInflater inflater = getLayoutInflater();
                View popupView = inflater.inflate(R.layout.popup_rules, null);

                // ✅ 2. ダイアログにレイアウトを設定
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(popupView)
                        .create();

                // ✅ 3. ルールテキストを設定
                TextView ruleText = popupView.findViewById(R.id.ruleText);
                ruleText.setText("【ゲームのルール】\n\nワードウルフを初めて遊ぶ人がいる場合、誰か1人が下のルールを読み上げて下さい\n2.「お題」「話し合い」「投票」\n この順にゲームは進みます\n\n①「お題」\n・これからプレーヤー1人ずつに「お題」が発表されます確認してください\n・「お題」は2種類あり、多数派（市民）と少数派（ウルフ）に分かれています\n・自分が多数派か少数派かは分かりません\n\n②「話し合い」\n・プレーヤーは話し合いの中で「誰が少数派（ウルフ）か」を考えて話し合います\n・各プレーヤーは多数派（市民）のキーワードを予測し、多数派のように振舞って下さい\n・「お題」を発言することや、類似するワードを言わせる、直接分かるような質問は禁止\n・話し合いが終了すると投票時間となります\n\n③「投票」\n・それぞれのプレーヤーは「せーの」で少数派だと思う人を指差してください\n・一番指を指された数（投票数）が多いかによって敗が決定\n1.少数派（ウルフ）が一番指をさされた（投票数が多かった）場合、ウルフの嘘を見抜いた市民側（多数派）の勝ち\n2.多数派のプレーヤーが一番投票されてしまった場合、うまく騙せたウルフ （少数派）の勝ち\n・2人以上が同票数の場合、サドンテス （延長戦）を開始\n・サドンテスは1分間の話し合い後再度投票を行います\n・サドンテスをしてもサドンテスは敗が決まるまで継続");

                // ✅ 4. 閉じるボタンの動作を設定
                Button closeButton = popupView.findViewById(R.id.popupCloseButton);
                closeButton.setOnClickListener(v1 -> dialog.dismiss());


                dialog.show();
                Intent member = new Intent(MainActivity.this, MemberInput.class);
                startActivity(member);
            }
        });
    }
}
