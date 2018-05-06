package dmServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import dmServer.Card.Affiliation;
import dmServer.Card.Energy;
import dmServer.Card.FaceIds;

public class CardReader {

    public CardReader() {
        allCards = new HashMap<Integer, Card>();
        try {
            YamlReader reader = new YamlReader(new FileReader("Cards/CardList.yaml"));
            readListOfCards(reader);

            for (Card card : allCards.values()) {
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
        List<Energy> energies = new ArrayList<Energy>();
        readEnergy((String)cardDetails.get("costEnergy"), energies);
        Affiliation affiliation = readAffiliation((String)cardDetails.get("affiliation"));
        Map<FaceIds, Face> faces = new HashMap<FaceIds, Face>();
        readDiceFaces((Map)cardDetails.get("diceFaces"), faces);
        allCards.put(cardId, new Card(cardName, costNumber, energies, affiliation, faces));
    }
    private void readDiceFaces(Map diceFaces, Map<FaceIds, Face> faces) {
        convertEnergyFace(FaceIds.energy1, "energy1", diceFaces, faces);
        convertEnergyFace(FaceIds.energy2, "energy2", diceFaces, faces);
        convertEnergyFace(FaceIds.energy3, "energy3", diceFaces, faces);
        convertCharacterFace(FaceIds.level1, "level1", diceFaces, faces);
        convertCharacterFace(FaceIds.level2, "level2", diceFaces, faces);
        convertCharacterFace(FaceIds.level3, "level3", diceFaces, faces);
    }
    private void convertCharacterFace(FaceIds level, String diceFaceId, Map diceFaces, Map<FaceIds, Face> faces) {
        List<String> characterFaces = (List<String>)diceFaces.get(diceFaceId);
        int field = Integer.parseInt((String)characterFaces.get(0));
        int attack = Integer.parseInt((String)characterFaces.get(1));
        int defense = Integer.parseInt((String)characterFaces.get(2));
        boolean burst = false;
        if(characterFaces.size() > 3) {
            burst = true;
        }
        faces.put(level, new Character(field, attack, defense, burst));
        
    }
    private void convertEnergyFace(FaceIds energy, String diceFaceId, Map diceFaces, Map<FaceIds, Face> faces) {
        List<Energy> energies = new ArrayList<Energy>();
        readEnergy((String)diceFaces.get(diceFaceId), energies);
        faces.put(energy, new EnergyFace(energies));
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
    private void readEnergy(String energy, List<Energy> energies) {
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
        Set<Card> returnedCards = new HashSet<Card>();
        for (Integer cardId : cardIds) {
           returnedCards.add(allCards.get(cardId));
        }
        return returnedCards;
    }
    private Map<Integer, Card> allCards;
}
