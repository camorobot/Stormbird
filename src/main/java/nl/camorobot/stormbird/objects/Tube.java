package nl.camorobot.stormbird.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.stormbird.Exceptions.ScoreException;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.text.ScoreText;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tube extends MovingObject {

    private double x;
    private double y;
    public int tubeNumber;

    private String direction;
    private ScoreText scoreText;
    private Random randTube = new Random();
    private Stormbird _stormbird;

    private List<Integer> topTubes = Arrays.asList(-250, -100, 0, 100);
    private List<Integer> bottomTubes = Arrays.asList(650, 800, 900, 1000);

    public Tube(String sprite, String direction, double x, double y) {
        super(sprite, new Coordinate2D(x, y));
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Tube(String sprite, String direction, ScoreText scoreText, double x, double y, Stormbird stormbird) {
        super(sprite, new Coordinate2D(x, y));
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.scoreText = scoreText;
        this._stormbird = stormbird;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (direction.equals("top")) {
            setAnchorLocation(new Coordinate2D(x + 30, topTubes.get(getTubeNumber())));
            try {
                scoreText.setScore(scoreText.getScore() + 1);
                _stormbird.setScore(scoreText.getScore() + 1);
            } catch (NullPointerException e) {
                throw new ScoreException(e);
            }
        } else {
            setAnchorLocation(new Coordinate2D(x + 30, bottomTubes.get(getTubeNumber())));
        }
    }

    @Override
    public void updateSpeed(double newSpeed) {
        super.updateSpeed(newSpeed);
    }

    public int getRandomTube() {
        return randTube.nextInt(0, 3);
    }

    public int getTubeNumber() {
        return tubeNumber;
    }

    public void setTubeNumber(int tubeNumber) {
        this.tubeNumber = tubeNumber;
    }
}

