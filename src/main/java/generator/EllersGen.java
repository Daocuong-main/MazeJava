package generator;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;
import util.DisjointSets;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import static writeExcel.WriteExcelFile.writeExcelGen;

public class EllersGen {

    private static final int COLS = Math.floorDiv(Maze.WIDTH, Maze.W);
    private final List<Cell> grid;
    private final DisjointSets disjointSet = new DisjointSets();
    private List<Cell> currentCol;
    private int fromIndex, toIndex;
    private boolean genNextCol = true;
    private long startTime;
    private long endTime;
    private long timeElapsed;
    private int size = Maze.size;

    public EllersGen(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        fromIndex = 0;
        toIndex = COLS;
        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).setId(i);
            disjointSet.create_set(grid.get(i).getId());
        }
        final Timer timer = new Timer(Maze.speed, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (genNextCol) {
                    currentCol = grid.subList(fromIndex, toIndex);
                    fromIndex = toIndex;
                    toIndex += COLS;
                    new ColumnGen(currentCol, panel);
                } else if (grid.parallelStream().allMatch(c -> c.isVisited())) {
                    Maze.generated = true;
                    timer.stop();
                    endTime = System.currentTimeMillis();
                    timeElapsed = endTime - startTime;
                    try {
                        writeExcelGen(size, 3, timeElapsed);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        timer.start();
        startTime = System.currentTimeMillis();
    }

    private class ColumnGen {

        private final Queue<Cell> carveDownQueue = new LinkedList<>();
        private final Queue<Cell> carveRightQueue = new LinkedList<>();
        private final List<Cell> col;
        private final Random r = new Random();
        private Cell current;

        private ColumnGen(List<Cell> col, MazeGridPanel panel) {
            genNextCol = false;
            this.col = col;
            carveDownQueue.addAll(col);
            carveRightQueue.addAll(col);
            final Timer timer = new Timer(Maze.speed, null);
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!carveDownQueue.isEmpty()) {
                        carveDown();
                    } else if (!carveRightQueue.isEmpty()) {
                        carveRight();
                    } else {
                        current = null;
                        genNextCol = true;
                        timer.stop();
                    }
                    panel.setCurrent(current);
                    panel.repaint();
                    timer.setDelay(Maze.speed);
                }
            });
            timer.start();
        }

        private void carveDown() {
            current = carveDownQueue.poll();
            current.setVisited(true);
            if (r.nextBoolean() || col.contains(grid.get(grid.size() - 1))) { // or last column
                Cell bottom = current.getBottomNeighbour(grid);
                if (bottom != null) {
                    if (disjointSet.find_set(current.getId()) != disjointSet.find_set(bottom.getId())) {
                        current.removeWalls(bottom);
                        disjointSet.union(current.getId(), bottom.getId());
                    }
                }
            }
        }

        private void carveRight() {
            Cell c = carveRightQueue.poll();
            List<Cell> cells = new ArrayList<>();
            for (Cell c2 : col) {
                if (disjointSet.find_set(c.getId()) == disjointSet.find_set(c2.getId())) {
                    cells.add(c2);
                }
            }
            Collections.shuffle(cells);
            Cell c3 = cells.get(0);
            Cell right = c3.getRightNeighbour(grid);
            if (right != null) {
                current = right;
                right.setVisited(true);
                c3.removeWalls(right);
                disjointSet.union(c3.getId(), right.getId());
            }
        }
    }
}