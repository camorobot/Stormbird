package nl.camorobot.stormbird.assets.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.Stormbird;
import nl.camorobot.stormbird.assets.text.PlayerUsernameText;

public class PlayerButton extends SpriteEntity implements MouseButtonPressedListener {
    private PlayerUsernameText playerUsernameText;

    public PlayerButton(PlayerUsernameText playerUsernameText, Coordinate2D coordinate2D){
        super("sprites/player.png", coordinate2D, new Size(100,100));
        this.playerUsernameText = playerUsernameText;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(playerUsernameText.getUsername() == "Kevin"){
            playerUsernameText.setBigPlayerUsernameText("Kevin");
            playerUsernameText.setSmallPlayerUsernameText("Flappy");
        } else{
            playerUsernameText.setBigPlayerUsernameText("Flappy");
            playerUsernameText.setSmallPlayerUsernameText("Kevin");
        }
    }
}
