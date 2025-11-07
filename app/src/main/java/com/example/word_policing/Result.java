package com.example.word_policing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView resultlist = (ListView) findViewById(R.id.resultmemberlist);
        // 2つのテキストをセットするためのデータリスト
        List<String> itemList = new ArrayList<>();
        itemList.add("Item 1");  // 1行目のテキスト (Item1)
        itemList.add("Subitem 1");  // 2行目のテキスト (subItem1)
        itemList.add("Item 2");  // 1行目のテキスト (Item2)
        itemList.add("Subitem 2");  // 2行目のテキスト (subItem2)
        itemList.add("Item 3");  // 1行目のテキスト (Item3)
        itemList.add("Subitem 3");  // 2行目のテキスト (subItem3)

        // ArrayAdapterを作成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, itemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Viewを再利用
                View view = super.getView(position, convertView, parent);

                // 1行目のTextView (text1) を取得
                TextView text1 = view.findViewById(android.R.id.text1);
                // 2行目のTextView (text2) を取得
                TextView text2 = view.findViewById(android.R.id.text2);

                // 1行目に表示するテキストを設定
                String itemText = getItem(position);  // アイテムのデータ（例えば、Item1）
                text1.setText(itemText);  // 1行目にアイテムのテキストを設定

                // 2行目に表示するテキストを設定（場合によっては、追加でサブアイテムを設定）
                String subItemText = "Subitem " + (position + 1);  // サブアイテムのテキスト
                text2.setText(subItemText);  // 2行目にサブアイテムのテキストを設定

                return view;
            }
        };

        // ListViewにアダプタをセット
        resultlist.setAdapter(adapter);
    }
}