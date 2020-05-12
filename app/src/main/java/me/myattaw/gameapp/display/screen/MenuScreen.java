package me.myattaw.gameapp.display.screen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import me.myattaw.gameapp.Main;
import me.myattaw.gameapp.R;
import me.myattaw.gameapp.display.Button;
import me.myattaw.gameapp.display.type.BitmapButton;

public class MenuScreen implements CustomScreen {

    private List<Button> buttonList = new ArrayList<>();
    private Paint paint = new Paint();

    private final int PADDING = 50, BUTTON_HEIGHT = 200;

    public MenuScreen(Main main) {
        paint.setColor(0xFFFFFFFF);
        // draws a button 1/2 of the screens width
        buttonList.add(new BitmapButton(main, R.drawable.play_button, (main.getWidth() / 4), (main.getHeight() / 2), BUTTON_HEIGHT, (main.getWidth() / 2), 0xFF000000) {
            @Override
            public void buttonListener() {
                getMain().setCurrentScreen(new GameScreen(getMain()));
                System.out.println("switch screen");
            }
        });
        buttonList.add(new BitmapButton(main, R.drawable.options_button, (main.getWidth() / 4), (main.getHeight() / 2) + PADDING + BUTTON_HEIGHT, BUTTON_HEIGHT, (main.getWidth() / 2), 0xFF000000) {
            @Override
            public void buttonListener() {
                getMain().setCurrentScreen(new OptionScreen(getMain()));
                System.out.println("switch screen");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                for (Button button : buttonList) {
                    button.onClick(event.getX(), event.getY());
                }
            }
        }
        return true;
    }

    @Override
    public void draw(Canvas canvas) {

        if (canvas == null) return;

        for (Button button : buttonList) {
            button.draw(canvas);
        }
    }
}
