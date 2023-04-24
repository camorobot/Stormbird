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

    public void fillBirdsArray(){
        // Not sow nice code;
        birds.add(1);
        birds.add(2);
        birds.add(3);
        birds.add(1002);
        birds.add(1003);
        unlocked.add(false);
        unlocked.add(false);
        unlocked.add(false);
        unlocked.add(false);
        unlocked.add(false);
        if(_player.getSkins().contains(1)){
            unlocked.set(0, true);
        }
        if(_player.getSkins().contains(2)){
            unlocked.set(1, true);
        }
        if(_player.getSkins().contains(3)){
            unlocked.set(2,true);
        }
        if(_player.getSkins().contains(1002)){
            unlocked.set(3,true);
        }
        if(_player.getSkins().contains(1003)){
            unlocked.set(4, true);
        }
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-night.png");
        _coinText = new CoinsText(new Coordinate2D(getWidth()-100, 30), _player.getCoins(), false);
    }

    @Override
    public void setupEntities() {
        unlocked = new ArrayList<Boolean>();
        birds = new ArrayList<Integer>();
        fillBirdsArray();
        addEntity(new BackButton(_stormbird, new Coordinate2D(70, 40)));
        addEntity(_coinText);
        addEntity(new ShopBird("sprites/yellowbird-midflap.png", new Coordinate2D(80,250), 0, _player));
        addEntity(new CoinsText(new Coordinate2D(100, 300), 0, unlocked.get(0)));
        addEntity(new ShopBird("sprites/bluebird-midflap.png", new Coordinate2D(220,250), 100, _player));
        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 300), 100, unlocked.get(1)));
        addEntity(new ShopBird("sprites/redbird-midflap.png", new Coordinate2D(380,250), 100, _player));
        addEntity(new CoinsText(new Coordinate2D(380, 300), 100, unlocked.get(2)));
        addEntity(new ShopBird("sprites/pinkbird-midflap.png", new Coordinate2D(80,400), 100, _player));
        addEntity(new CoinsText(new Coordinate2D(80, 450), 100, unlocked.get(3)));
        addEntity(new ShopBird("sprites/greenbird-midflap.png", new Coordinate2D(220,400), 100, _player));
        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 450), 100, unlocked.get(4)));
        System.out.println(unlocked.get(4));
    }
}
