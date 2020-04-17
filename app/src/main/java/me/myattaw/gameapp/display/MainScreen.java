package me.myattaw.gameapp.display;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import me.myattaw.gameapp.Main;

public class MainScreen extends SurfaceView implements SurfaceHolder.Callback {

    private Main main;

    public MainScreen(Context context, Main main) {
        super(context);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        this.main = main;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return main.getCurrentScreen().onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {

        if (canvas == null) return;

        super.draw(canvas);

        main.getCurrentScreen().draw(canvas);

    }
}
