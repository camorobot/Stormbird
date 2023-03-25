package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.PlayButton;
import nl.camorobot.stormbird.assets.imageEntitys.StormBirdImg;
import nl.camorobot.stormbird.birds.TitleSceneBird;

public class TitleScene extends DynamicScene {

    private Stormbird stormbird;

    public TitleScene(Stormbird stormbird){
        this.stormbird = stormbird;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-day.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new StormBirdImg());
        addEntity(new PlayButton(new Coordinate2D(getWidth()/2, getHeight()/2 - 50)));
        addEntity(new TitleSceneBird(new Coordinate2D(getWidth()/2, getHeight()/2 + 50)));
    }
}
