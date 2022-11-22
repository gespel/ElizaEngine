fun main(args: Array<String>) {
    println("Hello World!")
    var sp = Position()
    var mg = MoveGenerator()

    sp.setPiece(Piece.WHITE_KNIGHT, 3, 3)
    //sp.setPiece(Piece.BLACK_PAWN, 0, 2)
    //sp.setPiece(Piece.BLACK_PAWN, 2, 2)
    mg.generatePossibleMoves(sp)

    //BoardTools.printBoard(sp)

    for(p in sp.moves) {
        //mg.generatePossibleMoves(p)
        BoardTools.printBoard(p)
        //for(p2 in p.moves) {
        //    BoardTools.printBoard(p2)
        //}
    }
}