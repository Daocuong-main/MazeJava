package solver;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

import static main.Maze.size;
import static time.WriteExcelFile.writeExcel;

// Basically a greedy dijkstra's that follows a path until it hits a dead end instead of prioritising the 
// closest cell to the goal.

public class DFSSolve {

	private final Stack<Cell> path = new Stack<>();
	private Cell current;
	private final List<Cell> grid;
	private long startTime;
	private long endTime;
	private long timeElapsed;

	public DFSSolve(List<Cell> grid, MazeGridPanel panel) {
		this.grid = grid;
		current = grid.get(0);
		final Timer timer = new Timer(Maze.speed, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!current.equals(grid.get(grid.size() - 1))) {
					path();
				} else {
					Maze.solved = true;
					endTime = System.currentTimeMillis();
					timeElapsed = endTime - startTime;
					try {
						writeExcel(size,10, timeElapsed);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					drawPath();
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

	private void path() {
		current.setDeadEnd(true);
		Cell next = current.getPathNeighbour(grid);
		if (next != null) {
			path.push(current);
			current = next;
		} else if (!path.isEmpty()) {
			try {
				current = path.pop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void drawPath() {
		while (!path.isEmpty()) {
			try {
				path.pop().setPath(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}