public class SnakeAndLadder {

    //Player class to create players
    static class Player{

        int playerNumber;
        int position;
        public Player(int playerNumber) {
            this.playerNumber= playerNumber;
            position=0;
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
            position+=dieNumber;
        }
        public void updatePosition(int dieNumber){
            setNewPosition(dieNumber);
        }

    }

    //Initializing options variables
    private static final int LADDER_OPTION = 1;
    private static final int SNAKE_OPTION = -1;
    private static final int NO_PLAY_OPTION = 0;


    //Method to check option
    private static int checkOption(){
        int option = (int)(Math.random()*3) - 1;
        return option;
    }

    //Method to get option
    public static String getOption(Player player, int dieNumber){
        int option = checkOption();
        switch(option){
            case SNAKE_OPTION:
                player.updatePosition(-dieNumber);
                return "Snake";
            case LADDER_OPTION:
                player.updatePosition(dieNumber);
                return "Ladder";
            default:
                return "No Play";
        }
    }

    public static void main(String[] args) {

        System.out.println("Snake & Ladder Simulator");

        Player player1 = new Player(1);
        System.out.println("Player1's start position: "+player1.position);

        int dieNumber = player1.rollTheDie();
        System.out.println("Number player1 got by rolling the die: "+dieNumber);

        String player1Option = getOption(player1,dieNumber);
        System.out.println("Player1 option: "+player1Option);
        System.out.println("Player1's current position: "+player1.position);


    }
}
