public class King extends ChessPiece {
    public King (String colour) {
        super(colour);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
    @Override
    public String getColour() {
        return colour;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if(Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;
            if(isUnderAttack(chessBoard, toLine, toColumn)) return false;
            if(chessBoard.board[toLine][toColumn] !=null) {
                return !chessBoard.board[toLine][toColumn].getColour().equals(colour);
            }
            return true;
        } else return false;
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if(checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColour().equals(colour) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
}
