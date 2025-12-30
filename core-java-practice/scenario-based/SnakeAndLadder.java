public class SnakeAndLadder {

    static class Player{

        int playerNumber;
        int position;

        public Player(int playerNumber) {
            this.playerNumber= playerNumber;
            position=0;
        }

    }

    public static void main(String[] args) {
        System.out.println("Snake & Ladder Simulator");
        Player player1 = new Player(1);
        System.out.println("Player1's start position: "+player1.position);
    }
}
