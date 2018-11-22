import java.util.Random;

/**
 *
 * @author Vance Field III
 */
public class Service {        
    
    private String[] cards = {"Ace", "Two", "Three", "Four", "Five", "Six",
                              "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
                              "King"};
    
    private Random rand = new Random();
    
    // counts of each card. max is 4
    private int twoCount = 0;
    private int threeCount = 0;
    private int fourCount = 0;
    private int fiveCount = 0;
    private int sixCount = 0;
    private int sevenCount = 0;
    private int eightCount = 0;
    private int nineCount = 0;
    private int tenCount = 0;
    private int jackCount = 0;
    private int queenCount = 0;
    private int kingCount = 0;
    private int aceCount = 0;
    
    // the count of the deck
    private int cardCount = 0;
    
    // how many cards have been drawn
    private int cardsDrawn = 0;
    
    // how many times there has been a redraw
    private int cardsRedrawn = 0;
       
    private final int DECK_SIZE = 52;
    
    /**
     * 
     */
    public void deal(){
        
        // loops through one deck of cards
        for (int DEAL_INDEX = 1; DEAL_INDEX <= DECK_SIZE; DEAL_INDEX++){
            
            // draw a card
            int card = rand.nextInt(13);            
            
            // determine the card
            if( cards[card].equals("Two") && twoCount < 4){
                cardCount++;
                twoCount++;
            }
            else if( cards[card].equals("Three") && threeCount < 4){
                cardCount++;
                threeCount++;
            }
            else if( cards[card].equals("Four") && fourCount < 4){
                cardCount++;
                fourCount++;
            }
            else if( cards[card].equals("Five") && fiveCount < 4){
                cardCount++;
                fiveCount++;
            }
            else if( cards[card].equals("Six") && sixCount < 4){
                cardCount++;
                sixCount++;
            }
            else if( cards[card].equals("Seven") && sevenCount < 4){
                //cardCount++;
                sevenCount++;
            }
            else if( cards[card].equals("Eight") && eightCount < 4){
                //cardCount++;
                eightCount++;
            }
            else if( cards[card].equals("Nine") && nineCount < 4){
                //cardCount++;
                nineCount++;
            }
            else if( cards[card].equals("Ten") && tenCount < 4){
                cardCount--;
                tenCount++;
            }
            else if( cards[card].equals("Jack") && jackCount < 4){
                cardCount--;
                jackCount++;
            }
            else if( cards[card].equals("Queen") && queenCount < 4){
                cardCount--;
                queenCount++;
            }
            else if( cards[card].equals("King") && kingCount < 4){
                cardCount--;
                kingCount++;
            }
            else if( cards[card].equals("Ace") && aceCount < 4){
                cardCount--;
                aceCount++;
            }
            // redraw because the card drawn has reached its limit of 4
            else { 
                //System.out.println("Redrawing at " + i + " with a " + cards[card]);
                cardsRedrawn++;
                DEAL_INDEX--; // reset i 
            }
            
            // check the count after every card is dealt
            checkCount();
            
            
            cardsDrawn = DEAL_INDEX;
            
        }//for
        
    } //getCount   
    
    /**
     * Determines whether or not the count is hot or cold
     */
    private void checkCount(){
        if(cardCount>=3){
            System.out.println("Count is hot. Good time to bet.");
        }
        else if(cardCount<=-3){
            System.out.println("Count is cold. Bad time to bet.");
        }
    }
    
    /**
     * Returns the current card count
     * @return the card count
     */
     public int getCount(){
        return cardCount;
    }
     
}//Service
