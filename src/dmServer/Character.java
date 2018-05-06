package dmServer;

public class Character implements Face{
    public Character(int fC, int a, int d, boolean b) {
        fieldCost = fC;
        attack = a;
        defense = d;
        burst = b;
    }
    private int fieldCost;
    private int attack;
    private int defense;
    private boolean burst;
    
    public String toString() {
        return "Fielding Cost: ".concat(Integer.toString(fieldCost)).
                concat(" Attack: ").concat(Integer.toString(attack)).
                concat(" Defense: ").concat(Integer.toString(defense)).
                concat(" Burst: ").concat(Boolean.toString(burst));
    }
    
}
