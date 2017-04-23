/*****************************************************************
 The card class, it handles the creation of the cards objects
 in the Deck class
 *****************************************************************/
public class Card {

    /** The card's suit */
    private Deck.Suit cardSuit;

    /** The card's face */
    private Deck.Face cardFace;

    /*****************************************************************
     Constructor creates a card with a suit and face value
     *****************************************************************/
    public Card(Deck.Suit cardSuit, Deck.Face cardFace) {
        this.cardSuit = cardSuit;
        this.cardFace = cardFace;
    }

    /*****************************************************************
     A getter to get the cards suit
     *****************************************************************/
    public Deck.Suit getCardSuit() {
        return cardSuit;
    }

    /*****************************************************************
     A getter to get the cards face
     *****************************************************************/
    public Deck.Face getCardFace() {
        return cardFace;
    }
}

