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
import javafx.scene.input.KeyCode;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.objects.coins.Coin;
import nl.camorobot.stormbird.objects.coins.CoinInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerBird extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Newtonian, Bird, Collided {

    private Stormbird stormbird;
    private Set<KeyCode> pressedKeys = new HashSet<>();

    public PlayerBird(Stormbird stormbird, String sprite, Coordinate2D initialLocation) {
        super(sprite, initialLocation, new Size(60,60));
        this.stormbird = stormbird;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setGravityConstant(0.75);
        setFrictionConstant(0.05);
    }

    @Override
    public void jump() {
        setMotion(8, 180d);
    }

    public void handleKeys(Set<KeyCode> keys) {
        pressedKeys = keys;
        if (pressedKeys.contains(KeyCode.SPACE)) {
            jump();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAnchorLocation(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        stormbird.setActiveScene(2);
    }

    @Override
    public void onCollision(List<Collider> collider) {
        if (collider instanceof CoinInterface coin){
            coin.incrementCoins();
        }
        stormbird.setActiveScene(2);
    }
}
