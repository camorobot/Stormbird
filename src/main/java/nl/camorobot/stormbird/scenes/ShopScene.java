package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.BackButton;
import nl.camorobot.stormbird.assets.text.CoinsText;
import nl.camorobot.stormbird.birds.ShopBird;
import nl.camorobot.stormbird.player.Player;

import java.util.ArrayList;
import java.util.List;

public class ShopScene extends DynamicScene {

    private Stormbird _stormbird;
    private Player _player;
    private CoinsText _coinText;
    private ArrayList<Boolean> unlocked;
    private ArrayList<Integer> birds;
    private ArrayList<String> birdsSprites;
    private ArrayList<CoinsText> birdTexts;
    private ShopBird selectedBird;



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
            birdsSprites.add("sprites/yellowbird-midflap.png");
        }
        if(_player.getSkins().contains(2)){
            unlocked.set(1, true);
            birdsSprites.add("sprites/bluebird-midflap.png");
        }
        if(_player.getSkins().contains(3)){
            unlocked.set(2,true);
            birdsSprites.add("sprites/redbird-midflap.png");
        }
        if(_player.getSkins().contains(1002)){
            unlocked.set(3,true);
            birdsSprites.add("sprites/pinkbird-midflap.png");
        }
        if(_player.getSkins().contains(1003)){
            unlocked.set(4, true);
            birdsSprites.add("sprites/greenbird-midflap.png");
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
        birdsSprites = new ArrayList<String>();
        birdTexts = new ArrayList<>();
        selectedBird = null; // null betekent dat er geen vogel is geselecteerd

        fillBirdsArray();
        addEntity(new BackButton(_stormbird, new Coordinate2D(70, 40)));
        addEntity(_coinText);
        addEntity(new ShopBird(_stormbird, "sprites/yellowbird-midflap.png", new Coordinate2D(80,250), 0, _player, this));
//        addEntity(new CoinsText(new Coordinate2D(100, 300), 0, unlocked.get(0)));
        addEntity(new ShopBird(_stormbird, "sprites/bluebird-midflap.png", new Coordinate2D(220,250), 100, _player, this));
//        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 300), 100, unlocked.get(1)));
        addEntity(new ShopBird(_stormbird, "sprites/redbird-midflap.png", new Coordinate2D(380,250), 100, _player, this));
//        addEntity(new CoinsText(new Coordinate2D(380, 300), 100, unlocked.get(2)));
        addEntity(new ShopBird(_stormbird, "sprites/pinkbird-midflap.png", new Coordinate2D(80,400), 100, _player, this));
//        addEntity(new CoinsText(new Coordinate2D(80, 450), 100, unlocked.get(3)));
        addEntity(new ShopBird(_stormbird, "sprites/greenbird-midflap.png", new Coordinate2D(220,400), 100, _player, this));
//        addEntity(new CoinsText(new Coordinate2D(getWidth()/2-30, 450), 100, unlocked.get(4)));
        System.out.println(birds);
        System.out.println(unlocked);

        birdTexts.add(new CoinsText(new Coordinate2D(100, 300), 0, unlocked.get(0)));
        birdTexts.add(new CoinsText(new Coordinate2D(getWidth()/2-30, 300), 100, unlocked.get(1)));
        birdTexts.add(new CoinsText(new Coordinate2D(380, 300), 100, unlocked.get(2)));
        birdTexts.add(new CoinsText(new Coordinate2D(80, 450), 100, unlocked.get(3)));
        birdTexts.add(new CoinsText(new Coordinate2D(getWidth()/2-30, 450), 100, unlocked.get(4)));

        for (CoinsText birdText : birdTexts) {
            addEntity(birdText);
        }



// Voeg soortgelijke code toe voor de andere vogels

    }

    public void updateSelectedText(int birdIndex) {
        hideOwnedText();
        birdTexts.get(birdIndex).setText("Selected");
        showOwnedText();
    }

    public void hideOwnedText() {
        for (int i = 0; i < birdTexts.size(); i++) {
            if (unlocked.get(i)) {
                birdTexts.get(i).setTextVisibility(false);
            }
        }
    }

    public void showOwnedText() {
        for (int i = 0; i < birdTexts.size(); i++) {
            if (unlocked.get(i)) {
                birdTexts.get(i).setTextVisibility(true);
            }
        }
    }

    public ArrayList<Boolean> getUnlocked() {
        return unlocked;
    }
    public ArrayList<Integer> getBirds() {
        return birds;
    }
    public ArrayList<String> getBirdsSprites() {
        return birdsSprites;
    }
    public ShopBird getSelectedBird() {
        return selectedBird;
    }

    public void setSelectedBird(ShopBird selectedBird) {
        this.selectedBird = selectedBird;
    }
    public List<CoinsText> getBirdTexts() {
        return birdTexts;
    }


}
