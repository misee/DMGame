package dmServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class CardReader {

    public CardReader() {
        allCards = new HashSet<Card>();
        try {
            YamlReader reader = new YamlReader(new FileReader("Cards/CardList.yaml"));
            Object object = new Object();
            try {
                object = reader.read();
            } catch (YamlException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(object);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Set<Card> getCards(Set<Integer> cardIds) {
        return allCards;
    }
    private Set<Card> allCards;
}
