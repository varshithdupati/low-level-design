package Problems.TikTacToe;

import java.util.Scanner;

public class TikTacToeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1Name, player2Name;
        System.out.print("Enter name for Player 1 (X): ");
        player1Name = scanner.nextLine();
        System.out.print("Enter name for Player 2 (O): ");
        player2Name = scanner.nextLine();
        GameManager game = new GameManager(new Player(player1Name, Symbol.X), new Player(player2Name, Symbol.O));
        game.start();
        scanner.close();
    }
}
