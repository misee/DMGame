package dmClient;

import java.util.Set;

import dmServer.GameEngine;

public class Client {

    public Client(GameEngine eng) {
        engine = eng;
    }
    public void register(String playerName, Set<Integer> cardList) {
        engine.register(playerName, cardList);
    }
    private GameEngine engine;
}
