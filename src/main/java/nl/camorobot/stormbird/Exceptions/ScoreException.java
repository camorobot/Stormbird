package nl.camorobot.stormbird.Exceptions;

public class ScoreException extends RuntimeException{
    public ScoreException(NullPointerException e) {
        super(e);
    }

}
