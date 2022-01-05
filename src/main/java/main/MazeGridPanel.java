package main;

import generator.*;
import solver.BFSSolve;
import solver.DFSSolve;
import solver.DijkstraSolve;
import util.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazeGridPanel extends JPanel {

    private static final long serialVersionUID = 7237062514425122227L;
    private final List<Cell> grid = new ArrayList<>();
    private List<Cell> currentCells = new ArrayList<>();
    private Integer index;

    public MazeGridPanel(int rows, int cols) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                grid.add(new Cell(x, y));
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Maze.WIDTH + 1, Maze.HEIGHT + 1);
    }

    public Integer getIndex() {
        return this.index;
    }

    public void generate(int index) {
        switch (index) {
            case 0:
                new BinaryTreeGen(grid, this);
                this.index = index;
                break;
            case 1:
                new DFSGen(grid, this);
                this.index = index;
                break;
            case 2:
                new EllersGen(grid, this);
                this.index = index;
                break;
            case 3:
                new KruskalsGen(grid, this);
                this.index = index;
                break;
            case 4:
                new PrimsGen(grid, this);
                this.index = index;
                break;
            default:
                new SidewinderGen(grid, this);
                this.index = index;
                break;
        }
    }

    public void solve(int index) {
        switch (index) {
            case 0:
                new BFSSolve(grid, this);
                break;
            case 1:
                new DFSSolve(grid, this);
                break;
            default:
                new DijkstraSolve(grid, this);
                break;
        }
    }

    public void resetSolution() {
        for (Cell c : grid) {
            c.setDeadEnd(false);
            c.setPath(false);
            c.setDistance(-1);
            c.setParent(null);
        }
        repaint();
    }

    public void setCurrent(Cell current) {
        if (currentCells.isEmpty()) {
            currentCells.add(current);
        } else {
            currentCells.set(0, current);
        }
    }

    public void setCurrentCells(List<Cell> currentCells) {
        this.currentCells = currentCells;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell c : grid) {
            c.draw(g);
        }
        for (Cell c : currentCells) {
            if (c != null) c.displayAsColor(g, Color.RED);
        }
        grid.get(0).displayAsColor(g, Color.GREEN);
        grid.get(grid.size() - 1).displayAsColor(g, Color.YELLOW);
    }
}
