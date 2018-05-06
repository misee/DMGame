package dmClient;

import dmServer.GameEngine;
import dmServer.Player;

public class Client {

    public Client(String playerName, GameEngine engine) {
        Player player = new Player(playerName);
        engine.register(player);
    }

}
