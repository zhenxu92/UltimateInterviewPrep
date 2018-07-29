public class Card {
    private Ranks rank;
    private Suits suit;
    public Card(Suits suit, Ranks rank) {
        this.rank = rank;
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        String s = rank.toString() + ":" + suit.toString();
        return s;
    }
    
    
}