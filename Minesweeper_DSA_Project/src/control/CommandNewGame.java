package control;

public class CommandNewGame implements Command {
    private CommandController controller;

    public CommandNewGame(CommandController commandController) {
        this.controller = commandController;
    }

    @Override
    public void execute(){
        controller.runGame();
    }   
}
