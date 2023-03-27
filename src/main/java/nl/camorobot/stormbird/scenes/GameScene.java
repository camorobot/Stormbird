package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.objects.Ground;

public class GameScene extends DynamicScene {

    private Stormbird stormbird;
    private String sprite;

    public GameScene(Stormbird stormbird){
        this.stormbird = stormbird;
        sprite = "sprites/yellowBird-midflap.png";
    }

    public GameScene(Stormbird stormbird, String sprite){
        this.stormbird = stormbird;
        this.sprite = sprite;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-day.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new Ground(getWidth(), getHeight()));
        for(int numberOfGroundEntitys = 1; numberOfGroundEntitys <= 20; numberOfGroundEntitys++){
            addEntity(new Ground(getWidth() * numberOfGroundEntitys, getHeight()));
        }

        addEntity(new PlayerBird(sprite, new Coordinate2D(getWidth() / 2, getHeight() / 2)));
    }
}
