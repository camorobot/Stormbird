package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class PlayerBird extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, KeyListener, Newtonian, Bird, Collided {
    public PlayerBird(String sprite, Coordinate2D initialLocation) {
        super(sprite, initialLocation, new Size(60,60));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setGravityConstant(0.75);
        setFrictionConstant(0.05);
    }


    @Override
    public void jump() {
        setMotion(8, 180d);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if(set.contains(KeyCode.SPACE)){
            jump();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAnchorLocation(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        // die the bird;
    }

    @Override
    public void onCollision(List<Collider> list) {
        System.out.println("die");
    }
}
