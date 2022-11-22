import java.lang.Exception

enum class Piece {
    WHITE_PAWN, WHITE_BISHOPH, WHITE_KNIGHT, WHITE_ROOK, WHITE_QUEEN, WHITE_KING,
    BLACK_PAWN, BLACK_BISHOPH, BLACK_KNIGHT, BLACK_ROOK, BLACK_QUEEN, BLACK_KING,
    EMPTY
}
enum class Color {
    BLACK, WHITE
}

class Position() {
    var board: Array<Array<Piece>> = Array(8) {
        Array(8) {
            Piece.EMPTY
        }
    }
    var moves = mutableSetOf<Position>()
    fun setPiece(p: Piece, x: Int, y: Int) {
        this.board[x][y] = p
    }
    fun addPossiblePosition(p: Position) {
        moves.add(p)
    }
}

class MoveGenerator(var startPosition: Position) {

    fun generatePossibleMoves() {
        for(x in 0..7) {
            for(y in 0..7) {
                val currBoard = this.startPosition.board

                if(currBoard[x][y] == Piece.WHITE_PAWN) {
                    if(y+1 <= 7) {
                        if(x-1 >= 0) {
                            if(getColor(this.startPosition, x-1, y+1) == Color.BLACK) {
                                startPosition.addPossiblePosition(
                                    doMove(startPosition, x, y, x-1, y+1)
                                )
                            }
                        }
                        if(x+1 <= 7) {
                            if(getColor(this.startPosition, x+1, y+1) == Color.BLACK) {
                                startPosition.addPossiblePosition(
                                    doMove(startPosition, x, y, x+1, y+1)
                                )
                            }
                        }
                        if(currBoard[x][y+1] == Piece.EMPTY) {
                            startPosition.addPossiblePosition(
                                doMove(startPosition, x, y, x, y+1)
                            )
                        }
                    }
                    if(y+2 <= 7) {
                        if(currBoard[x][y+2] == Piece.EMPTY) {
                            startPosition.addPossiblePosition(
                                doMove(startPosition, x, y, x, y+2)
                            )
                        }
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