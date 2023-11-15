import java.util.Arrays;

public class CricketPlayer {
    String name;
    int no_of_innings;
    int no_of_times_notout;
    int totalruns;
    double bat_avg;

    // Constructor
    public CricketPlayer(String name, int no_of_innings, int no_of_times_notout, int totalruns) {
        this.name = name;
        this.no_of_innings = no_of_innings;
        this.no_of_times_notout = no_of_times_notout;
        this.totalruns = totalruns;
        this.bat_avg = avg(this.totalruns, this.no_of_innings);
    }

    // Static method to calculate average
    public static double avg(int totalruns, int no_of_innings) {
        return (double) totalruns / no_of_innings;
    }

    // Method to print player details
    public String toString() {
        return "Name: " + this.name + ", Batting Average: " + this.bat_avg;
    }

    public static void main(String[] args) {
        // Create an array of n player objects
        CricketPlayer[] players = {
            new CricketPlayer("Player1", 10, 2, 500),
            new CricketPlayer("Player2", 15, 3, 700),
            new CricketPlayer("Player3", 12, 1, 450)
        };

        // Sort the players array based on batting average
        Arrays.sort(players, (player1, player2) -> Double.compare(player2.bat_avg, player1.bat_avg));

        // Display the player details in sorted order
        for (CricketPlayer player : players) {
            System.out.println(player);
        }
    }
}
