package dmServer;

public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        Player player1 = new Player("IronMan", engine);
        Player player2 = new Player("Wolwerine", engine);
    }

}