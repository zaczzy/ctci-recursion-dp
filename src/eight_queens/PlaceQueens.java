package eight_queens;
import java.util.ArrayList;
class PlaceQueens {
	static int GRID_SIZE = 8;
	static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
	private static boolean checkValid(Integer[] columns, int row, int col) {
		for (int row2 = 0; row2 < row; row2++) {
			int column2 = columns[row2];
			if (col == column2) {
				return false;
			}
			int columnDistance = Math.abs(column2 - col);
			int rowDistance = row - row2;
			if (rowDistance == columnDistance) return false;
		}
		return true;
	}
}
