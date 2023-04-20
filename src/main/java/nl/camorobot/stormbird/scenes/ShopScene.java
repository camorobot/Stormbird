package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.BackButton;
import nl.camorobot.stormbird.assets.text.CoinsText;
import nl.camorobot.stormbird.birds.ShopBird;
import nl.camorobot.stormbird.player.Player;

import java.util.ArrayList;

public class ShopScene extends DynamicScene {

    private Stormbird _stormbird;
    private Player _player;
    private CoinsText _coinText;
    private ArrayList<Boolean> unlocked;
    private ArrayList<Integer> birds;

    public ShopScene(Stormbird stormbird, Player player){
        this._stormbird = stormbird;
        this._player = player;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-night.png");
        _coinText = new CoinsText(new Coordinate2D(getWidth()-100, 30), 9999, false);
    }

    @Override
    public void setupEntities() {
        addEntity(new BackButton(_stormbird, new Coordinate2D(70, 40)));
        addEntity(_coinText);
        addEntity(new ShopBird("sprites/yellowbird-midflap.png", new Coordinate2D(80,250), 0));
        addEntity(new CoinsText(new Coordinate2D(100, 300), 0, true));
        addEntity(new ShopBird("sprites/bluebird-midflap.png", new Coordinate2D(220,250), 0));
        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 300), 100, false));
        addEntity(new ShopBird("sprites/redbird-midflap.png", new Coordinate2D(380,250), 0));
        addEntity(new CoinsText(new Coordinate2D(380, 300), 100, false));
        addEntity(new ShopBird("sprites/pinkbird-midflap.png", new Coordinate2D(80,400), 0));
        addEntity(new CoinsText(new Coordinate2D(80, 450), 100, false));
        addEntity(new ShopBird("sprites/greenbird-midflap.png", new Coordinate2D(220,400), 0));
        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 450), 100, false));
    }
}
