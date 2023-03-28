package nl.camorobot.stormbird.objects;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.stormbird.Exceptions.ScoreException;
import nl.camorobot.stormbird.assets.text.ScoreText;

import java.util.*;

public class Tube extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    private double x;
    private double y;
    public int tubeNumber;

    private String direction;
    private ScoreText scoreText;
    private Random randTube = new Random();

    private List<Integer> topTubes = Arrays.asList(-250, -100, 0, 100);
    private List<Integer> bottomTubes = Arrays.asList(650, 800, 900, 1000);


    public Tube(String sprite, String direction, double x, double y) {
        super(sprite, new Coordinate2D(x, y));
        this.x = x;
        this.y = y;
        this.direction = direction;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(6, 270d);
    }

    public Tube(String sprite, String direction, ScoreText scoreText,double x, double y) {
        super(sprite, new Coordinate2D(x, y));
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.scoreText = scoreText;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(6, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if(direction == "top"){
            setAnchorLocation(new Coordinate2D(x + 50, topTubes.get(getTubeNumber())));
            try {
                scoreText.setScore(scoreText.getScore() + 1);
            } catch (NullPointerException e){
                throw new ScoreException(e);
            }
        } else{
            setAnchorLocation(new Coordinate2D(x+ 50, bottomTubes.get(getTubeNumber())));
        }
    }

    public int getRandomTube(){
        return randTube.nextInt(0,3);
    }

    public int getTubeNumber() {
        return tubeNumber;
    }

    public void setTubeNumber(int tubeNumber) {
        this.tubeNumber = tubeNumber;
    }
}
