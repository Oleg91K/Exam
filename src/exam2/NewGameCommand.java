package exam2;

public class NewGameCommand implements Command{
    private Game game;

    public NewGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.newGame();
    }
}