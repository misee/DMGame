package dmServer;

import java.util.List;
import java.util.Map;

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
    public enum FaceIds {
        energy1,
        energy2,
        energy3,
        level1,
        level2,
        level3
    }
    public Card(String n, int cn, List<Energy> en, Affiliation af, Map<FaceIds, Face> f) {
        name = n;
        costNumber = cn;
        costEnergies = en;
        affiliation = af;
        faces = f;
    }
    public String toString() {
        String returnValue =  "Name: ".concat(name).concat(" Cost number: ").concat(Integer.toString(costNumber))
                .concat("\n Dices: \n");
        for (Face face : faces.values()) {
            returnValue = returnValue.concat(face.toString()).concat(" ");
        }
        return returnValue;
    }

    private String name;
    private int costNumber;
    private List<Energy> costEnergies;
    private Affiliation affiliation;
    private Map<FaceIds, Face> faces;
}
