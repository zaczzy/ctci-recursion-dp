package robotgrid;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class RobotGrid {
	private boolean[][] grid;
	private int row;
	private int col;

	RobotGrid(boolean[][] g) {
		grid = g;
		row = g.length;
		col = g[0].length;
	}

	class Point {
		private int row;
		private int col;

		Point(int r, int c) {
			row = r;
			col = c;
		}

		int getRow() {
			return row;
		}

		int getCol() {
			return col;
		}

		public boolean equals(Object other) {
			if (other.getClass() != Point.class)
				return false;
			Point otherPoint = (Point) other;
			return row == otherPoint.row && col == otherPoint.col;
		}
	}

	/*
	 * Robot start at top left, Point(0, 0) Wants to go to Point(row-1, col-1)
	 */
	ArrayList<Point> getPath() {
		Set<Point> failedPoints = new HashSet<>();
		ArrayList<Point> result = new ArrayList<>();
		if (getPath(result, grid, failedPoints, row - 1, col - 1))
			return result;
		return null;
	}

	boolean getPath(ArrayList<Point> result, boolean[][] grid, Set<Point> failed, int row, int col) {
		if (row < 0 || col < 0 || !grid[row][col]) return false;
		if (failed.contains(new Point(row, col))) return false;
		if (row == 0 && col == 0 || getPath(result, grid, failed, row-1, col) || getPath(result, grid, failed, row, col-1)) {
			result.add(new Point(row, col));
			return true;
		}
		failed.add(new Point(row, col));
		return false;
	}

}
