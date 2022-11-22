class BoardTools {
    companion object {
        fun printBoard(position: Position) {
            var b = position.board
            var all = ""
            for(y in 7 downTo 0) {
                var line = ""
                for(x in 0..7) {
                    line += when(b[x][y]) {
                        Piece.EMPTY -> "00"
                        Piece.WHITE_PAWN -> "Wp"
                        Piece.WHITE_KING -> "Wk"
                        Piece.WHITE_BISHOPH -> "Wb"
                        Piece.WHITE_KNIGHT -> "WK"
                        Piece.WHITE_QUEEN -> "Wq"
                        Piece.WHITE_ROOK -> "Wr"

                        Piece.BLACK_PAWN -> "Bp"
                        Piece.BLACK_KING -> "Bk"
                        Piece.BLACK_BISHOPH -> "Bb"
                        Piece.BLACK_KNIGHT -> "BK"
                        Piece.BLACK_QUEEN -> "Bq"
                        Piece.BLACK_ROOK -> "Br"

                        else -> {
                            "00"
                        }
                    }
                }
                all += line + "\n"
            }
            println(all)
        }
    }
}