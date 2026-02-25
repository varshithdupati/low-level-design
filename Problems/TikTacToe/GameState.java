package Problems.TikTacToe;

public class GameState {
    private Board board;
    private int size;
    private boolean isGameOver;

    public GameState(Board board) {
        this.board = board;
        this.size = board.getSize();
        this.isGameOver = false;
    }

    public boolean checkWin(Symbol symbol) {
        // Check rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                isGameOver = true;
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                isGameOver = true;
                return true;
            }
        }

        // Check diagonals
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != symbol) {
                win = false;
                break;
            }
        }
        if (win) {
            isGameOver = true;
            return true;
        }

        win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i) != symbol) {
                win = false;
                break;
            }
        }
        if (win) {
            isGameOver = true;
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        isGameOver = true;
        return true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

}
