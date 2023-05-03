package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.PlayButton;
import nl.camorobot.stormbird.assets.buttons.PlayerButton;
import nl.camorobot.stormbird.assets.buttons.ShopButton;
import nl.camorobot.stormbird.assets.imageEntitys.StormBirdImg;
import nl.camorobot.stormbird.assets.text.CurrentPlayerText;
import nl.camorobot.stormbird.birds.PlayerBird;
import nl.camorobot.stormbird.birds.TitleSceneBird;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;

import java.util.Random;

public class TitleScene extends DynamicScene {

    private Stormbird stormbird;
    private Player player;
    private PlayerDAO playerDAO;
    private CurrentPlayerText playerUsernameTextKevin;
    private CurrentPlayerText playerUsernameTextFlappy;

    private int birdColor;
    private String sprite;
    private Random randBirdSprite = new Random();
    private String activePlayer;


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
        for(int i = 0; i < 6; i++){
            birdColor = i;
            if(birdColor == 3){
                birdColor = randBirdSprite.nextInt(0,3);
            }
            if(birdColor == 0){
                sprite = "sprites/yellowBird-upflap.png";
            } else if (birdColor == 1){
                sprite = "sprites/blueBird-upflap.png";
            } else if (birdColor == 2) {
                sprite = "sprites/redBird-upflap.png";
            }
            else if (birdColor == 3) {
                sprite = "sprites/greenBird-upflap.png";
            }
            addEntity(new TitleSceneBird(sprite, new Coordinate2D(getWidth()/2, getHeight()/2 + 50)));
        }
        addEntity(new StormBirdImg());
        addEntity(new PlayButton(stormbird, new Coordinate2D(getWidth()/2, getHeight()/2 - 50)));
        addEntity(new ShopButton(stormbird, new Coordinate2D(getWidth()/2, getHeight()/2 + 250)));


        addEntity(new PlayerButton("sprites/Eric.png",new Coordinate2D(getWidth()/3, getHeight()/2 + 100), "Erick", new Size(50,50), player));
        addEntity(new PlayerButton("sprites/Towelie.png",new Coordinate2D(getWidth()/3 * 2, getHeight()/2 + 100), "Towelie", new Size(100,100), player));
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }
}
