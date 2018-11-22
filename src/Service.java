import java.util.Random;

/**
 *
 * @author Vance Field III
 */
public class Service {        
    
    /** 
     * array of strings where each string represents a type of card in Blackjack
     */ 
    private final String[] cards = {
        "Ace", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen","King"};
      
    // times each card has been dealt (4 is max)
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
           
    // size of one deck of cards
    private final int DECK_SIZE = 52;
    
    // amount required for hot or cold streaks
    private final int STREAK_MINIMUM = 3;
    
    /**
     * Deals a new deck of cards of size `DECK_SIZE`
     * Each time a card is dealt the count is checked for Hot or Cold streaks
     */
    public void dealDeck(){
        
        Random rand = new Random();
        
        // loops through one deck of cards
        for (int DEAL_INDEX = 1; DEAL_INDEX <= DECK_SIZE; DEAL_INDEX++){
            
            //System.out.println("DEAL_INDEX is:" + DEAL_INDEX);
            
            // pull a card
            if ( pullCard(rand.nextInt(13)) ){
                // check the count after every card is dealt
                System.out.print("On card " + DEAL_INDEX + " the ");
                checkIfHotOrCold();
            }            
            
            // the card pulled has hit its limit. pull again
            else {                
                DEAL_INDEX--;
            }
                        
        }//for
        
    } //getCount   

     /**
      * Pulls a new card from the deck
      * Each card can only be pulled 4 times
      * @param _card the pulled card 
      */
    private boolean pullCard(int _card) {
        int card = _card;            
        boolean success = false;
            
            // determine the card
            if( cards[card].equals("Two") && twoCount < 4){
                cardCount++;
                twoCount++;
                success = true;
            }
            else if( cards[card].equals("Three") && threeCount < 4){
                cardCount++;
                threeCount++;
                success = true;
            }
            else if( cards[card].equals("Four") && fourCount < 4){
                cardCount++;
                fourCount++;
                success = true;
            }
            else if( cards[card].equals("Five") && fiveCount < 4){
                cardCount++;
                fiveCount++;
                success = true;
            }
            else if( cards[card].equals("Six") && sixCount < 4){
                cardCount++;
                sixCount++;
                success = true;
            }
            else if( cards[card].equals("Seven") && sevenCount < 4){
                //cardCount++;
                sevenCount++;
                success = true;
            }
            else if( cards[card].equals("Eight") && eightCount < 4){
                //cardCount++;
                eightCount++;
                success = true;
            }
            else if( cards[card].equals("Nine") && nineCount < 4){
                //cardCount++;
                nineCount++;
                success = true;
            }
            else if( cards[card].equals("Ten") && tenCount < 4){
                cardCount--;
                tenCount++;
                success = true;
            }
            else if( cards[card].equals("Jack") && jackCount < 4){
                cardCount--;
                jackCount++;
                success = true;
            }
            else if( cards[card].equals("Queen") && queenCount < 4){
                cardCount--;
                queenCount++;
                success = true;
            }
            else if( cards[card].equals("King") && kingCount < 4){
                cardCount--;
                kingCount++;
                success = true;
            }
            else if( cards[card].equals("Ace") && aceCount < 4){
                cardCount--;
                aceCount++;
                success = true;
            }
            
            // here for debugging
            else {
                //System.out.println("### " + cards[card] + " HIT LIMIT ###");
            }
            
        return success;
            
    }//pullCard()
    
      /**
     * Determines whether or not the count is hot or cold
     */
    private void checkIfHotOrCold(){
        if(cardCount >= STREAK_MINIMUM){
            if (cardCount >= 5) {
                System.out.println("Count is VERY hot.");
            }
            else {
                System.out.println("Count is hot.");
            }
        }
        else if(cardCount <= -STREAK_MINIMUM){
            if (cardCount <= -5) {
                System.out.println("Count is VERY cold.");
            }
            else {
                System.out.println("Count is cold.");
            }
        }
        else {
            System.out.println("Count is normal.");
        }
    }
    
    /**
     * Returns the current card count
     * @return the card count
     */
     private int getCount(){
        return cardCount;
    }
     
}//Service
