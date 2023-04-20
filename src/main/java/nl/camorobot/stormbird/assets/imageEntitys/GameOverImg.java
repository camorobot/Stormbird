package nl.camorobot.stormbird.assets.imageEntitys;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class GameOverImg extends SpriteEntity {
    public GameOverImg(double x, double y){
        super("sprites/gameover.png", new Coordinate2D(x,y));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
