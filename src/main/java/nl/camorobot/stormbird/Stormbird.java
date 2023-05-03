package nl.camorobot.stormbird;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.player.Player;
import nl.camorobot.stormbird.scenes.GameOverScene;
import nl.camorobot.stormbird.scenes.GameScene;
import nl.camorobot.stormbird.scenes.ShopScene;
import nl.camorobot.stormbird.scenes.TitleScene;

public class Stormbird extends YaegerGame {
    Player player = new Player(this);
    private PlayerBird _playerBird = new PlayerBird(this, "sprites/yellowbird-midflap.png", new Coordinate2D(250, 375));;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("StormBird");
        setSize(new Size(500, 750));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this, player));
        addScene(1, new GameScene(this, player, () -> _playerBird));
        addScene(2, new GameOverScene(this, player));
        addScene(3, new ShopScene(this,player));
    }

    public void set_playerBird(PlayerBird _playerBird) {
        this._playerBird = _playerBird;
    }

    public PlayerBird get_playerBird() {
        return _playerBird;
    }
}
