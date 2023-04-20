package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
    private int score = -1;

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.BLACK);
    }

    public void setScore(int score){
        this.score = score;
        setText(String.valueOf(score));
    }

    public int getScore(){
        return score;
    }
}
