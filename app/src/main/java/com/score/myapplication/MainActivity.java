package com.score.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView scoreTxtView;
    private Button increaseButton,decreaseButton;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTxtView = findViewById(R.id.txtViewId);
        increaseButton = findViewById(R.id.increaseScoreId);
        decreaseButton = findViewById(R.id.decreaseScoreId);

        if (loadScore() !=0){
            scoreTxtView.setText("Score : "+loadScore());
        }

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.increaseScoreId){

            score = score + 10;
            scoreTxtView.setText("Score : "+score);
            saveScore(score);
        }else if (view.getId()==R.id.decreaseScoreId){

            score = score - 10;
            scoreTxtView.setText("Score : "+score);
            saveScore(score);

        }

    }
    private void saveScore(int score){

        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore",score);
        editor.commit();
    }
    private int loadScore(){

        SharedPreferences sharedPreferences = getSharedPreferences("gameScore",Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("lastScore",0);
        return score;
    }



}