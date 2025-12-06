package game;

public class BadPlayer extends BadTicTacToe {
    public final String name;
    public final char symbol;
    public BadPlayer(String name, char symbol){
        super();
        this.name=name;
        this.symbol=symbol;
    }
    public char getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
}
