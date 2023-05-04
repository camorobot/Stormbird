package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.dao.DatabaseDAO;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;
import nl.camorobot.stormbird.scenes.ShopScene;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShopBird extends SpriteEntity implements MouseButtonPressedListener {

    private Stormbird _stormbird;
    private int _price;
    private String _sprite;
    private Player _player;
    private ShopScene _shopScene;
    private ArrayList<Boolean> birdsSprites = new ArrayList<>();

    public ShopBird(Stormbird stormbird, String sprite, Coordinate2D initialLocation, Integer price, Player player, ShopScene shopScene) {
        super(sprite, initialLocation, new Size(60,60));
        this._stormbird = stormbird;
        this._sprite = sprite;
        this._price = price;
        this._player = player;
        this._shopScene = shopScene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        // kijk hier of je de bird al hebt, niet? dan buyBird() wel? dan moet je selectBird()
        // kunnen we ophalen met een _shopscene.getUnlocked()
        if (_shopScene.getBirdsSprites().contains(_sprite)) {
            // bird is unlocked

            // Als er een andere vogel eerder is geselecteerd, wijzig de tekst van die vogel naar "Owned"
            if (_shopScene.getSelectedBird() != null && !_shopScene.getSelectedBird().equals(this)) {
                int previousSelectedIndex = _shopScene.getBirdsSprites().indexOf(_shopScene.getSelectedBird().getSprite());
                _shopScene.getBirdTexts().get(previousSelectedIndex).setText("Owned");
            }

            // Selecteer de huidige vogel en wijzig de tekst naar "Selected"
            _shopScene.setSelectedBird(this);
            _stormbird.set_playerBird(new PlayerBird(_stormbird, _sprite, new Coordinate2D(getWidth(), getHeight())));
            int currentIndex = _shopScene.getBirdsSprites().indexOf(_sprite);
            _shopScene.getBirdTexts().get(currentIndex).setText("Selected");
        } else {
            try {
                buyBird(_sprite, _player.getPlayer_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void buyBird(String _sprite, int player_id) throws SQLException {
        System.out.println(_player.getCoins());
        if(_player.getCoins() <100){
            System.out.println("Sorry je hebt geen geld.");
        } else{
            int bird_id = 0;
            if(_sprite.equals("sprites/yellowbird-midflap.png")){
                bird_id = 1;
            }
            if(_sprite.equals("sprites/bluebird-midflap.png")){
                bird_id = 2;
            }
            if(_sprite.equals("sprites/redbird-midflap.png")){
                bird_id = 3;
            }
            if(_sprite.equals("sprites/pinkbird-midflap.png")){
                bird_id = 1002;
            }
            if(_sprite.equals("sprites/greenbird-midflap.png")){
                bird_id = 1003;
            }
            PlayerDAO playerDAO = new PlayerDAO(_player);
            DatabaseDAO databaseDAO = new DatabaseDAO();
            playerDAO.buyBird(databaseDAO.connect(), player_id, bird_id, _player.getCoins() - 100);
            _player.setCoins(_player.getCoins() - 100);
            _stormbird.set_playerBird(new PlayerBird(_stormbird, _sprite, new Coordinate2D(getWidth(), getHeight())));
            System.out.println("Buying bird successful");
        }
    }

    public String getSprite() {
        return _sprite;
    }

}
