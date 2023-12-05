public abstract class ChessPiece {
    String colour;
    boolean check = true;

    public ChessPiece(String colour) {
        this.colour = colour;
    }

    public abstract String getColour();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
}