package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TitleSceneBird extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Newtonian, Bird {

    Timer timerJump = new Timer("JumpBird");
    Random randJumpMoment = new Random();


    public TitleSceneBird(String sprite, Coordinate2D location) {
        super(sprite, location, new Size(60, 60));
//        setAutoCycle(25);
        setMotion(3, Direction.RIGHT);
        setGravityConstant(0.4);
        setFrictionConstant(0.05);
        timerJump();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocation(new Coordinate2D(-60, new Random().nextInt((int) getSceneHeight() - 60)));
    }

    public void timerJump() {
        int delay = randJumpMoment.nextInt(150,750);
        TimerTask task = new TimerTask() {
            public void run() {
                jump();
                timerJump();
            }
        };

        timerJump.schedule(task, delay);
    }

    @Override
    public void jump() {
        setMotion(8, 135d);
    }
}
