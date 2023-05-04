package nl.camorobot.stormbird.objects;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Ground extends MovingObject {

    private double width;
    private double height;

    public Ground(double width, double height) {
        super("sprites/base-long.png", new Coordinate2D(width, height));
        this.width = width;
        this.height = height;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAnchorLocation(new Coordinate2D(width, height));
    }

    @Override
    public void updateSpeed(double newSpeed) {
        super.updateSpeed(newSpeed);
    }
}
