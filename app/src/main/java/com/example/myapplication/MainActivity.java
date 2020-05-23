package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.ScanSettings;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button buttonn;
    Button buttonnn;
    TextView text;
    TextView text2;
    TextView text3;
    int index = 0;
    int trace = 1;
    int Tscore = 0;
    int sad = 1;




    TrueFalseModel[] me = {new TrueFalseModel(R.string.question1,2 ),
            new TrueFalseModel(R.string.question2, 1),
            new TrueFalseModel(R.string.question3, 3),
            new TrueFalseModel(R.string.question4, 1),
            new TrueFalseModel(R.string.question5, 2),
            new TrueFalseModel(R.string.question6, 1),
            new TrueFalseModel(R.string.question7, 1),
            new TrueFalseModel(R.string.question8, 1),
            new TrueFalseModel(R.string.question9, 2),
            new TrueFalseModel(R.string.question10, 1),
            new TrueFalseModel(R.string.question11, 1)
            };

    int hello[] = {R.string.CAnswer1,
            R.string.CAnswer2,
            R.string.CAnswer3,
            R.string.CAnswer4,
            R.string.CAnswer5,
            R.string.CAnswer6,
            R.string.CAnswer7,
            R.string.CAnswer8,
            R.string.CAnswer9,
            R.string.CAnswer10};

    int hi[] = {R.string.WAnswer1,
            R.string.WAnswer2,
            R.string.WAnswer3,
            R.string.WAnswer4,
            R.string.WAnswer5,
            R.string.WAnswer6,
            R.string.WAnswer7,
            R.string.WAnswer8,
            R.string.WAnswer9,
            R.string.WAnswer10,};


    int how[] = {R.string.WWAnswer1,
            R.string.WWAnswer2,
            R.string.WWAnswer3,
            R.string.WWAnswer4,
            R.string.WWAnswer5,
            R.string.WWAnswer6,
            R.string.WWAnswer7,
            R.string.WWAnswer8,
            R.string.WWAnswer9,
            R.string.WWAnswer10,};
    public void updateAnswer2() {
        sad = sad + 1;
        buttonnn.setText(hi[index]);
        button.setText(hello[index]);
        buttonn.setText(how[index]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        buttonn = findViewById(R.id.button2);
        buttonnn = findViewById(R.id.button3);
        text = findViewById(R.id.question);
        text2 = findViewById(R.id.questionnum);
        text3 = findViewById(R.id.score);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer(1);
                updateQuestion();
                updateAnswer2();
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer(2);
                updateQuestion();
                updateAnswer2();
            }
        });
        buttonnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer(3);
                updateQuestion();
                updateAnswer2();
            }
        });

    }


    public void updateQuestion() {
        if(index == 9){
            AlertDialog.Builder send = new  AlertDialog.Builder(this);
            send.setTitle("Game Over");
            send.setCancelable(false);
            send.setMessage("You scored " + Tscore + "/10");
            send.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            send.show();
        }
        else {
            trace = trace + 1;
            index = index + 1;
            TrueFalseModel hi = me[index];
            int hello = hi.getQuestion();
            text.setText(hello);
            Integer.toString(trace);
            text2.setText("Question " + trace + "/10");}



    }

    public void correctAnswer(int useranswer) {
        int us = me[index].isAnswer();
        if(us==useranswer) {
            Toast .makeText(MainActivity.this,"correct",Toast.LENGTH_SHORT).show();
            Integer.toString(Tscore);
            Tscore = Tscore + 1;
            text3.setText("Score " + Tscore + "/10");

        }
        else{
            Toast.makeText(MainActivity.this,"wrong",Toast.LENGTH_SHORT).show();
        }
    }



}