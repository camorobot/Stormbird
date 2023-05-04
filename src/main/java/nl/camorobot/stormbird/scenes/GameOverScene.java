package nl.camorobot.stormbird.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.buttons.BackButton;
import nl.camorobot.stormbird.assets.buttons.PlayButton;
import nl.camorobot.stormbird.assets.imageEntitys.GameOverImg;
import nl.camorobot.stormbird.assets.imageEntitys.StormBirdImg;
import nl.camorobot.stormbird.birds.TitleSceneBird;
import nl.camorobot.stormbird.dao.DatabaseDAO;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;

import java.sql.SQLException;
import java.util.Random;

public class GameOverScene extends DynamicScene {
    private Stormbird stormbird;
    private Player player;
    private int birdColor;
    private String sprite;
    private Random randBirdSprite = new Random();
    private PlayerDAO _playerDAO = new PlayerDAO(player);


    public GameOverScene(Stormbird stormbird, Player player){
        this.stormbird = stormbird;
        this.player = player;
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
            addEntity(new TitleSceneBird(sprite, new Coordinate2D(0, getHeight()/2 + 50)));
        }
        addEntity(new GameOverImg(getWidth()/2, 100));
        addEntity(new BackButton(stormbird, new Coordinate2D(getWidth()/2, getHeight()/2 - 50)));

        try {
            System.out.println("stormbird score : "+stormbird.getScore());
            _playerDAO.updateCoins(new DatabaseDAO().connect(), player.getPlayer_id(), stormbird.getScore());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
