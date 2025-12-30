public class SnakeAndLadder {

    //Player class to create players
    static class Player{

        int playerNumber;
        int position;
        int dieRolls;
        public Player(int playerNumber) {
            this.playerNumber= playerNumber;
            position=0;
            dieRolls=0;
        }

        //Methods to roll the die
        private int setDieNumber(){
            return (int)(Math.random()*6)+1;
        }
        public int rollTheDie(){
            return setDieNumber();
        }

        //Methods to update position
        private void setNewPosition(int dieNumber){
            if(position+dieNumber<0){       //If new position is below 0, then the player restarts from 0
                position = 0;      
            }
            else if(position+dieNumber>100){        //If new position is above 100, then no changes in position
                return;            
            }
            else{
                position+=dieNumber;
            }
        }
        public void updatePosition(int dieNumber){
            setNewPosition(dieNumber);
        }

    }

    //Initializing options variables
    private static final String LADDER_OPTION = "Ladder";
    private static final String SNAKE_OPTION = "Snake";
    private static final String NO_PLAY_OPTION = "No play";

    //Method to check option
    private static int checkOption(){
        int option = (int)(Math.random()*3) - 1;
        return option;
    }

    //Method to get option
    public static String getOption(Player player, int dieNumber){
        int option = checkOption();
        switch(option){
            case -1:
                player.updatePosition(-dieNumber);
                return SNAKE_OPTION;
            case 1:
                player.updatePosition(dieNumber);
                return LADDER_OPTION;
            default:
                return NO_PLAY_OPTION;
        }
    }

    public static void printEachRoundData(Player player, int dieNumber, String playerOption){
        System.out.println("Number player "+player.playerNumber +" got by rolling the die: "+dieNumber);
        System.out.println("Player "+player.playerNumber +" option: "+playerOption);
        System.out.println("Player "+player.playerNumber +" current position: "+player.position);
    }

    public static void main(String[] args) {

        System.out.println("Snake & Ladder Simulator");

        //Creating 2 players
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        System.out.println("Player 1's start position: "+player1.position);
        System.out.println("Player 2's start position: "+player2.position);

        boolean isPlayer1Turn = true;       //Creating a boolean variable to keep track of player's turn

        while(player1.position<100 && player2.position<100){

            Player player = isPlayer1Turn?player1:player2;
            System.out.println("Player "+player.playerNumber+" turn");

            player.dieRolls++;

            //Die number player got after rolling the die
            int dieNumber = player.rollTheDie();

            //Getting option for the player
            String playerOption = getOption(player,dieNumber);

            //Reporting each round's data
            printEachRoundData(player, dieNumber, playerOption);
            System.out.println("----------------------------------------------------------");

            if(!playerOption.equals(LADDER_OPTION)){            //Changing turns if player did not get the ladder option
                isPlayer1Turn=!isPlayer1Turn;
            }

        }

        //Reporting total die rolls
        System.out.println("Player 1 total die rolls: "+player1.dieRolls);
        System.out.println("Player 2 total die rolls: "+player2.dieRolls);

        //Reporting winner
        if(player1.position==100){
            System.out.println("Player 1 won");
        }
        else{
            System.out.println("Player 2 won");
        }
          
    }
}
