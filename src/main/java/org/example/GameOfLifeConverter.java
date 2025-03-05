package org.example;

public class GameOfLifeConverter {

    public static CellStatus convert(Cell cell) {
        long aliveNeighbors = countAliveNeighbors(cell);
//        switch (cell.getStatus()) {
//            case DEAD ->
//        }
        if (cell.getStatus() == CellStatus.ALIVE) {
            if (aliveNeighbors == 2 || aliveNeighbors == 3)
                return CellStatus.ALIVE;
            return CellStatus.DEAD;
        }
        if (aliveNeighbors == 3)
            return CellStatus.ALIVE;
        return CellStatus.DEAD;
    }

    private static long countAliveNeighbors(Cell cell) {
        return cell.getNeighbors().stream().filter((status) -> status == CellStatus.ALIVE).count();
    }
}