package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.objects.Ground;
import nl.camorobot.stormbird.objects.Tube;
import nl.camorobot.stormbird.objects.coins.Coin;
import nl.camorobot.stormbird.objects.coins.SilverCoin;
import nl.camorobot.stormbird.player.Player;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends DynamicScene {

    private Stormbird stormbird;
    private Player player;
    private String sprite;
    private int nextTube;

    Tube topTube;
    Tube bottomTube;
    SilverCoin silverCoin;

    public GameScene(Stormbird stormbird, Player player){
        this.stormbird = stormbird;
        this.player = player;
        sprite = "sprites/yellowBird-midflap.png";
    }

    public GameScene(Stormbird stormbird, String sprite){
        this.stormbird = stormbird;
        this.sprite = sprite;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-day.png");
    }

    @Override
    public void setupEntities() {
        /**Generate the tubes*/
        topTube = new Tube("sprites/pipe-green-top-2.png", "top", getWidth(), -349);
        bottomTube = new Tube("sprites/pipe-green-bottom-2.png", "bottom" , getWidth(), -349);
        silverCoin = new SilverCoin(player, getWidth(), -349);


        /**Timer for generating new tube location*/
        Timer timerTubeGenerator = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                nextTube = topTube.getRandomTube();
                topTube.setTubeNumber(nextTube);
                bottomTube.setTubeNumber(nextTube);
            }
        };
        timerTubeGenerator.schedule(task, new Date(), 1000);

        /**Add Entity's to field*/
        addEntity(new PlayerBird(stormbird, sprite, new Coordinate2D(getWidth() / 2, getHeight() / 2)));
        addEntity(topTube);
        addEntity(bottomTube);
        addEntity(silverCoin);

        for(int numberOfGroundEntitys = 1; numberOfGroundEntitys <= 20; numberOfGroundEntitys++){
            addEntity(new Ground(getWidth() * numberOfGroundEntitys, getHeight()));
        }
    }
}
