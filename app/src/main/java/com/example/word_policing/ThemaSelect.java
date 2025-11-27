package com.example.word_policing;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ThemaSelect {

    public static String ThemaOne;
    public static String ThemaTwo;
    public static String Question1;
    public static String Question2;
    public static String Question3;

    // 一度決めた行を保持しておく
    private static boolean initialized = false;

    public static void select(AssetManager assetManager) {

        // すでに決まっているなら、もうランダムに選び直さない
        if (initialized) {
            Log.d("ThemaSelect", "already initialized. use same thema & questions");
            return;
        }

        Random rnd = new Random();
        int targetLine = rnd.nextInt(80) + 1; // 1〜80

        Log.d("ThemaSelect", "targetLine = " + targetLine);

        try (InputStream is = assetManager.open("ThemaSelection.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {

                if (currentLine == targetLine) {
                    String[] col = line.split(",");

                    if (col.length < 5) {
                        Log.e("ThemaSelect", "列数が足りません: " + line);
                        return;
                    }

                    ThemaOne  = col[0];
                    ThemaTwo  = col[1];
                    Question1 = col[2];
                    Question2 = col[3];
                    Question3 = col[4];

                    Log.d("ThemaSelect", "ThemaOne=" + ThemaOne + ", ThemaTwo=" + ThemaTwo);
                    Log.d("ThemaSelect", "Q1=" + Question1 + ", Q2=" + Question2 + ", Q3=" + Question3);

                    initialized = true;
                    break;
                }

                currentLine++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1ゲーム終わった後にリセットしたいとき用
    public static void reset() {
        initialized = false;
    }
}
