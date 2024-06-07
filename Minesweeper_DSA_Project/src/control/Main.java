package control;

public class Main {
    public static void main(String[] args) {
        // GameFrame.getInstance();

        // Command pattern

        GameStarter gameStarter = new GameStarter();
        Command newGameCommand = new NewGameCommand(gameStarter);

        newGameCommand.execute();

    }
}
