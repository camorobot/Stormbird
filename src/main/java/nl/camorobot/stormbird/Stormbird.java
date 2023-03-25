package nl.camorobot.stormbird;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Stormbird extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Sormbird");
        setSize(new Size(450, 700));
    }

    @Override
    public void setupScenes() {

    }
}
