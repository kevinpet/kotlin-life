package net.kdpeterson.life

import org.junit.Test

import org.junit.Assert.*

class LifeTest {

    @Test
    fun evolveIsolation() {
        val start = buildBoard(
                0, 0, 0,
                0, 1, 0,
                0, 0, 0)
        val expected = buildBoard(
                0, 0, 0,
                0, 0, 0,
                0, 0, 0)
        assertEquals(expected, Life(start))
    }

    @Test
    fun evolveFull() {
        val start = buildBoard(
                1, 1, 1,
                1, 1, 1,
                1, 1, 1)
        val expected = buildBoard(
                1, 0, 1,
                0, 0, 0,
                1, 0, 1)
        assertEquals(expected, Life(start))
    }

    @Test
    fun evolveBlinker() {
        val start = buildBoard(
                0, 1, 0,
                0, 1, 0,
                0, 1, 0)
        val expected = buildBoard(
                0, 0, 0,
                1, 1, 1,
                0, 0, 0)
        assertEquals(expected, Life(start))
    }

    private fun buildBoard(a: Int, b: Int, c: Int,
                           d: Int, e: Int, f: Int,
                           g: Int, h: Int, i: Int): Board {
        val board = Board(3, 3)
        board[0, 0] = a
        board[1, 0] = b
        board[2, 0] = c
        board[0, 1] = d
        board[1, 1] = e
        board[2, 1] = f
        board[0, 2] = g
        board[1, 2] = h
        board[2, 2] = i
        return board
    }
}