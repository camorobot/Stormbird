package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.PlayButton;
import nl.camorobot.stormbird.assets.buttons.PlayerButton;
import nl.camorobot.stormbird.assets.imageEntitys.PlayerImg;
import nl.camorobot.stormbird.assets.imageEntitys.StormBirdImg;
import nl.camorobot.stormbird.assets.text.PlayerUsernameText;
import nl.camorobot.stormbird.birds.TitleSceneBird;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;

import java.util.Random;

public class TitleScene extends DynamicScene {

    private Stormbird stormbird;
    private Player player;
    private PlayerDAO playerDAO;
    private PlayerUsernameText playerUsernameTextKevin;
    private PlayerUsernameText playerUsernameTextFlappy;


    private int birdColor;
    private String sprite;
    private Random randBirdSprite = new Random();


    public TitleScene(Stormbird stormbird, Player player){
        this.stormbird = stormbird;
        this.player = player;
        playerDAO = new PlayerDAO(player);
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
        addEntity(new PlayButton(stormbird, new Coordinate2D(getWidth()/2, getHeight()/2 - 50)));


        playerUsernameTextKevin = new PlayerUsernameText("Kevin",getWidth()/3, getHeight()/2 + 135);
        addEntity(playerUsernameTextKevin);
        addEntity(new PlayerButton(playerUsernameTextKevin, new Coordinate2D(getWidth()/3, getHeight()/2 + 100)));

        playerUsernameTextFlappy = new PlayerUsernameText("Flappy",getWidth()/3 * 2, getHeight()/2 + 135);
        addEntity(playerUsernameTextFlappy);
        addEntity(new PlayerButton(playerUsernameTextFlappy, new Coordinate2D(getWidth()/3 * 2, getHeight()/2 + 100)));
    }
}
