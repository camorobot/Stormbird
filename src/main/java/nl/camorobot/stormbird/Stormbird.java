package nl.camorobot.stormbird;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.camorobot.stormbird.player.Player;
import nl.camorobot.stormbird.scenes.GameOverScene;
import nl.camorobot.stormbird.scenes.GameScene;
import nl.camorobot.stormbird.scenes.TitleScene;

public class Stormbird extends YaegerGame {
    Player player = new Player(this);

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
        addScene(0, new TitleScene(this, player));
        addScene(1, new GameScene(this, player));
        addScene(2, new GameOverScene(this, player));
    }
}
