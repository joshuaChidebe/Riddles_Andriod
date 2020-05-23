package com.example.myapplication;

public class TrueFalseModel {
    private int Question;
    private int Answer;

    TrueFalseModel(int question,int answer){
        Question = question;
        Answer = answer;
    }

    public int getQuestion() {
        return Question;
    }

    public void setQuestion(int question) {
        Question = question;
    }

    public int isAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }
}


