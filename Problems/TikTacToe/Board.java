package Problems.TikTacToe;

public class Board {
    
    private Symbol[][] board;
    private int size;

    public Board() {
        size = 3;
        board = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (board[row][col] == Symbol.EMPTY) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public Symbol getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getDisplayValue());
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 1; k < 2*size; k++) {
                    if(k%2==0)
                        System.out.print("|");
                    else
                        System.out.print("-");
                }
                System.out.println();
            }
        }
    }

}
