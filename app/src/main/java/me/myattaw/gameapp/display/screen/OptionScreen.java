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
import me.myattaw.gameapp.display.type.options.SliderButton;
import me.myattaw.gameapp.display.type.options.ToggleButton;
import me.myattaw.gameapp.options.BooleanOption;
import me.myattaw.gameapp.options.NumberOption;

public class OptionScreen implements CustomScreen {

    private List<Button> buttonList = new ArrayList<>();
    private Paint paint = new Paint();

    private final int BUTTON_HEIGHT = 200;

    private final int PADDING = 25;

    public OptionScreen(Main main) {
        paint.setColor(0xFFFFFFFF);

        int yOffset = PADDING;

        for (BooleanOption booleanOption : BooleanOption.values()) {
            buttonList.add(new ToggleButton(booleanOption, PADDING, yOffset, BUTTON_HEIGHT, main.getWidth() - (PADDING * 2), 0xFFeb4034, 0xFFFFFFFF));
            yOffset += PADDING + BUTTON_HEIGHT;
        }

        for (NumberOption numberOption : NumberOption.values()) {
            buttonList.add(new SliderButton(numberOption, PADDING, yOffset, BUTTON_HEIGHT,main.getWidth() - (PADDING * 2), 0xFFeb4034, 0xFFFFFFFF));
            yOffset += PADDING + BUTTON_HEIGHT;
        }

        buttonList.add(new BitmapButton("Main Menu", main, R.drawable.button, PADDING, main.getHeight() - (BUTTON_HEIGHT * 2), BUTTON_HEIGHT, main.getWidth() - (PADDING * 2), 0xFF000000) {
            @Override
            public void buttonListener() {
                getMain().setCurrentScreen(new MenuScreen(getMain()));
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
