package me.myattaw.gameapp.display.screen;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface CustomScreen {

    boolean onTouchEvent(MotionEvent event);

    void draw(Canvas canvas);

}
