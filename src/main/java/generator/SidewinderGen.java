package generator;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static time.WriteExcelFile.writeExcelGen;

public class SidewinderGen {

    private final List<Cell> grid;
    private final List<Cell> run = new ArrayList<>();
    private final Random r = new Random();
    private Cell current;
    private int index;
    private long startTime;
    private long endTime;
    private long timeElapsed;
    private int size = Maze.size;

    public SidewinderGen(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        index = 0;
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
                        writeExcelGen(size, 6, timeElapsed);
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
        current.setVisited(true);
        Cell bottom = current.getBottomNeighbour(grid);
        Cell left = current.getLeftNeighbour(grid);
        if (left == null) {
            if (bottom != null) {
                current.removeWalls(bottom);
            }
        } else {
            run.add(current);
            if (bottom != null && r.nextBoolean()) {
                current.removeWalls(bottom);
            } else {
                current = run.get(r.nextInt(run.size()));
                left = current.getLeftNeighbour(grid);
                if (left != null) {
                    current.removeWalls(left);
                }
                run.clear();
            }
        }
        if (grid.size() - 1 >= index + 1) {
            current = grid.get(++index);
        }
    }
}