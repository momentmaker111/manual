import java.util.Scanner;

// ===================== PIECE (Abstraction + Encapsulation) =====================
abstract class Piece {
    private boolean isWhite;
    private boolean hasMoved;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        this.hasMoved = false;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }

    // Polymorphism
    public abstract boolean canMove(Board board, Spot start, Spot end);

    // Polymorphism
    public abstract char getSymbol();
}

// ===================== KING =====================
class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());

        if (dx > 1 || dy > 1)
            return false;

        return Board.destinationOk(this, end);
    }

    @Override
    public char getSymbol() {
        return isWhite() ? 'K' : 'k';
    }
}

// ===================== QUEEN =====================
class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        boolean straight =
                (start.getX() == end.getX() ||
                 start.getY() == end.getY());

        boolean diagonal =
                Math.abs(start.getX() - end.getX()) ==
                Math.abs(start.getY() - end.getY());

        if (!straight && !diagonal)
            return false;

        if (!board.isPathClear(start, end))
            return false;

        return Board.destinationOk(this, end);
    }

    @Override
    public char getSymbol() {
        return isWhite() ? 'Q' : 'q';
    }
}

// ===================== ROOK =====================
class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if (start.getX() != end.getX() &&
            start.getY() != end.getY())
            return false;

        if (!board.isPathClear(start, end))
            return false;

        return Board.destinationOk(this, end);
    }

    @Override
    public char getSymbol() {
        return isWhite() ? 'R' : 'r';
    }
}
