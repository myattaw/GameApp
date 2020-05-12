package me.myattaw.gameapp.display.type;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import me.myattaw.gameapp.Main;
import me.myattaw.gameapp.display.Button;

public abstract class BitmapButton extends Button {

    private Paint rectColor = new Paint();
    private Paint textColor = new Paint();

    private String label;
    private int imageID;
    private Main main;


    public BitmapButton(Main main, int imageID, int x, int y, int height, int width, int rectColor) {
        super(x, y, height, width);
        this.main = main;
        this.imageID = imageID;
        this.rectColor.setColor(rectColor);
    }

    public BitmapButton(String label, Main main, int imageID, int x, int y, int height, int width, int rectColor) {
        super(x, y, height, width);
        this.label = label;
        this.main = main;
        this.imageID = imageID;

        this.textColor.setColor(0xFFededed);
        this.textColor.setTextSize(125);
        this.textColor.setTextAlign(Paint.Align.CENTER);

        this.rectColor.setColor(rectColor);
    }

    public Main getMain() {
        return main;
    }

    public abstract void buttonListener();

    @Override
    public void onClick(float x, float y) {
        if (x > getX() && x < (getX() + getWidth()) && y > getY() && y < (getY() + getHeight())) {
            buttonListener();
        }
    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawBitmap(BitmapFactory.decodeResource(main.getResources(), imageID), null, getRect(), rectColor);
        if (label != null) {
            canvas.drawText(label, getRect().centerX(), getRect().centerY() - ((textColor.descent() + textColor.ascent()) / 2), textColor);
        }
    }
}
