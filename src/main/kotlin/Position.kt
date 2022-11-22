class Position {
    lateinit var currentColor: Color
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