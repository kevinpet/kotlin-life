package net.kdpeterson.life

import java.util.*

class Board(val width: Int, val height: Int, val states: Int = 2, val offboard: Int = 0) {
    val cells = IntArray(height * width)
    operator fun get(x: Int, y: Int): Int {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return offboard
        }
        return cells[y * width + x]
    }

    operator fun set(x: Int, y: Int, state: Int) {
        cells[y * width + x] = state;
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Board

        if (width != other.width) return false
        if (height != other.height) return false
        if (states != other.states) return false
        if (offboard != other.offboard) return false
        if (!Arrays.equals(cells, other.cells)) return false

        return true
    }

    override fun hashCode(): Int{
        var result = width
        result += 31 * result + height
        result += 31 * result + states
        result += 31 * result + offboard
        result += 31 * result + Arrays.hashCode(cells)
        return result
    }

    override fun toString(): String{
        return "$width x $height, $states states, $offboard for offboard, cells=${Arrays.toString(cells)}"
    }


}