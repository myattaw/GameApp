package me.myattaw.gameapp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import me.myattaw.gameapp.display.screen.CustomScreen;
import me.myattaw.gameapp.display.screen.GameScreen;
import me.myattaw.gameapp.display.MainScreen;
import me.myattaw.gameapp.display.screen.MenuScreen;

public class Main extends Activity {

    private CustomScreen currentScreen;
    private MainThread mainThread;

    public SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Testing");
        setContentView(surfaceView = new MainScreen(this, this));

        this.currentScreen = new MenuScreen(this);
        this.mainThread = new MainThread(this, surfaceView.getHolder(), getResources()).startGame();
        // Set content view to game, so that objects in the Game class can be rendered to the screen
    }

    public SurfaceHolder getSurfaceHolder() {
        return surfaceView.getHolder();
    }

    public SurfaceView getSurfaceView() {
        return surfaceView;
    }

    public int getWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public CustomScreen getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(CustomScreen currentScreen) {
        this.currentScreen = currentScreen;
    }
}
