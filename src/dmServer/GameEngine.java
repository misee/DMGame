package dmServer;

import java.util.List;

public class GameEngine {

    private static final int NUMBER_OF_PLAYERS = 2;
    public GameEngine() {

    }
    public void register(Player player) {
        players.add(player);
        if(players.size() == NUMBER_OF_PLAYERS) {
            int randnum = (int)(Math.random() * NUMBER_OF_PLAYERS);
            Player active = players.get(randnum);
            
        }
    }
    private List<Player> players;
}
