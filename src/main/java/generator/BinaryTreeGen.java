package generator;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static main.Maze.size;
import static time.WriteExcelFile.writeExcel;

public class BinaryTreeGen {

    private final List<Cell> grid;
    private final Random r = new Random();
    private Cell current;
    private int index;
    private long startTime;
    private long endTime;
    private long timeElapsed;


    public BinaryTreeGen(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        index = grid.size() - 1;
        current = grid.get(index);
        final Timer timer = new Timer(Maze.speed, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!grid.parallelStream().allMatch(c -> c.isVisited())) {
                    carve();
                } else {
                    current = null;
                    Maze.generated = true;
                    timer.stop();
                    endTime = System.currentTimeMillis();
                    timeElapsed = endTime - startTime;
                    try {
                        writeExcel(size,1, timeElapsed);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                panel.setCurrent(current);
                panel.repaint();
                timer.setDelay(Maze.speed);
            }
        });
        timer.start();
        startTime = System.currentTimeMillis();
    }

    private void carve() {
        boolean topNeigh = grid.contains(new Cell(current.getX(), current.getY() - 1));
        boolean leftNeigh = grid.contains(new Cell(current.getX() - 1, current.getY()));
        if (topNeigh && leftNeigh) {
            carveDirection(r.nextInt(2));
        } else if (topNeigh) {
            carveDirection(0);
        } else if (leftNeigh) {
            carveDirection(1);
        }

        current.setVisited(true);


        if (index - 1 >= 0) {
            current = grid.get(--index);
        }
        // else we break out of if statement in timer Action Listener and set maze to generated.

    }

    // 0 down
    // 1 right
    private void carveDirection(int dir) {
        if (dir == 0) {
            List<Cell> neighs = current.getAllNeighbours(grid);
            for (Cell c : neighs) {
                if (c.getY() + 1 == current.getY()) current.removeWalls(c);
            }
        } else {
            List<Cell> neighs = current.getAllNeighbours(grid);
            for (Cell c : neighs) {
                if (c.getX() + 1 == current.getX()) current.removeWalls(c);
            }
        }
    }
}