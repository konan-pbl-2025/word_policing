package com.example.word_policing;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ThemaSelect extends AppCompatActivity {

    public static String ThemaOne;
    public static String ThemaTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rnd = new Random();
        int num = rnd.nextInt(80)+1;

        super.onCreate(savedInstanceState);
        System.out.println("ThemeSelect");

        try (InputStream is = getAssets().open("ThemaSelection.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            // 1行目を読み飛ばす場合は reader.readLine();
            String line = reader.readLine(); // 1行目を読み込む
            if (line != null) {

                String[] columns = line.split(","); // カンマ区切りで分割
                ThemaOne = columns[1]; // 2列目
                ThemaTwo = columns[2]; // 3列目

                Log.d("CSVRead", "ThemaOne=" + ThemaOne + ", ThemaTwo=" + ThemaTwo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
