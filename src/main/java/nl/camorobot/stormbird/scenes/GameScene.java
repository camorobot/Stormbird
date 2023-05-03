package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.text.ScoreText;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.objects.Ground;
import nl.camorobot.stormbird.objects.Tube;
import nl.camorobot.stormbird.objects.coins.SilverCoin;
import nl.camorobot.stormbird.player.Player;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public class GameScene extends DynamicScene {

    private Stormbird stormbird;
    private Player player;
    private PlayerBird _playerbird;
    private Supplier<PlayerBird> playerBirdSupplier;
    private String sprite;
    private int nextTube;

    Tube topTube;
    Tube bottomTube;
    SilverCoin silverCoin;

    public GameScene(Stormbird stormbird, Player player, Supplier<PlayerBird> playerBirdSupplier){
        this.stormbird = stormbird;
        this.player = player;
        this.playerBirdSupplier = playerBirdSupplier;
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
        var scoreText = new ScoreText(new Coordinate2D(0, 0));
        addEntity(scoreText);
        silverCoin = new SilverCoin(player, getWidth(), -349);
        topTube = new Tube("sprites/pipe-green-top-2.png", "top", scoreText, getWidth(), -349);
        bottomTube = new Tube("sprites/pipe-green-bottom-2.png", "bottom" , getWidth(), -349);



        /**Timer for generating new tube location*/
        Timer timerTubeGenerator = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                nextTube = topTube.getRandomTube();
                topTube.setTubeNumber(nextTube);
                bottomTube.setTubeNumber(nextTube);
//                silverCoin.setTubeNumber(nextTube);
            }
        };
        timerTubeGenerator.schedule(task, new Date(), 1000);

        /**Add Entity's to field*/
        PlayerBird currentPlayerBird = playerBirdSupplier.get();
        addEntity(currentPlayerBird);
        System.out.println(stormbird.get_playerBird());
        addEntity(topTube);
        addEntity(bottomTube);
        addEntity(silverCoin);

        for(int numberOfGroundEntitys = 1; numberOfGroundEntitys <= 20; numberOfGroundEntitys++){
            addEntity(new Ground(getWidth() * numberOfGroundEntitys, getHeight()));
        }
    }
}
