//enum -> Game status move type

//design patterns
//singleton for single instance of chessboard
//command pattern for polymorphic Move  class behaviour
//observer pattern to allow Piece to react to changes in state
//state pattern to handle turns
//iterator pattern for traversing turns

public enum GameStatus {

    ACTIVE,
    WHITE_WIN,
    BLACK_WIN,
    DRAW,
    STALEMATE,
    RESIGNATION,
    FORFEIT
}

public enum MoveType {
    NORMAL, 
    CASTLING, 
    EN_PASSANT,
    PROMOTION
}

public enum AccountStatus {
    ACTIVE,
    CLOSED,
    CANCELLED,
    BLACKLISTED,
    NONE
}

//box -> Represents a square on the chessboard, may have a reference to piece and chessboard contains 8X8 array of boxes

public class Box {
    private int x, y;
    private Piece piece;

    public Box(int x, int y, Piece piece) {
        this. x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public Piece getPiece() {return piece;}
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}

public class ChessBoard {
    private Box[][] boxes = new Box[8][8];

    public ChessBoard() {
        for(int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                boxes[i][j] = new Box(i, j, null)
            }
        }
    }

    public Box getBox(int x, int y) {
        return boxes[x][y];
    }

    public Box[][] getBoxes() {
        return boxes;
    }
}

public abstract class Piece {
    private boolean white;
    private boolean killed = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
}

public class King extends Piece {
    public King(boolean white ) {super(white);}
}

public class Queen extends Piece {
    public Queen(boolean white ) {super(white);}
}

public class Rook extends Piece {
    public Rook(boolean white ) {super(white);}
}

public class Bishop extends Piece {
    public Bishop(boolean white ) {super(white);}
}

public class Knight extends Piece {
    public Knight(boolean white ) {super(white);}
}

public class Pawn extends Piece {
    public Pawn(boolean white ) {super(white);}
}


public class Move {
    private Box start;
    private Box end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private Player player;
    private MoveType moveType;

    public Move(Box box, Box end, Piece pieceMoved, Piece pieceKilled, Player player, MoveType moveType) {
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceKilled = pieceKilled;
        this.player = player;
        this.moveType = moveType;
    }

    public Box getStart() {return start;}
    public Box getEnd() {return end;}
    public Piece getPieceMoved() {return pieceMoved;}
    public Piece getPieceKilled() {return pieceKilled;}
    public Player getPlayer() {return player;}
    public MoveType getMoveType() {return moveType;}
}


public class Player {
    private String name;
    private boolean whiteSide;

    public Player(String name, boolean whiteSide) {
        this.name = name;
        this.whiteSide = whiteSide;
    }

    public String getName() {return name;}
    public boolean isWhiteSide() {return whiteSide;};
}

//chess move controller and game view
 
public class ChessMoveController {
    public ChessMoveController() {}
    //in future, add methods

}

public class ChessGameView {
    public ChessGameView() {}
    //in future, add methods
}

//chess game for orchestrating gameplay

public class ChessGame {
    private Player[] players;
    private ChessBoard board;
    private Player currentTurn;
    private GameStatus gameStatus;
    private List<Move> moveHistory;
    private ChessMoveController controller;
    private ChessGameView view;

    public ChessGame(Player white, Player black) {
        this.players = new Player[] {white, black};
        this.board = new ChessBoard();
        this.currentTurn = white;
        this.gameStatus = GameStatus.ACTIVE;
        this.moveHistory = new ArrayList<>();
        this.controller = new ChessMoveController();
        this.view = new ChessGameView();
    }

    public Player[] getPlayers {
        return players;
    }

    public ChessBoard getBoard() {return board;}
    public Player getCurrentTurn() {return currentTurn;}
    public GameStatus getStatus() {return gameStatus;}
    public List<Move> getMoveHistory() {return moveHistory;}
    public ChessMoveController getController() {return controller;}
    public ChessGameView getView() {return view;}

    public void setCurrentTurn(Player player) {
        this.currentTurn = player;
    }

    public void setStatus(GameStatus status) {
        this.gameStatus = status;;
    }

}