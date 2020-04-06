package me.myattaw.gameapp.menu.type;

import me.myattaw.gameapp.menu.Button;

public class TextButton extends Button {

    private String string;

    public TextButton(String string, int x, int y, int height, int width) {
        super(x, y, height, width);
        this.string = string;
    }

    @Override
    public void onClick(int x, int y) {
        if (x > getX() && x < getX() + getHeight() && y > getY() && y < getY() + getHeight()) {
            System.out.println("Clicked button");
        }
    }

    @Override
    public void onHover(int x, int y) {

    }
}
