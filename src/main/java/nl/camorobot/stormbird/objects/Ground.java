package nl.camorobot.stormbird.objects;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Ground extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    private double width;
    private double height;

    public Ground(double width, double height) {
        super("sprites/base-long.png", new Coordinate2D(width, height));
        this.width = width;
        this.height = height;
        setMotion(6, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAnchorLocation(new Coordinate2D(width, height));
    }

}
