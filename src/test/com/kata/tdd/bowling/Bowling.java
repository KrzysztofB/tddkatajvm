package com.kata.tdd.bowling;

import java.util.Arrays;

public class Bowling {
    private int[] rolls;
    private int nextRollIndex = 0;

    public Bowling() {
        this.rolls = new int[22];
    }

    public void roll(int pinsDown){
        rolls[nextRollIndex] = pinsDown;
        nextRollIndex++;
    }

    public int getScore(){
        int score = 0;
        int pinsInFrame=0;
        int rollInFrame = 0;
        int prevFrameScore = 0;
        for(int pins : rolls){
            score += pins;
            if(rollInFrame==0){
                if(prevFrameScore==10){
                    score += 10;
                }
                prevFrameScore = 0;
            }
            rollInFrame++;
            rollInFrame%=2;
            prevFrameScore += pins;
        }
        return score;
    }
}
