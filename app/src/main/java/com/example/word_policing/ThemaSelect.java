package com.example.word_policing;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ThemaSelect {

    public static String ThemaOne;
    public static String ThemaTwo;

    public static void select(AssetManager assetManager) {
        System.out.println("ThemeSelect");

        Random rnd = new Random();
        int targetLine = rnd.nextInt(80); // 0〜79のランダムな行番号

        try (InputStream is = assetManager.open("ThemaSelection.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line = null;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine == targetLine) {
                    String[] columns = line.split(",");
                    if (columns.length >= 2) {
                        ThemaOne = columns[1];
                        ThemaTwo = columns[2];
                        Log.d("CSVRead", "ThemaOne=" + ThemaOne + ", ThemaTwo=" + ThemaTwo);
                        System.out.println(ThemaOne);
                    } else {
                        Log.e("CSVRead", "列数が足りません: " + line);
                    }
                    break;
                }
                currentLine++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
