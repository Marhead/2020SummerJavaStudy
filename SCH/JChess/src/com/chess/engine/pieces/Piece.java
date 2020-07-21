package com.chess.engine.pieces;

public class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    Piece(final int piecePosition piecePosition, final Alliance pieceAlliance) {
        this.pieceAliiance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

}
