public class Queen extends ChessPiece{
    public Queen (String colour) {
        super(colour);
    }
    @Override
    public String getColour(){
        return this.colour;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public int getMax(int a, int b) {
        return Math.max(a,b);
    }

    public int getMin(int a, int b) {
        return Math.min(a,b);
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (line != toLine && column != toColumn &&
                getMax(line, toLine) - getMin(line, toLine) == getMax(column, toColumn) - getMin(column, toColumn) &&
                checkPos(line) && checkPos(column) && checkPos(toLine) &&
                checkPos(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].colour.equals(this.colour)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }
            if((column == getMin(column,toColumn) && line == getMax(line, toLine)) ||
                    (toColumn ==getMin(column, toColumn) && toLine == getMax(line, toLine))) {
                int fromL = getMax(line, toLine);
                int fromC = getMin(column, toColumn);
                int toL = getMin(line, toLine);
                int toC = getMax(column, toColumn);
                int[][]position = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++) {
                    if (chessBoard.board[fromL - i][fromC + i] == null) {
                        position[i - 1] = new int[]{fromL - i, fromC + i};
                    } else if(!chessBoard.board[fromL - i][fromC = i].colour.equals(this.colour) && fromL - i == toLine) {
                        position[i - 1] = new int[]{fromL - i, fromC + i};
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                int fromL = getMin(line, toLine);
                int fromC = getMin(column, toColumn);
                int toL = getMax(line, toLine);
                int toC = getMin(column, toColumn);
                int[][] position = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++) {
                    if (chessBoard.board[fromL + i][fromC + i] == null) {
                        position[i - 1] = new int[]{fromL + i, fromC + i};
                    } else if(!chessBoard.board[fromL - i][fromC + i].colour.equals(this.colour) && fromL - i == toLine) {
                        position[i - 1] = new int[]{fromL - i, fromC + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        } else if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (column == toColumn) {
                for (int i = getMin(line, toLine); i < getMax(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == getMax(line, toLine)) return false;
                        else if (chessBoard.board[i][column].getColour().equals(this.colour) && i == toLine)
                            return false;
                        else if (!chessBoard.board[i][column].getColour().equals(this.colour) && i == toLine)
                            return true;
                        else if (i != toLine && i != line) return false;
                    }
                }

                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColour().equals(this.colour) && chessBoard.board[toLine][column] != this)
                        return false;
                    else return !chessBoard.board[toLine][column].getColour().equals(this.colour) && chessBoard.board[toLine][column] != this;
                } else return true;
            } else if (line == toLine) {
                for (int i = getMin(toColumn, column); i < getMax(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == getMax(column, toColumn)) return false;
                        else if (chessBoard.board[line][i].getColour().equals(this.colour) && i == toColumn)
                            return false;
                        else if (!chessBoard.board[line][i].getColour().equals(this.colour) && i == toColumn)
                            return true;
                        else if (i != toLine && i != column) return false;
                    }
                }

                if (chessBoard.board[toLine][toColumn] != null) {
                    if (chessBoard.board[toLine][toColumn].getColour().equals(this.colour) && chessBoard.board[toLine][toColumn] != this)
                        return false;
                    else return !chessBoard.board[toLine][toColumn].getColour().equals(this.colour) && chessBoard.board[toLine][toColumn] != this;
                } else return true;
            } else return false;
        } else return false;
    }

}


