package control;

public class Main {
    public static void main(String[] args) {
        // GameFrame.getInstance();

        // Command pattern
        CommandController commandController = new CommandController();
        Command newGameCommand = new CommandNewGame(commandController);

        newGameCommand.execute();

    }
}
