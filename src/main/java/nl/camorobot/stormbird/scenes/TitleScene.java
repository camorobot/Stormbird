package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.PlayButton;
import nl.camorobot.stormbird.assets.imageEntitys.StormBirdImg;
import nl.camorobot.stormbird.birds.TitleSceneBird;

import java.util.Random;

public class TitleScene extends DynamicScene {

    private Stormbird stormbird;
    int birdColor;
    String sprite;
    Random randBirdSprite = new Random();


    public TitleScene(Stormbird stormbird){
        this.stormbird = stormbird;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background-day.png");
    }

    @Override
    public void setupEntities() {
        for(int i = 0; i < 5; i++){
            birdColor = i;
            if(birdColor == 3){
                birdColor = randBirdSprite.nextInt(0,2);
            }
            if(birdColor == 0){
                sprite = "sprites/yellowBird-upflap.png";
            } else if (birdColor == 1){
                sprite = "sprites/blueBird-upflap.png";
            } else if (birdColor == 2) {
                sprite = "sprites/redBird-upflap.png";
            }
            addEntity(new TitleSceneBird(sprite, new Coordinate2D(getWidth()/2, getHeight()/2 + 50)));
        }
        addEntity(new StormBirdImg());
        addEntity(new PlayButton(new Coordinate2D(getWidth()/2, getHeight()/2 - 50)));
    }
}
