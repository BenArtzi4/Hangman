package sample;

public class GameLogic {
    int wrongGuesses;

    public GameLogic()
    {
        restart();
    }

    public void restart()
    {
        wrongGuesses = 0;
    }
}
