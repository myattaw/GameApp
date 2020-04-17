package me.myattaw.gameapp.display.type;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import me.myattaw.gameapp.Main;
import me.myattaw.gameapp.R;
import me.myattaw.gameapp.display.Button;
import me.myattaw.gameapp.display.screen.GameScreen;

public class BitmapButton extends Button {

    private Paint rectColor = new Paint();

    private int imageID;
    private Main main;

    public BitmapButton(Main main, int imageID, int x, int y, int height, int width, int rectColor) {
        super(x, y, height, width);
        this.main = main;
        this.imageID = imageID;
        this.rectColor.setColor(rectColor);
    }

    @Override
    public void onClick(float x, float y) {
        if (x > getX() && x < (getX() + getWidth()) && y > getY() && y < (getY() + getHeight())) {

            switch (imageID) {
                case R.drawable.options_button:
                    System.out.println("options screen");
                    break;
                case R.drawable.play_button:
                    main.setCurrentScreen(new GameScreen(main));
                    System.out.println("switch screen");
                    break;
            }

        }
    }

    @Override
    public void onRelease(int x, int y) {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(BitmapFactory.decodeResource(main.getResources(), imageID), null, getRect(), rectColor);
    }
}
