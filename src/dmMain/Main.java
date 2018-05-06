package dmMain;

import java.util.HashSet;
import java.util.Set;

import dmClient.Client;
import dmServer.GameEngine;

public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        Client client1 = new Client(engine);
        //This is just temporary
        Set<Integer> cardlist1 = new HashSet<Integer>();
        cardlist1.add(1);cardlist1.add(2);cardlist1.add(3);
        client1.register("IronMan", cardlist1);
        Client client2 = new Client(engine);
        Set<Integer> cardlist2 = new HashSet<Integer>();
        cardlist2.add(1);cardlist2.add(2);cardlist2.add(3);
        client2.register("Wolwerine",cardlist2);
    }

}