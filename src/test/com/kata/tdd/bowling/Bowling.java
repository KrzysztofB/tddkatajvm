package com.kata.tdd.bowling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private int firstBallAfterFrame(int frameIndex, List<Frame> frames) {
        Frame frame = frames.get(frameIndex + 1);
        return frame.firstRoll;
    }

    private int secondBallAfterFrame(int frameIndex, List<Frame> frames) {
        Frame frame = frames.get(frameIndex + 1);
        if (frame.isStrike()) {
            frame = frames.get(frameIndex + 2);
            return frame.firstRoll;
        }
        return frame.secondRoll;
    }

    public int getScore() {
        List<Frame> tempFrames = new ArrayList<>(frames);
        Frame empty = new Frame(0);
        while (tempFrames.size() < 12) tempFrames.add(empty);

        int score = 0;
        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            Frame frame = tempFrames.get(frameIndex);
            score += frame.getScore();
            if (frame.isSpare()) {
                score += firstBallAfterFrame(frameIndex, tempFrames);
            } else if (frame.isStrike()) {
                score += firstBallAfterFrame(frameIndex, tempFrames);
                score += secondBallAfterFrame(frameIndex, tempFrames);
            }
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

        int numThrows() {
            return isStrike() ? 1 : 2;
        }

        void roll(int pinsDown) {
            finished = true;
            secondRoll = pinsDown;
        }
    }
}
