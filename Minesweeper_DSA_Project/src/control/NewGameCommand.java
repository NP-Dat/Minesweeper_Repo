package control;

public class NewGameCommand implements Command {
    private GameStarter gameStarter;

    public NewGameCommand(GameStarter gameStarter) {
        this.gameStarter = gameStarter;
    }

    @Override
    public void execute(){
        gameStarter.run();
    }   
}
