public class Pawn extends ChessPiece {
    public Pawn (String colour) {
        super(colour);
    }
    @Override
    public String getColour() {
        return this.colour;
    }
    @Override
    public String getSymbol() {
        return "P";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column == toColumn) {
                int dir;
                int start;

                if (colour.equals("white")) {
                    dir = 1;
                    start = 1;
                } else {
                    dir = -1;
                    start = 6;
                }
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }

                if (line == start && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
                }
            } else {
                if((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) &&
                chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColour().equals(colour);
                } else return false;
            }
        }
        return false;
    }
}
