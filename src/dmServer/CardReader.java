package dmServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import dmServer.Card.Affiliation;
import dmServer.Card.Energy;

public class CardReader {

    public CardReader() {
        allCards = new HashSet<Card>();
        try {
            YamlReader reader = new YamlReader(new FileReader("Cards/CardList.yaml"));
            readListOfCards(reader);
            //Object object = reader.read();
            //System.out.println(object);
            for (Card card : allCards) {
                System.out.println(card);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        }
    }
    private void readListOfCards(YamlReader reader) throws YamlException{
        ArrayList<Map> cards = (ArrayList<Map>)reader.read();
        for (Map cardContainer : cards) {
            Map cardDetails = (Map)(cardContainer).get("card");
            readCardDetails(cardDetails);
        }
    }
    
    private void readCardDetails(Map cardDetails) {
        int cardId = Integer.parseInt((String)cardDetails.get("id"));
        String cardName = (String) cardDetails.get("name");
        int costNumber = Integer.parseInt((String)cardDetails.get("costNumber"));
        List<Card.Energy> energies = new ArrayList<Card.Energy>();
        readEnergy((String)cardDetails.get("costEnergy"), energies);
        Card.Affiliation affiliation = readAffiliation((String)cardDetails.get("affiliation"));
        List<Face> faces = readDiceFaces();
        allCards.add(new Card(cardId, cardName, costNumber, energies, affiliation));
    }
    private List<Face> readDiceFaces() {
        // TODO Auto-generated method stub
        return null;
    }
    private Affiliation readAffiliation(String affiliation) {
        if(affiliation.equals("x_men")) {
            return Affiliation.x_men;
        }
        else if(affiliation.equals("avengers")) {
            return Affiliation.avengers;
        }
        return Affiliation.none;
    }
    private void readEnergy(String energy, List<Card.Energy> energies) {
        if(energy.equals("mask")) {
            energies.add(Energy.mask);
        }
        else if(energy.equals("maskmask")) {
            energies.add(Energy.mask);
            energies.add(Energy.mask);
        }
        else if(energy.equals("shield")) {
            energies.add(Energy.shield);
        }
        else if(energy.equals("shieldshield")) {
            energies.add(Energy.shield);
            energies.add(Energy.shield);
        }
        else if(energy.equals("bolt")) {
            energies.add(Energy.bolt);
        }
        else if(energy.equals("boltbolt")) {
            energies.add(Energy.bolt);
            energies.add(Energy.bolt);
        }
        else if(energy.equals("fist")) {
            energies.add(Energy.fist);
        }
        else if(energy.equals("fistfist")) {
            energies.add(Energy.fist);
            energies.add(Energy.fist);
        }
        else if(energy.equals("generic")) {
            energies.add(Energy.generic);
        }
        else if(energy.equals("generic")) {
            energies.add(Energy.generic);
            energies.add(Energy.generic);
        }
        else if(energy.equals("wild")) {
            energies.add(Energy.wild);
        }
    }
    public Set<Card> getCards(Set<Integer> cardIds) {
        return allCards;
    }
    private Set<Card> allCards;
}
