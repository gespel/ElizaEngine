import java.lang.Exception

class MoveGenerator() {

    fun generatePossibleMoves(position: Position) {
        for(x in 0..7) {
            for(y in 0..7) {
                val currBoard = position.board
                if(position.currentColor == Color.WHITE) {
                    if (currBoard[x][y] == Piece.WHITE_PAWN) {
                        if (y + 1 <= 7) {
                            if (x - 1 >= 0) {
                                if (getColor(position, x - 1, y + 1) == Color.BLACK) {
                                    position.addPossiblePosition(
                                        doMove(position, x, y, x - 1, y + 1)
                                    )
                                }
                            }
                            if (x + 1 <= 7) {
                                if (getColor(position, x + 1, y + 1) == Color.BLACK) {
                                    position.addPossiblePosition(
                                        doMove(position, x, y, x + 1, y + 1)
                                    )
                                }
                            }
                            if (currBoard[x][y + 1] == Piece.EMPTY) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x, y + 1)
                                )
                            }
                        }
                        if (y == 1) {
                            if (currBoard[x][y + 2] == Piece.EMPTY) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x, y + 2)
                                )
                            }
                        }
                    }
                    //========================================================================================
                    if (currBoard[x][y] == Piece.WHITE_KNIGHT) {
                        println("CALL")
                        if (x + 2 <= 7 && y + 1 <= 7) {
                            if (getColor(position, x + 2, y + 1) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x + 2, y + 1)
                                )
                            }
                        }
                        if (x + 1 <= 7 && y + 2 <= 7) {
                            if (getColor(position, x + 1, y + 2) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x + 1, y + 2)
                                )
                            }
                        }
                        if (x - 2 >= 0 && y + 1 <= 7) {
                            if (getColor(position, x - 2, y + 1) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x - 2, y + 1)
                                )
                            }
                        }
                        if (x - 1 >= 0 && y + 2 <= 7) {
                            if (getColor(position, x - 1, y + 2) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x - 1, y + 2)
                                )
                            }
                        }
                        if (x + 2 <= 7 && y - 1 >= 0) {
                            if (getColor(position, x + 2, y - 1) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x + 2, y - 1)
                                )
                            }
                        }
                        if (x + 1 <= 7 && y - 2 >= 0) {
                            if (getColor(position, x + 1, y - 2) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x + 1, y - 2)
                                )
                            }
                        }
                        if (x - 2 >= 0 && y - 1 >= 0) {
                            if (getColor(position, x - 2, y - 1) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x - 2, y - 1)
                                )
                            }
                        }
                        if (x - 1 >= 0 && y - 2 >= 0) {
                            if (getColor(position, x - 1, y - 2) != Color.WHITE) {
                                position.addPossiblePosition(
                                    doMove(position, x, y, x - 1, y - 2)
                                )
                            }
                        }
                        //========================================================================================
                    }
                }
            }
        }
    }
    fun doMove(pos: Position, x_old: Int, y_old: Int, x_new: Int, y_new: Int): Position {
        val newposition: Position = Position()

        for(x in 0..7) {
            for(y in 0..7) {
                var pieceType: Piece
                newposition.setPiece(pos.board[x][y], x, y)
            }
        }


        newposition.board[x_new][y_new] = newposition.board[x_old][y_old]
        newposition.board[x_old][y_old] = Piece.EMPTY
        return  newposition
    }
    fun getColor(pos: Position, x: Int, y: Int): Color? {
        when(pos.board[x][y]) {
            Piece.WHITE_QUEEN -> return Color.WHITE
            Piece.WHITE_ROOK -> return Color.WHITE
            Piece.WHITE_KNIGHT -> return Color.WHITE
            Piece.WHITE_KING -> return Color.WHITE
            Piece.WHITE_BISHOPH -> return Color.WHITE
            Piece.WHITE_PAWN -> return Color.WHITE

            Piece.BLACK_ROOK -> return Color.BLACK
            Piece.BLACK_QUEEN -> return Color.BLACK
            Piece.BLACK_KNIGHT -> return Color.BLACK
            Piece.BLACK_BISHOPH -> return Color.BLACK
            Piece.BLACK_KING -> return Color.BLACK
            Piece.BLACK_PAWN -> return Color.BLACK

            else -> {
                return null
            }
        }
    }
}