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
        for(int pins : rolls){
            score += pins;
        }
        return score;
    }
}
