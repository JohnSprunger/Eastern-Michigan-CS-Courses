import java.util.ArrayList;
import java.util.Collections;
/*****************************************************************
 Program Description:
 Pick cards from a shuffled deck of 52 cards repeatedly and
 find out how many picks are needed before you can see one of each
 suit. Assume a picked card is placed back in the deck before
 picking another. Write a Java program that simulates the number
 of picks needed to get four cards(one from each suit) and display
 the four cards picked.

 @author John Sprunger
 @version 1.0
 @date 09/14/2016
 @class COSC 211 - Programming Data Structures
 @assignment Machine Problem #1
 *****************************************************************/

/*****************************************************************
 The main class of the application. It creates the deck, user's
 hand, and runs the simulation.
 *****************************************************************/
public class Deck {

    /** An array list to hold the deck */
    private ArrayList<Card> newDeck;

    /** An array list to hold the user's hand */
    private ArrayList<Card> userHand;

    /** Current number of turns */
    private int numTurns;

    /*****************************************************************
     Constructor creates the list for the deck and the hand.
     *****************************************************************/
    public Deck(){
        newDeck = new ArrayList<>();
        userHand = new ArrayList<>();
        numTurns = 0;
    }

    /*****************************************************************
     An enum used to hold the available suits for the cards
     *****************************************************************/
    public enum Suit {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

    /*****************************************************************
     An enum used to hold the available face values for the cards.
     *****************************************************************/
    public enum Face {
        TWO ("2"),
        THREE ("3"),
        FOUR ("4"),
        FIVE ("5"),
        SIX ("6"),
        SEVEN ("7"),
        EIGHT ("8"),
        NINE ("9"),
        TEN ("10"),
        JACK ("JACK"),
        QUEEN ("QUEEN"),
        KING ("KING"),
        ACE ("ACE");

        /**A variable to hold the strings proper display name*/
        private final String name;

        //A constructor that turns my enums into proper strings.
        Face(String s) {
            name = s;
        }

        //Returns string value
        public String toString() {
            return this.name;
        }
    }

    /*****************************************************************
     A method to generate the deck.
     *****************************************************************/
    public void makeDeck(){
        //A for each loop that creates the deck
        for (Suit s : Suit.values()) {
            for (Face r : Face.values()) {
                Card c = new Card(s, r);
                newDeck.add(c);
            }
        }
        //A method in collections that randomly sorts my arraylist.
        Collections.shuffle(newDeck);
    }

    /*****************************************************************
     A simple getting method for the number of turns
     *****************************************************************/
    public int getNumTurns(){ return numTurns; }

    /*****************************************************************
     A method for printing the user's hand
     *****************************************************************/
    public void printHand(){
        //iterates the hand and prints it out
        for (int i = 0; i < userHand.size(); i++) {
            System.out.println(this.userHand.get(i).getCardFace() + " of " +
                    this.userHand.get(i).getCardSuit());
        }
    }

    /*****************************************************************
     A method for shuffling the deck of cards
     *****************************************************************/
    public void shuffleDeck(){
        Collections.shuffle(this.newDeck);
    }

    /*****************************************************************
     A method that handles the drawing of cards and sorting the cards
     *****************************************************************/
    public void playGame(){
        //The loop to check if we have all the suits
        while(userHand.size() < 4){
            boolean newSuit = true;
            Card temp = newDeck.get(0);
            //A for each loop to go through the users hands
            for(Card c : userHand){
                //Checks if the drawn card has the same suit as a card
                //in the hand.
                if(c.getCardSuit() == temp.getCardSuit()){
                    newSuit = false;
                }
            }
            //If the suit is actually new it will add to the hand.
            if(newSuit) {
                userHand.add(temp);
            }
            shuffleDeck();
            this.numTurns++;
        }
    }

    /*****************************************************************
     A method to run the simulation
     *****************************************************************/
    public void runSim(){
        makeDeck();
        playGame();
        printHand();
        System.out.println();
        System.out.println("Number of picks is: " + getNumTurns());
        System.out.println("THANK YOU FOR USING JOHN SPRUNGER'S PROGRAM");
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.runSim();
    }
}

