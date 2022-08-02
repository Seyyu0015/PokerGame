package Card;

import lombok.Data;

/**
 * @date 2022-8-2
 * @author seyyu0015@163.com
 * @version 1.0
 */
@Data
public class Card {
    private int color;
    private int number;

    public Card(int color, int number) {
        this.color = color;
        this.number = number;
    }
    public Card(){

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
