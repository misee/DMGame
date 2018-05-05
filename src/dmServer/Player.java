package dmServer;

public class Player {

    public Player(String n, GameEngine engine) {
        name = n;
        gameEngine = engine;
        gameEngine.register(this);
    }
    public String getName() {
        return name;
    }
    private String name;
    private GameEngine gameEngine;
}
