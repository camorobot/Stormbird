package nl.camorobot.stormbird.assets.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.Stormbird;

public class PlayButton extends SpriteEntity implements MouseButtonPressedListener {

    private Stormbird stormbird;

    public PlayButton(Stormbird stormbird, Coordinate2D coordinate2D){
        super("sprites/PlayGame.png", coordinate2D);
        this.stormbird = stormbird;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        stormbird.setActiveScene(1);
    }
}
