package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GameOfLifeConverterTest {

    @Test
    public void shouldReturnDeadWhenOnlyDeadCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.DEAD, Collections.nCopies(8, CellStatus.DEAD));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnAliveWhenExactlyThreeAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.DEAD, Arrays.asList(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.ALIVE, actualCellStatus);
    }

    @Test
    public void shouldReturnDeadWhenLessThanThreeAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.DEAD, Arrays.asList(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnDeadWhenMoreThanThreeAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.DEAD, Arrays.asList(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.DEAD, CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnAliveWhenCellIsAliveAndExactlyTwoAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.ALIVE, Arrays.asList(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.ALIVE, actualCellStatus);
    }

    @Test
    public void shouldReturnDeadWhenCellIsAliveAndOnlyDeadCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.ALIVE, Collections.nCopies(8, CellStatus.DEAD));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnDeadWhenCellIsAliveAndLessThanTwoAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.ALIVE, Arrays.asList(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnDeadWhenCellIsAliveAndMoreThanThreeAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.ALIVE, Arrays.asList(CellStatus.ALIVE, CellStatus.DEAD, CellStatus.ALIVE,
                CellStatus.ALIVE, CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.DEAD, actualCellStatus);
    }

    @Test
    public void shouldReturnAliveWhenCellIsAliveAndExactlyThreeAliveCellsAsNeighbors() {
        Cell cell = new Cell(CellStatus.ALIVE, Arrays.asList(CellStatus.ALIVE, CellStatus.DEAD, CellStatus.DEAD,
                CellStatus.ALIVE, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.ALIVE));
        CellStatus actualCellStatus = GameOfLifeConverter.convert(cell);
        assertEquals(CellStatus.ALIVE, actualCellStatus);
    }
}