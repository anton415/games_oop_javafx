package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenAsPositionWithoutMoveThenGetStartPosition() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell actualPosition = bishopBlack.position();
        assertThat(actualPosition, is(startPosition));
    }

    @Test
    public void whenCopyThenGetTheFinishPosition() {
        Cell startPosition = Cell.A1;
        Cell finishPosition = Cell.B2;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell actualPosition = bishopBlack.copy(finishPosition).position();
        assertThat(actualPosition, is(finishPosition));
    }

    @Test
    public void whenWayThenReturnArrayOfAllWalkedCells() {
        Cell[] expectedWalkedCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actualWalkedCells = bishopBlack.way(Cell.G5);
        assertThat(actualWalkedCells, is(expectedWalkedCells));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenTryMoveNotDiagonalThenException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C2);
    }
}