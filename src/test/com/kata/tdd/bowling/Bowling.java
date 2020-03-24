package com.kata.tdd.bowling;

import java.util.LinkedList;

public class Bowling {
    private LinkedList<Frame> frames;
    private int[] rolls;
    private int nextRollIndex = 0;

    public Bowling() {
        this.frames = new LinkedList<>();
    }

    public void roll(int pinsDown) {
        if (frames.isEmpty() || frames.getLast().finished) {
            Frame frame = new Frame(pinsDown);
            frames.add(frame);
        } else {
            frames.getLast().roll(pinsDown);
        }
    }

    public int getScore() {
        int score = 0;
        Frame last1 = new Frame(0);
        Frame last2 = new Frame(0);
        for (Frame frame : frames) {
            if (last1.isSpare()) {
                score += frame.firstRoll;
            } else if (last1.isStrike()) {
                score += frame.getScore();
                if(last2.isStrike()){
                    score += frame.firstRoll;
                }
            }
            score += frame.getScore();
            last2 = last1;
            last1 = frame;

        }
        return score;
    }

    private static class Frame {

        private final int firstRoll;
        private int secondRoll;
        boolean finished;

        Frame(int pinsDown) {
            this.firstRoll = pinsDown;
            this.finished = pinsDown == 10;
        }

        int getScore() {
            return firstRoll + secondRoll;
        }

        boolean isStrike() {
            return firstRoll == 10;
        }

        boolean isSpare() {
            return getScore() == 10 && secondRoll > 0;
        }
        int numThrows(){
            return isStrike()? 1 : 2;
        }
        void roll(int pinsDown) {
            finished = true;
            secondRoll = pinsDown;
        }
    }
}
