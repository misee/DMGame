package dmServer;

public class Character implements Face{
    public Character(int fC, int a, int d) {
        fieldCost = fC;
        attack = a;
        defense = d;
    }
    private int fieldCost;
    private int attack;
    private int defense;
}
