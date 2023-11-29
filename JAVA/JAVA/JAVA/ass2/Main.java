public class Main {
    public static void main(String[] args) {
        
        CricketPlayer[] players = new CricketPlayer[5];
        players[0] = new CricketPlayer("Player 1", 20, 3, 800);
        players[1] = new CricketPlayer("Player 2", 25, 2, 1200);
        players[2] = new CricketPlayer("Player 3", 15, 1, 500);
        players[3] = new CricketPlayer("Player 4", 30, 5, 1500);
        players[4] = new CricketPlayer("Player 5", 10, 0, 250);

     
        for (CricketPlayer player : players) {
            System.out.println(player);
        }

        CricketPlayer.sort(players);

       
        System.out.println("\nPlayer details in sorted order:");
        for (CricketPlayer player : players) {
            System.out.println(player);
        }
    }
}
