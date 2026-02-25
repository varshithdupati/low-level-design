package Problems.TikTacToe;

public class Player {
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        if(symbol == null || symbol == Symbol.EMPTY) {
            throw new IllegalArgumentException("Player symbol cannot be null or empty");
        }
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
