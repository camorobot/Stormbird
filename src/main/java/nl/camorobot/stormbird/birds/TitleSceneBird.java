package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class TitleSceneBird extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    public TitleSceneBird(Coordinate2D location) {
        super("sprites/redBird-upflap.png", location, new Size(150, 150));
//        setAutoCycle(25);
        setMotion(3, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocation(new Coordinate2D(-150, new Random().nextInt((int) getSceneHeight() - 150)));

    }
}
