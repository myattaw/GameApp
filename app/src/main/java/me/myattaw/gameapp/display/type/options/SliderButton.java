package me.myattaw.gameapp.display.type.options;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import me.myattaw.gameapp.display.Button;
import me.myattaw.gameapp.options.BooleanOption;
import me.myattaw.gameapp.options.NumberOption;

public class SliderButton extends Button {

    private String label;
    private Paint textColor = new Paint();
    private Paint rectColor = new Paint();

    private NumberOption option;

    private final int PADDING = 10;

    private Rect value;

    public SliderButton(NumberOption options, int x, int y, int height, int width, int textColor, int rectColor) {
        super(x, y, height, width);
        this.option = options;
        this.label = options.getLabel();
        this.textColor.setColor(textColor);
        this.textColor.setTextSize(100);
        this.textColor.setTextAlign(Paint.Align.CENTER);
        this.rectColor.setColor(rectColor);
        this.value = new Rect(getRect().left + PADDING, getRect().top + PADDING, getRect().right - PADDING, getRect().bottom - PADDING);
    }

    @Override
    public void onClick(float x, float y) {
        if (x > getX() && x < (getX() + getWidth()) && y > getY() && y < (getY() + getHeight())) {
            System.out.println("Test");

//            property.setFloatValue(((mouseX - x) * (property.maximum.toFloat() - property.minimum.toFloat()) / width + property.minimum.toFloat()))
//            option.setValue();

            option.setValue(Math.max(option.getMinimum(), Math.min(option.getMaximum(), (int) ((x - value.left) * (option.getMaximum() - option.getMinimum()) / value.width() + option.getMinimum()))));
        }
    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawRect(getRect(), rectColor);
        float valueWidth = (float) (option.getValue() - option.getMinimum()) / (option.getMaximum() - option.getMinimum());
        canvas.drawRect(value.left, value.top, value.left + Math.round(valueWidth * value.width()), value.bottom, textColor);

//        if (option.isEnable()) {
//            rect.inset(PADDING / 2, PADDING / 2);
//            canvas.drawRect(rect, toggleColor);
//        }

//        canvas.drawText(label, getHeight() + getRect().right - (getRect().width() / 2), getRect().top + (getRect().height() / 2) - ((textColor.descent() + textColor.ascent()) / 2), textColor);
    }

}