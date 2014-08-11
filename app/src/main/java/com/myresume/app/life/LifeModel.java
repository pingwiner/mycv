package com.myresume.app.life;

import java.util.Random;

public class LifeModel {
    private int[][] mCells;
    private int mWidth;
    private int mHeight;
    private static int NORMAL_DENSITY = 10;
    private static int INITIAL_DENSITY = 200;
    private static final int RAND_MAX = 1000;

    public LifeModel(int width, int height) {
        mCells = new int[height][width];
        mWidth = width;
        mHeight = height;
        randomSeed(INITIAL_DENSITY);
    }

    public void tick() {
        int[][] newCells = new int[mHeight][mWidth];
        Random random = new Random();
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                int neighboursCount = getNeighboursCount(j, i);
                newCells[i][j] = mCells[i][j];
                if (mCells[i][j] == 0) { //dead cell
                    switch(neighboursCount) {
                        case 1:
                        case 2:
                            if (random.nextInt(RAND_MAX) < NORMAL_DENSITY) {
                                newCells[i][j] = neighboursCount;
                            }
                            break;
                        case 3:
                            newCells[i][j] = neighboursCount;
                            break;

                    }
                    continue;
                }
                switch(neighboursCount) { //live cell
                    case 2:
                    case 3:
                        break;
                    default:
                        newCells[i][j] = 0;
                }
            }
        }
        mCells = newCells;
    }

    private int getNeighboursCount(int w, int h) {
        int result = 0;
        for (int i = h - 1; i <= h + 1; i++) {
            if (i < 0) continue;
            if (i >= mHeight) continue;
            for (int j = w - 1; j <= w + 1; j++) {
                if (j < 0) continue;
                if (j >= mWidth) continue;
                if ((i == h) && (j == w)) continue;
                if (mCells[i][j] > 0) result++;
            }
        }
        return result;
    }


    private void randomSeed(int density) {
        Random random = new Random();
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                if (random.nextInt(RAND_MAX) < density) {
                    mCells[i][j] = 1;
                }
            }
        }
    }

    public int getCellState(int x, int y) {
        return mCells[y][x];
    }

    public int getWidth() {
        return mWidth;
    }

    public int getmHeight() {
        return mHeight;
    }

}
