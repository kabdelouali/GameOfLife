package org.example;

import java.util.List;

public class Cell {
    private CellStatus status;
    private List<CellStatus> neighbors;

    public Cell(CellStatus status, List<CellStatus> neighbors) {
        this.status = status;
        this.neighbors = neighbors;
    }

    public CellStatus getStatus() {
        return status;
    }

    public Cell setStatus(CellStatus status) {
        this.status = status;
        return this;
    }

    public List<CellStatus> getNeighbors() {
        return neighbors;
    }

    public Cell setNeighbors(List<CellStatus> neighbors) {
        this.neighbors = neighbors;
        return this;
    }
}
