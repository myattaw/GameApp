package me.myattaw.gameapp.display.type;

import android.graphics.Canvas;
import android.graphics.Paint;

import me.myattaw.gameapp.display.Button;

public class TextButton extends Button {

    private String text;
    private Paint textColor = new Paint();
    private Paint rectColor = new Paint();

    public TextButton(String text, int x, int y, int height, int width, int textColor, int rectColor) {
        super(x, y, height, width);
        this.text = text;
        this.textColor.setColor(textColor);
        this.textColor.setTextSize(100);
        this.textColor.setTextAlign(Paint.Align.CENTER);
        this.rectColor.setColor(rectColor);
    }

    @Override
    public void onClick(float x, float y) {
        if (x > getX() && x < (getX() + getWidth()) && y > getY() && y < (getY() + getHeight())) {
            System.out.println("Clicked button");
        }
    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(getRect(), rectColor);
        canvas.drawText(text, getRect().right - (getRect().width() / 2), getRect().top + (getRect().height() / 2) - ((textColor.descent() + textColor.ascent()) / 2), textColor);
    }

}
