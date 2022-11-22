fun main(args: Array<String>) {
    println("Hello World!")
    var sp = Position()
    var mg = MoveGenerator(sp)

    sp.setPiece(Piece.WHITE_PAWN, 1, 1)
    sp.setPiece(Piece.BLACK_PAWN, 0, 2)
    sp.setPiece(Piece.BLACK_PAWN, 2, 2)
    mg.generatePossibleMoves()

    BoardTools.printBoard(sp)

    for(p in sp.moves) {
        BoardTools.printBoard(p)
    }
}