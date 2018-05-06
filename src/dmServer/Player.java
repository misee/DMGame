package dmServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import dmServer.Card.Energy;
import dmServer.Card.FaceIds;

public class Player {
    private final int STARTING_SIDEKICK_NUMBER = 8;
    private String name;
    private List<Dice> bag;
    private List<Dice> drawnDices;

    public Player(String n) {
        name = n;
        bag = new ArrayList<Dice>();
        addSideKicks();
    }
    private void addSideKicks() {
        for(int i = 0; i < STARTING_SIDEKICK_NUMBER; i++) {
            Map<FaceIds, Face> faces = new HashMap<FaceIds, Face>();
            addEnergy(Energy.bolt, FaceIds.energy1, faces);
            addEnergy(Energy.fist, FaceIds.energy2, faces);
            addEnergy(Energy.mask, FaceIds.energy3, faces);
            addEnergy(Energy.shield, FaceIds.level2, faces);
            addEnergy(Energy.wild, FaceIds.level3, faces);
            faces.put(FaceIds.level1, new Character(0, 1, 1, false));
            Dice sidekick = new Dice(faces);
            bag.add(sidekick);
        }
    }

    private void addEnergy(Energy energy, FaceIds id, Map<FaceIds, Face> faces) {
        List<Energy> energyList = new ArrayList<Energy>();
        energyList.add(energy);
        faces.put(id, new EnergyFace(energyList));
    }
    public String getName() {
        return name;
    }
    public void use(Set<Card> cards){
        
    }
    public void draw(int numberOfDraws) {
        //TODO handle empty bag
        drawnDices = new ArrayList<Dice>();
        for(int i = 0; i < numberOfDraws; i++) {
            int randomNumber = (int)Math.random() * bag.size();
            ListIterator<Dice> iter = bag.listIterator();
            int counter = 0;
            while(iter.hasNext()) {
                Dice dice = iter.next();
                if(randomNumber == counter)
                {
                    drawnDices.add(dice);
                    break;
                }
                counter++;
            }
            iter.remove();
        }
        System.out.println("Drawn dices: ");
        for (Dice dice : drawnDices) {
            System.out.println(dice.toString());
        }
    }
}
