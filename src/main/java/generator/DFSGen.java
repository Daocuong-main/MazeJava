package generator;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

import static writeExcel.WriteExcelFile.writeExcelGen;

public class DFSGen {

    private final Stack<Cell> stack;
    private final List<Cell> grid;
    private Cell current;
    private long startTime;
    private long endTime;
    private long timeElapsed;
    private int size = Maze.size;

    public DFSGen(List<Cell> grid, MazeGridPanel panel) {
        this.grid = grid;
        current = grid.get(0);
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
                        writeExcelGen(size, 2, timeElapsed);
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
        stack = new Stack<>();
    }

    private void carve() {
        current.setVisited(true);
        Cell next = current.getUnvisitedNeighbour(grid);
        if (next != null) {
            stack.push(current);
            current.removeWalls(next);
            current = next;
        } else if (!stack.isEmpty()) {
            try {
                current = stack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}