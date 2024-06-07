package control;

public class Main {
    public static void main(String[] args) {
        // GameFrame.getInstance();

        // Command pattern

        CommandExecuteGame commandExecuteGame = new CommandExecuteGame();
        Command newGameCommand = new CommandNewGame(commandExecuteGame);

        newGameCommand.execute();

    }
}
