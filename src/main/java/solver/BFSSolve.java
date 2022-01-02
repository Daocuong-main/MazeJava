package solver;

import main.Maze;
import main.MazeGridPanel;
import util.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static time.WriteExcelFile.writeExcelSol;

public class BFSSolve {
	
	private final Queue<Cell> queue = new LinkedList<>();
	private Cell current;
	private final List<Cell> grid;
	private long startTime;
	private long endTime;
	private long timeElapsed;
	private int size = Maze.size;

	public BFSSolve(List<Cell> grid, MazeGridPanel panel) {
		this.grid = grid;
		current = grid.get(0);
		current.setDistance(0);
		queue.offer(current);
		final Timer timer = new Timer(Maze.speed, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!current.equals(grid.get(grid.size() - 1))) {
					flood();
				} else {
					Maze.solved = true;
					endTime = System.currentTimeMillis();
					timeElapsed = endTime - startTime;
					try {
						writeExcelSol(size, 0, panel.getIndex(), timeElapsed);
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
			current.setPath(true);
			current = current.getParent();
		}
	}
}