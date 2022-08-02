package Card;

import java.util.*;

/**
 * @date 2022-8-2
 * @author seyyu0015@163.com
 * @version 1.0
 *
 * 1.生产一副扑克牌(54张),保存到集合对象
 * 2.洗牌(实现打乱算法)
 * 3.发牌(轮流),保留3张牌
 * 3.1:设计玩家类Player(属性方法)
 * 属性:name,隐藏属性:LinkedList<Card> cards(保存玩家手中的牌)
 * 方法:发牌方法add(Card card)
 * 打印每个玩家手中的牌
 **/
public class Card_main {
    public static void main(String[] args) {
        //初始化玩家
        Player player1 = new Player("player1", "cards1");
        Player player2 = new Player("player2", "cards2");
        Player player3 = new Player("player3", "cards3");

        //1.生产一副扑克牌(54张),保存到集合对象
        List<Card> cards = cardCreate();
        System.out.println("====1.生成一副扑克牌====");
        System.out.println("牌堆：" + cards);

        //2.洗牌(实现打乱算法)
        cards = myShuffle(cards);
        System.out.println("====2.洗牌====");
        System.out.println("牌堆：" + cards);

        //3.发牌
        deal(player1, player2, player3, cards);
        System.out.println("====3.发牌====");
        System.out.println("|玩家1的牌" + player1.getCards());
        System.out.println("|玩家2的牌" + player2.getCards());
        System.out.println("|玩家3的牌" + player3.getCards());
    }

    /**
     * 生产一副扑克牌(54张),保存到集合对象
     *
     * @return 扑克牌集合
     */
    public static List<Card> cardCreate() {
        //1.生产一副扑克牌(54张),保存到集合对象
        List<Card> cards = new ArrayList<Card>();//初始化一个牌堆集合
        for (int i = 1; i < 5; i++) {//四种基础花色...
            for (int j = 1; j < 14; j++) {//...13种不同数字
                //创建卡片并加入牌堆
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
        //两张小丑牌加入牌堆
        Card ace = new Card(5, 14);
        Card big_ace = new Card(5, 15);
        cards.add(ace);
        cards.add(big_ace);

        return cards;
    }

    /**
     * 洗牌(实现打乱算法)
     *
     * @return 打乱的牌堆
     */
    public static List<Card> myShuffle(List<Card> cards) {
        List<Card> new_cards = new ArrayList<Card>();//初始化一个新的牌堆集合
        for (Card card : cards) {//遍历牌堆...
            int index = (int) (Math.random() * (new_cards.size()));//...在新的牌堆中随机找到一个位置...
            new_cards.add(index, card);//...将老牌堆按顺序插入到这个位置。
        }
        return new_cards;
    }

    /**
     * 发牌(轮流),保留3张牌
     */
    public static void deal(Player player1, Player player2, Player player3, List<Card> cards) {

        //获取玩家的牌堆
        LinkedList<Card> cards1 = player1.getCards();
        LinkedList<Card> cards2 = player2.getCards();
        LinkedList<Card> cards3 = player3.getCards();

        //发牌
        int i = 1;
        for (Card card : cards) {
            switch (i) {
                case 3 -> {
//                    System.out.println("将" + card + "发给玩家" + i);
                    cards3.add(card);
                    i = 1;
                }
                case 2 -> {
//                    System.out.println("将" + card + "发给玩家" + i);
                    cards2.add(card);
                    i++;
                }
                case 1 -> {
//                    System.out.println("将" + card + "发给玩家" + i);
                    cards1.add(card);
                    i++;
                }
            }
        }
        //将牌堆送还给玩家
        player1.setCards(cards1);
        player2.setCards(cards2);
        player3.setCards(cards3);
    }
}
