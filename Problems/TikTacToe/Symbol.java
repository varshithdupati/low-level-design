package Problems.TikTacToe;

public enum Symbol {

    X("X"),
    O("O"),
    EMPTY(" ");

    private final String displayValue;

    Symbol(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}