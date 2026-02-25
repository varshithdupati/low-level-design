package Problems.TikTacToe;

import java.util.Scanner;

public class GameManager {
    
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState gameState;

    public GameManager(Player player1, Player player2) {
        board = new Board();
        gameState = new GameState(board);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        resetGame();
        while (!gameState.isGameOver()) {
            board.display();
            System.out.print(currentPlayer.getName() + "'s turn: ");
            String input = scanner.nextLine();
            try {
                int a = Integer.parseInt(input.split(" ")[0]);
                int b = Integer.parseInt(input.split(" ")[1]);
                if (a>=0 && a<board.getSize() && b>=0 && b<board.getSize()) {
                    play(a, b);
                } else {
                    System.out.println("Invalid input. Please enter row and column within bounds.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter row and column separated by space.");
            }
        }
        board.display();
        scanner.close();
    }

    public void play(int row, int col) {

        if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
            if (gameState.checkWin(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " wins!");
            } else if (gameState.isDraw()) {
                System.out.println("It's a draw!");
            } else {
                switchPlayer();
            }
        } else {
            System.out.println("Cell is already occupied. Try again.");
        }

    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void resetGame() {
        board = new Board();
        gameState = new GameState(board);
        currentPlayer = player1;
    }

}
