package dmMain;

import dmClient.Client;
import dmServer.GameEngine;

public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        new Client("IronMan", engine);
        new Client("Wolwerine", engine);
    }

}