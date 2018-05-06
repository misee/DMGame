package dmServer;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private static final int NUMBER_OF_PLAYERS = 2;
    public GameEngine() {
        cardReader = new CardReader();
        players = new ArrayList<Player>();
    }
    public void register(String playerName, Set<Integer> cardIds) {
        Player player = new Player(playerName);
        Set<Card> cards = cardReader.getCards(cardIds);
        player.use(cards);
        players.add(player);
        if(players.size() == NUMBER_OF_PLAYERS) {
            int randnum = (int)(Math.random() * NUMBER_OF_PLAYERS);
            Player active = players.get(randnum);
        }
    }
    private List<Player> players;
    private CardReader cardReader;
}
