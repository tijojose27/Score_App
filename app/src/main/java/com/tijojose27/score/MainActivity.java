package com.tijojose27.score;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView TV_Score1;
    private TextView TV_Score2;

    private Button But_addScore1;
    private Button But_addScore2;
    private Button But_subScore1;
    private Button But_subScore2;
    private Button But_reset;

    private int score1;
    private int score2;

    private int fouls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1=0;
        score2=0;
        fouls=0;

        TV_Score1 = (TextView) findViewById(R.id.Score1_Text_View);
        TV_Score2 = (TextView) findViewById(R.id.Score2_Text_View);

        But_addScore1 = (Button) findViewById(R.id.addOneScore1_Button);
        But_addScore2 = (Button) findViewById(R.id.addOneScore2_Button);
        But_subScore1 = (Button) findViewById(R.id.subOneScore1_Button);
        But_subScore2 = (Button) findViewById(R.id.subOneScore2_Button);
        But_reset = (Button) findViewById(R.id.reset_Button);

        TV_Score1.setText(convString(score1));
        TV_Score2.setText(convString(score2));

        But_addScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1=increment(score1);
                TV_Score1.setText(convString(score1));
            }
        });
        But_addScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2 = increment(score2);
                TV_Score2.setText(convString(score2));
            }
        });
        But_subScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1 = decrese(score1);
                TV_Score1.setText(convString(score1));
            }
        });
        But_subScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2 = decrese(score2);
                TV_Score2.setText(convString(score2));
            }
        });

        But_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetUI();
            }
        });

    }

    private void foulsCommited(int fouls){
        fouls++;
    }

    private int increment(int score){
        int tscore = ++score;
        return tscore;
    }

    private int decrese(int score){
        if(score<=0){
            return score;
        }
        int tscore = --score;
        return tscore;
    }

    private static String convString(int score){
        String sScore=null;
        if(score == 1){
            sScore=""+score+" point";

        }else {
            sScore = "" + score + " points";
        }
        return sScore;
    }

    private void resetUI(){
        score1=0;
        score2=0;
        fouls=0;
        TV_Score1.setText(convString(score1));
        TV_Score2.setText(convString(score2));
    }

}
