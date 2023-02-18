import java.util.Random;
import java.util.Scanner;

public class rockPaperScissorsGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] moves = {"rock", "paper", "scissors"};

        System.out.println("Choose rock,paper or scissors:");
        String playerMove = scanner.nextLine();
        int computerWins = 0;
        int playerWins = 0;
        int draws = 0;
        label:
        while (true) {
            switch (playerMove) {
                case "rock":
                    playerMove = "rock";
                    break;
                case "paper":
                    playerMove = "paper";
                    break;
                case "scissors":
                    playerMove = "scissors";
                    break;
                default:
                    System.out.println("Invalid Input.Try Again...");
                    break label;
            }
            String computerMove = getRandomWord(moves);
            String draw = "";
            if (whoIsWinning(playerMove, computerMove, draw).equals(playerMove)) {
                System.out.println("You win!");
                playerWins++;
                System.out.printf("Draws:%d Player Wins:%d  Computer Wins:%s%n", draws, playerWins, computerWins);
            }
            if (whoIsWinning(playerMove, computerMove, draw).equals(computerMove)) {
                System.out.println("You lose!");
                computerWins++;
                System.out.printf("Draws:%d Player Wins:%d  Computer Wins:%s%n", draws, playerWins, computerWins);
            }
            if (whoIsWinning(playerMove, computerMove, draw).equals(draw)) {
                System.out.println("The game is draw!");
                draws++;
                System.out.printf("Draws:%d Player Wins:%d  Computer Wins:%s%n", draws, playerWins, computerWins);
            }

            System.out.println("If you want stop playing write Yes.");
            String respond = scanner.nextLine();
            if (respond.equals("Yes")) {
                return;
            }

        }

    }

    public static String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    public static String whoIsWinning(String playerMove, String computerMove, String draw) {
        String winningMove = "";
        switch (computerMove) {
            case "rock" -> {
                switch (playerMove) {
                    case "paper" -> winningMove = playerMove;
                    case "scissors" -> winningMove = computerMove;
                    case "rock" -> winningMove = draw;
                }
            }
            case "paper" -> {
                switch (playerMove) {
                    case "paper" -> winningMove = draw;
                    case "scissors" -> winningMove = playerMove;
                    case "rock" -> winningMove = computerMove;
                }
            }
            case "scissors" -> {
                switch (playerMove) {
                    case "paper" -> winningMove = computerMove;
                    case "scissors" -> winningMove = draw;
                    case "rock" -> winningMove = playerMove;
                }
            }
        }

        return winningMove;
    }
}



