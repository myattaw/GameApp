package me.myattaw.gameapp.menu;

import android.graphics.Rect;

public abstract class Button implements Clickable {

    private int x, y;
    private int height, width;
    private Rect rect;

    public Button(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.rect = new Rect(x, y, x + width, y + height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rect getRect() {
        return rect;
    }
}
