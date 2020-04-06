package me.myattaw.gameapp.menu.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import me.myattaw.gameapp.menu.Button;
import me.myattaw.gameapp.menu.type.TextButton;

public class MainMenu extends SurfaceView implements SurfaceHolder.Callback {

    private List<Button> buttonList = new ArrayList<>();
    private Paint paint = new Paint();

    public MainMenu(Context context) {
        super(context);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        buttonList.add(new TextButton("Test", 0, 0, 100, 100));
        paint.setColor(0xFFFFFFFF);
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
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas == null) return;

        for (Button button : buttonList) {
            canvas.drawRect(button.getRect(), paint);
        }

    }
}
