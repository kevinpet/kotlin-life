package net.kdpeterson.life

object Life {
    operator fun invoke(board: Board): Board {
        val nextBoard = Board(board.width, board.height)
        for (y in 0..board.height - 1) {
            for (x in 0..board.width - 1) {
                nextBoard[x, y] = evolve(board, x, y)
            }
        }
        return nextBoard
    }

    fun evolve(board: Board, x: Int, y: Int): Int {
        val surrounding = board[x-1, y-1] +
                board[x-1, y] +
                board[x-1, y+1] +
                board[x, y-1] +
                board[x, y+1] +
                board[x+1, y-1] +
                board[x+1, y] +
                board[x+1, y+1]
        return when (surrounding) {
            2 -> board[x, y]
            3 -> 1
            else -> 0
        }
    }
}