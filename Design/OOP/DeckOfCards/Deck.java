import java.util.*;
public class Deck {
    private List<Card> deck;
    public Deck() {
        this.deck = new ArrayList<Card>();
        
        // init
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card c = new Card(s, r);
                deck.add(c);
            }
        }   
    }
    
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : deck) {
            sb.append(c.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String args[]) {
        Deck d = new Deck();
        System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());
    }
}