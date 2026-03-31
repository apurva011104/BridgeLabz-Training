import java.util.Arrays;
import java.util.Scanner;

public class DistributeCards {

    final static String []SUITS = {"Hearts","Diamonds","Clubs","Spades"};
    final static String []RANKS = {"2","3","4","5","6","7","8","9","Jack","Queen","King","Ace"};

    public static String[] generateCards(int totalCards){
        String []cards = new String[totalCards];
        for(int i=0;i<totalCards;i++){
            String suit=SUITS[(int)(Math.random()*3)];
            String rank=RANKS[(int)(Math.random()*12)];
            cards[i]=rank+" of "+suit;
        }
        return cards;
    }

    public static void shuffleCards(String []cards, int totalCards){
        for(int i=0;i<totalCards;i++){
            int newPosition=(i+(int)Math.random()*(totalCards-1))%totalCards;
            String temp=cards[i];
            cards[i]=cards[newPosition];
            cards[newPosition]=temp;
        }
    }

    public static String [][]distributeCard(String []cards, int numberOfPlayers){
        String [][]distributedCards = new String[numberOfPlayers][cards.length/numberOfPlayers];
        for(int index=0 ; index<cards.length ; index++){
            int row=index%numberOfPlayers;
            int col=index/numberOfPlayers;
            distributedCards[row][col]=cards[index];
        }
        return distributedCards;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Taking input
        System.out.print("Enter number of players(>1): ");
        int numberOfPlayers=scan.nextInt();
        while(numberOfPlayers<2){
            System.out.print("Invalid input! Enter again: ");
            numberOfPlayers=scan.nextInt();
        }
        System.out.println("Enter number of cards for one player(>0): ");
        int numberOfCardsForOnePlayer=scan.nextInt();
        while(numberOfPlayers<1){
            System.out.print("Invalid input! Enter again: ");
            numberOfCardsForOnePlayer=scan.nextInt();
        }

        int totalCards= numberOfCardsForOnePlayer * numberOfPlayers;

        //Generate cards
        String []cards = generateCards(totalCards);
        System.out.println("Deck of Cards: ");
        System.out.println(Arrays.toString(cards));

        //Shuffle Cards
        shuffleCards(cards, totalCards);
        System.out.println("Deck of cards after shuffling: ");
        System.out.println(Arrays.toString(cards));

        //Distribute cards among players
        String [][]distributedCards = distributeCard(cards, numberOfPlayers);
        System.out.println("Distribute Cards: ");
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Player "+(i+1)+"'s cards: "+Arrays.toString(distributedCards[i]));
        }
    }
}
