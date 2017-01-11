package com.example.android.courtcounter;

import android.content.res.Configuration;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.courtcounter.R.id.foulsOfTeamA;
import static com.example.android.courtcounter.R.id.foulsOfTeamB;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0
        ,foulsOfTeamA = 0
        ,numberOfThreePointBasketForTeamA = 0
        ,numberOfTwoPointBasketForTeamA = 0
        ,numberOfOnePointBasketForTeamA = 0
        ,numberOfFoulsTeamA = 0;
    int scoreTeamB = 0
        ,foulsOfTeamB = 0
        ,numberOfThreePointBasketForTeamB = 0
        ,numberOfTwoPointBasketForTeamB = 0
        ,numberOfOnePointBasketForTeamB = 0
        ,numberOfFoulsTeamB = 0;

    private static final char TEAM_A = 'A';
    private static final char TEAM_B = 'B';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScoreForTeamA(int totalScore, int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(totalScore));
        incrementNumberOfBaskets(score, TEAM_A);
        displayNumberOfBasketPerTeam();
    }

    public void displayNumberOfBasketPerTeam() {
        TextView numberOfBaskets = (TextView) findViewById(R.id.threePointBasketOfTeamA);
        numberOfBaskets.setText(String.valueOf(numberOfThreePointBasketForTeamA));

        numberOfBaskets = (TextView) findViewById(R.id.twoPointBasketOfTeamA);
        numberOfBaskets.setText(String.valueOf(numberOfTwoPointBasketForTeamA));

        numberOfBaskets = (TextView) findViewById(R.id.onePointBasketOfTeamA);
        numberOfBaskets.setText(String.valueOf(numberOfOnePointBasketForTeamA));

        numberOfBaskets = (TextView) findViewById(R.id.threePointBasketOfTeamB);
        numberOfBaskets.setText(String.valueOf(numberOfThreePointBasketForTeamB));

        numberOfBaskets = (TextView) findViewById(R.id.twoPointBasketOfTeamB);
        numberOfBaskets.setText(String.valueOf(numberOfTwoPointBasketForTeamB));

        numberOfBaskets = (TextView) findViewById(R.id.onePointBasketOfTeamB);
        numberOfBaskets.setText(String.valueOf(numberOfOnePointBasketForTeamB));
    }

    public void addThreeForTeamA(View view){
        scoreTeamA += 3;
        displayScoreForTeamA(scoreTeamA, 3);
    }

    public void addTwoForTeamA(View view){
        scoreTeamA += 2;
        displayScoreForTeamA(scoreTeamA, 2);
    }

    public void addOneForTeamA(View view){
        scoreTeamA += 1;
        displayScoreForTeamA(scoreTeamA, 1);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int totalScore, int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(totalScore));
        incrementNumberOfBaskets(score, TEAM_B);
        displayNumberOfBasketPerTeam();
    }

    public void addOneForTeamB(View view){
        scoreTeamB += 1;
        displayScoreForTeamB(scoreTeamB, 1);
    }

    public void addTwoForTeamB(View view){
        scoreTeamB += 2;
        displayScoreForTeamB(scoreTeamB, 2);
    }

    public void addThreeForTeamB(View view){
        scoreTeamB +=3;
        displayScoreForTeamB(scoreTeamB, 3);
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        foulsOfTeamA = 0;
        numberOfThreePointBasketForTeamA = 0;
        numberOfTwoPointBasketForTeamA = 0;
        numberOfOnePointBasketForTeamA = 0;
        numberOfFoulsTeamA = 0;
        scoreTeamB = 0;
        foulsOfTeamB = 0;
        numberOfThreePointBasketForTeamB = 0;
        numberOfTwoPointBasketForTeamB = 0;
        numberOfOnePointBasketForTeamB = 0;
        numberOfFoulsTeamB = 0;
        displayScoreForTeamA(scoreTeamA, 0);
        displayScoreForTeamB(scoreTeamB, 0);
        displayFouls();
    }

    public void incrementNumberOfBaskets(int number, char team){
        switch (number) {
            case 1:
                if (team == 'A'){
                    numberOfOnePointBasketForTeamA += 1;
                }
                else {
                    numberOfOnePointBasketForTeamB += 1;
                }
                break;
            case 2:
                if (team == 'A'){
                    numberOfTwoPointBasketForTeamA += 1;
                }
                else {
                    numberOfTwoPointBasketForTeamB += 1;
                }
                break;
            case 3:
                if (team == 'A'){
                    numberOfThreePointBasketForTeamA += 1;
                }
                else {
                    numberOfThreePointBasketForTeamB += 1;
                }
                break;
        }
    }

    public void addFoulToTeamA(View view){
        foulsOfTeamA += 1;
        displayFouls();
    }

    public void addFoulToTeamB(View view){
        foulsOfTeamB += 1;
        displayFouls();
    }

    public void displayFouls(){
        TextView foul = (TextView) findViewById(R.id.foulsOfTeamA);
        foul.setText(String.valueOf(foulsOfTeamA));

        foul = (TextView) findViewById(R.id.foulsOfTeamB);
        foul.setText(String.valueOf(foulsOfTeamB));
    }
}
