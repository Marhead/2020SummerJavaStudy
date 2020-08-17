package com.chess.engine.player;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public class MoveTransition {

    private final Board trasitionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition(final Board trasitionBoard, final Move move, final MoveStatus moveStatus) {
        this.trasitionBoard = trasitionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }

    public MoveStatus getMoveStatus() {
        return this.moveStatus;
    }
}
