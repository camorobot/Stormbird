package nl.camorobot.stormbird;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.camorobot.stormbird.scenes.TitleScene;

public class Stormbird extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Stormbird");
        setSize(new Size(500, 750));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
    }
}
