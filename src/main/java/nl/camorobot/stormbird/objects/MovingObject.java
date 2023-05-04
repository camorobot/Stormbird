package nl.camorobot.stormbird.objects;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class MovingObject extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    public MovingObject(String sprite, Coordinate2D initialLocation) {
        super(sprite, initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(6, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    }

    public void updateSpeed(double newSpeed) {
        setSpeed(newSpeed);
    }
}

