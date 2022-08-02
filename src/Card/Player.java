package Card;

import lombok.Data;

import java.util.LinkedList;
/**
 * @date 2022-8-2
 * @author seyyu0015@163.com
 * @version 1.0
 */
@Data
public class Player {
    private String name;
    private LinkedList<Card> cards;

    public Player(String name, String cards) {
        this.name = name;
        this.cards = new LinkedList<Card>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }
}
