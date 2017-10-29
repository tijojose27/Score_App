package com.tijojose27.score;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //CREATING VARIABLES FOR THE TEXTVIEW
    private TextView TV_Score1;
    private TextView TV_Score2;
    private TextView TV_Fouls1;
    private TextView TV_Fouls2;

    //CREATING VARIABLE FOR BUTTON
    private Button But_addScore1;
    private Button But_addScore2;
    private Button But_Foul1;
    private Button But_Foul2;
    private Button But_reset;

    //GLOBAL VARIABLE FOR THE SCORES
    private int score1;
    private int score2;

    //GLOBAL VARIABLE FOR THE FOULS
    private int fouls1;
    private int fouls2;

    private static String convString(int score) {
        String sScore = null;
        if (score == 1) {
            sScore = "" + score + " point";

        } else {
            sScore = "" + score + " points";
        }
        return sScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZING VARIABLES TO 0
        score1=0;
        score2=0;
        fouls1 = 0;
        fouls2 = 0;

        //GETTING TEXTVIEWS AND BUTTONS
        TV_Score1 = (TextView) findViewById(R.id.Score1_Text_View);
        TV_Score2 = (TextView) findViewById(R.id.Score2_Text_View);
        TV_Fouls1 = (TextView) findViewById(R.id.Foul1_Text_View);
        TV_Fouls2 = (TextView) findViewById(R.id.Foul2_Text_View);

        But_addScore1 = (Button) findViewById(R.id.addOneScore1_Button);
        But_addScore2 = (Button) findViewById(R.id.addOneScore2_Button);
        But_Foul1 = (Button) findViewById(R.id.addFoul1Button);
        But_Foul2 = (Button) findViewById(R.id.addFoul2_Button);
        But_reset = (Button) findViewById(R.id.reset_Button);


        //SETTING THE SCORE IN THE TEXTVIEW
        TV_Score1.setText(convString(score1));
        TV_Score2.setText(convString(score2));


        //*************


        // REVIEW CODE FROM HERE


        //***************


        //SETTING CLICK LISTENERS TO BUTTONS
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
        But_Foul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1 = foulCommited(score1);
                TV_Score1.setText(convString(score1));
            }
        });
        But_Foul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2 = foulCommited(score2);
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

    //INCREMENTING FOULS COMMITED
    private void foulsCommited(int fouls){
        fouls++;
    }

    //INCREMENTING SCORE
    private int increment(int score){
        int tscore = ++score;
        return tscore;
    }

    //
    private int foulCommited(int fouls) {
        fouls++;
        return fouls;
    }

    private void resetUI(){
        score1=0;
        score2=0;
        fouls1 = 0;
        fouls2 = 0;
        TV_Score1.setText(convString(score1));
        TV_Score2.setText(convString(score2));
    }

}
