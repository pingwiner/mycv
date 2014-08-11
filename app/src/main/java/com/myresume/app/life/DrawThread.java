package com.myresume.app.life;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.myresume.app.R;

public class DrawThread extends Thread {
    private SurfaceHolder mSurfaceHolder;
    private boolean mRunning;
    private long mPrevTime;
    private LifeModel mLifeModel;
    private static final int CELL_SIZE = 10;
    private static final int SLEEP_INTERVAL = 100;
    Bitmap mBackground;

    public DrawThread(SurfaceHolder surfaceHolder, int width, int height, Resources resources){
        mSurfaceHolder = surfaceHolder;
        mLifeModel = new LifeModel(width / CELL_SIZE + 1, height / CELL_SIZE + 1);
        mPrevTime = System.currentTimeMillis();
        mBackground = BitmapFactory.decodeResource(resources, R.drawable.hobbies);
    }

    public void setRunning(boolean run) {
        mRunning = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (mRunning) {
            try {
                sleep(SLEEP_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mLifeModel.tick();
            canvas = null;
            try {
                canvas = mSurfaceHolder.lockCanvas(null);
                if (canvas != null) {
                    synchronized (mSurfaceHolder) {
                        drawLife(canvas);
                    }
                }
            }
            finally {
                if (canvas != null) {
                    mSurfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    private void drawLife(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();

        canvas.drawBitmap(mBackground, 0, 0, paint);

        paint.setStrokeWidth(1);
        for (int i = 0; i < mLifeModel.getmHeight(); i++) {
            for (int j = 0; j < mLifeModel.getWidth(); j++) {
                int state = mLifeModel.getCellState(j, i);
                if (state > 0) {
                    paint.setColor(Color.argb(0x40, 0, 0xff, 0x40));
                    canvas.drawRect(
                            j * CELL_SIZE,
                            i * CELL_SIZE,
                            j * CELL_SIZE + CELL_SIZE,
                            i * CELL_SIZE + CELL_SIZE,
                            paint);
                }
            }
        }
    }

}
