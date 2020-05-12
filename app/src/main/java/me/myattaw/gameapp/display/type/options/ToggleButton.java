package me.myattaw.gameapp.display.type.options;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import me.myattaw.gameapp.display.Button;
import me.myattaw.gameapp.options.BooleanOption;

public class ToggleButton extends Button {

    private String label;
    private Paint textColor = new Paint();
    private Paint rectColor = new Paint();

    private BooleanOption option;

    private final int PADDING = 25;

    public ToggleButton(BooleanOption options, int x, int y, int height, int width, int textColor, int rectColor) {
        super(x, y, height, width);
        this.option = options;
        this.label = options.getLabel();
        this.textColor.setColor(textColor);
        this.textColor.setTextSize(100);
        this.textColor.setTextAlign(Paint.Align.RIGHT);
        this.rectColor.setColor(rectColor);
    }

    @Override
    public void onClick(float x, float y) {
        if (x > getX() && x < (getX() + getWidth()) && y > getY() && y < (getY() + getHeight())) {
            System.out.println("Clicked button");
            option.setEnable(!option.isEnable());
        }
    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = new Rect(getRect().left, getRect().top, getRect().left + getHeight(), getRect().top + getHeight());

        canvas.drawRect(rect, rectColor);

        if (option.isEnable()) {
            rect.inset(PADDING / 2, PADDING / 2);
            canvas.drawRect(rect, textColor);
        }

        canvas.drawText(label, getRect().right, getRect().top + (getRect().height() / 2) - ((textColor.descent() + textColor.ascent()) / 2), textColor);
    }

}