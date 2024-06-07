package control;

public class CommandNewGame implements Command {
    private CommandExecuteGame newGame;

    public CommandNewGame(CommandExecuteGame game) {
        this.newGame = game;
    }

    @Override
    public void execute(){
        newGame.run();
    }   
}
