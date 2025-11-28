package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        boolean kill = killselect.saveordead;

        TextView resulttext = (TextView) findViewById(R.id.resulttext);
        TextView wintext = (TextView) findViewById(R.id.wintext);
        resulttext.setText("結果発表");

        // 勝利チームの表示
        if (kill){
            wintext.setText("ウルフの勝ち！");
        } else {
            wintext.setText("市民の勝ち！");
        }
    }
}