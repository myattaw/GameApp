package me.myattaw.gameapp.display.screen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import me.myattaw.gameapp.Main;
import me.myattaw.gameapp.display.Button;
import me.myattaw.gameapp.display.type.TextButton;

public class GameScreen implements CustomScreen {

    private List<Button> buttonList = new ArrayList<>();
    private Paint paint = new Paint();

    private final int BUTTON_HEIGHT = 200;

    public GameScreen(Main main) {
        paint.setColor(0xFFFFFFFF);
        buttonList.add(new TextButton("Game Screen", (main.getWidth() / 4), (main.getHeight() / 2), BUTTON_HEIGHT, (main.getWidth() / 2), 0xFF000000, 0xFFFFFFFF));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                for (Button button : buttonList) {
                    button.onClick(event.getX(), event.getY());
                    System.out.println("working");
                }
            }

        }

        return true;
    }

    @Override
    public void draw(Canvas canvas) {

        if (canvas == null) return;

        System.out.println("drawing");

        for (Button button : buttonList) {
            button.draw(canvas);
        }
    }

}
