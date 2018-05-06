package dmServer;

import java.util.List;

import dmServer.Card.Energy;

public class EnergyFace implements Face {
    public EnergyFace(List<Card.Energy> e){
        energies = e;
    }
    private List<Card.Energy> energies;
    
    public String toString() {
        String returnValue = "";
        for (Energy energy : energies) {
            returnValue.concat(energy.name());
        }
        return returnValue;
    }
}
