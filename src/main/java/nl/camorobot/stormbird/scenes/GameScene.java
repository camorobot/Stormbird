package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.text.ScoreText;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.objects.Ground;
import nl.camorobot.stormbird.objects.Tube;
import nl.camorobot.stormbird.observers.ScoreObserver;
import nl.camorobot.stormbird.player.Player;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public class GameScene extends DynamicScene implements ScoreObserver {

    private Stormbird stormbird;
    private Player player;
    private PlayerBird _playerbird;
    private Supplier<PlayerBird> playerBirdSupplier;
    private String sprite;
    private int nextTube;

    Tube topTube;
    Tube bottomTube;

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
        scoreText.addObserver(this); // Add GameScene as an observer
        topTube = new Tube("sprites/pipe-green-top-2.png", "top", scoreText, getWidth(), -349);
        bottomTube = new Tube("sprites/pipe-green-bottom-2.png", "bottom" , getWidth(), -349);

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
        PlayerBird currentPlayerBird = playerBirdSupplier.get();
        addEntity(currentPlayerBird);
        System.out.println(stormbird.get_playerBird());
        addEntity(topTube);
        addEntity(bottomTube);

        for(int numberOfGroundEntitys = 1; numberOfGroundEntitys <= 20; numberOfGroundEntitys++){
            addEntity(new Ground(getWidth() * numberOfGroundEntitys, getHeight()));
        }
    }

    @Override
    public void onScoreUpdate(int newScore) {
        double newSpeed = topTube.getSpeed();
        if (newScore == 10) {
            // Verhoog de snelheid met 15%
            newSpeed = topTube.getSpeed() * 1.15;
        }
        if (newScore == 20){
            // Verhoog de snelheid met 30%
            newSpeed = topTube.getSpeed() * 1.30;
        }
        if (newScore == 30){
            // Verhoog de snelheid met 45%
            newSpeed = topTube.getSpeed() * 1.45;
        }
        if (newScore == 40){
            // Verhoog de snelheid met 60%
            newSpeed = topTube.getSpeed() * 1.60;
        }
        topTube.updateSpeed(newSpeed);
        bottomTube.updateSpeed(newSpeed);
    }
}

