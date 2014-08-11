package com.myresume.app.life;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LifeSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread mDrawThread;

    public LifeSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mDrawThread = new DrawThread(getHolder(), getWidth(), getHeight(), getResources());
        mDrawThread.setRunning(true);
        mDrawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;

        mDrawThread.setRunning(false);
        while (retry) {
            try {
                mDrawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                //Something went wrong ...
            }
        }
    }
}
