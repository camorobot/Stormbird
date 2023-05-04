package nl.camorobot.stormbird.assets.imageEntitys;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PlayerImg extends SpriteEntity {
    public PlayerImg(double x, double y){
        super("sprites/player.png", new Coordinate2D(x,y), new Size(100,100));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
