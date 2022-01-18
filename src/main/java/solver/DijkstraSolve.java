package solver;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static writeExcel.WriteExcelFile.*;

public class DijkstraSolve {

    private final Queue<Cell> queue;
    private final List<Cell> grid;
    private Cell current;
    private long startTime;
    private long endTime;
    private long timeElapsed;
    private int size = Maze.size;
    private int numberOfCellPath = 1;
    private int numberOfCellVisited = 0;

    public DijkstraSolve(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        queue = new PriorityQueue<>(new CellDistanceFromGoalComparator());
        current = grid.get(0);
        current.setDistance(0);
        queue.offer(current);
        final Timer timer = new Timer(Maze.speed, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!current.equals(grid.get(grid.size() - 1))) {
                    numberOfCellVisited++;
                    flood();
                } else {
                    Maze.solved = true;
                    endTime = System.currentTimeMillis();
                    timeElapsed = endTime - startTime;
                    try {
                        writeExcelSol(size, 2, panel.getIndex(), timeElapsed);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    drawPath();
                    try {
                        writeExcelNumberOfCellPath(size, panel.getIndex(), numberOfCellPath);
                        writeExcelNumberOfCellVisited(size, panel.getIndex(), numberOfCellVisited);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(numberOfCellVisited);
                    timer.stop();
                }
                panel.setCurrent(current);
                panel.repaint();
                timer.setDelay(Maze.speed);
            }
        });
        timer.start();
        startTime = System.currentTimeMillis();
    }

    private void flood() {
        current.setDeadEnd(true);
        current = queue.poll();
        List<Cell> adjacentCells = current.getValidMoveNeighbours(grid);
        for (Cell c : adjacentCells) {
            if (c.getDistance() == -1) {
                c.setDistance(current.getDistance() + 1);
                c.setParent(current);
                queue.offer(c);
            }
        }
    }

    private void drawPath() {
        while (current != grid.get(0)) {
            numberOfCellPath++;
            current.setPath(true);
            current = current.getParent();
        }
    }

    private class CellDistanceFromGoalComparator implements Comparator<Cell> {
        Cell goal = grid.get(grid.size() - 1);

        @Override
        public int compare(Cell arg0, Cell arg1) {
            if (getDistanceFromGoal(arg0) > getDistanceFromGoal(arg1)) {
                return 1;
            } else {
                return getDistanceFromGoal(arg0) < getDistanceFromGoal(arg1) ? -1 : 0;
            }
        }

        private double getDistanceFromGoal(Cell c) {
            return Math.hypot(c.getX() - goal.getX(), c.getY() - goal.getY());
        }
    }
}