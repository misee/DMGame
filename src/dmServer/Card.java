package dmServer;

import java.util.List;

public class Card {

    public enum Energy{
        mask,
        shield,
        fist,
        bolt,
        generic,
        wild
    }
    public enum Affiliation{
        x_men,
        avengers,
        none
    }
    public Card(int i, String n, int cn, List<Energy> en, Affiliation af) {
        id = i;
        name = n;
        costNumber = cn;
        costEnergies = en;
        affiliation = af;
    }
    private int id;
    private String name;
    private int costNumber;
    private List<Energy> costEnergies;
    private Affiliation affiliation;
    private Dice dice;
    public String toString() {
        return "Name: ".concat(name).concat(" Id: ").concat(Integer.toString(id));
    }
}
