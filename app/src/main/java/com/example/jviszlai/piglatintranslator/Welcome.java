package com.example.jviszlai.piglatintranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    private EditText english;
    private EditText pigLatin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        english = (EditText) findViewById(R.id.english);
        Button translate = (Button) findViewById(R.id.translate);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processTextandTranslate();
            }
        });
        pigLatin = (EditText) findViewById(R.id.pigLatin);
    }

    public String translateToPigLatin(String english){
        String firstLetter = english.substring(0, 1);
        String lastFirst = english.substring(1 , 2);
        String last = english.substring(2);
        return lastFirst.toUpperCase() + last + firstLetter.toLowerCase() + "ay";
    }

    public String translateToEnglish(String pigLatin) {
        int length = pigLatin.length();
        String firstChar = pigLatin.substring(length - 3, length - 2);
        String wordBody = pigLatin.substring(1, length - 3);
        String firstCharBody = pigLatin.substring(0, 1);
        if(!pigLatin.substring(length - 2).equals("ay")){
            return pigLatin;
        }
        else{
            return firstChar.toUpperCase() + firstCharBody.toLowerCase() + wordBody;
        }
    }

    public void processTextandTranslate() {
        String englishStr = english.getText().toString();
        String pigLatinStr = pigLatin.getText().toString();
        if(pigLatinStr.equals("") && englishStr.equals("")) {
            return;
        }
        else if(pigLatinStr.equals("")){
            pigLatin.setText(translateToPigLatin(englishStr));
            english.setText("");
        }
        else if(englishStr.equals("")){
            english.setText(translateToEnglish(pigLatinStr));
            pigLatin.setText("");
        } else {
            english.setText(translateToEnglish(pigLatinStr));
            pigLatin.setText(translateToPigLatin(englishStr));
        }
    }
}
