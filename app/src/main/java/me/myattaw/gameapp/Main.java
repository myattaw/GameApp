package me.myattaw.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

import me.myattaw.gameapp.menu.main.MainMenu;

public class Main extends Activity {

    private SurfaceView currentSurface;
    private MainThread mainThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Testing");

        this.currentSurface = new MainMenu(this);
        this.mainThread = new MainThread(this, currentSurface.getHolder()).startGame();

        // Set content view to game, so that objects in the Game class can be rendered to the screen
        setContentView(currentSurface);
    }

    public SurfaceView getCurrentSurface() {
        return currentSurface;
    }

    public void setCurrentSurface(SurfaceView currentSurface) {
        this.currentSurface = currentSurface;
    }
}
