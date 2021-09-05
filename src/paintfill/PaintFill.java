package paintfill;

class PaintFill {
	boolean paintFill(Color[][] screen, int r, int c, Color newColor) {
		if (screen[r][c] == newColor) return false;
		return paintFill(screen, r, c, screen[r][c], newColor);
	}
	private boolean paintFill(Color[][] screen, int r, int c, Color color, Color newColor) {
		if (r<0 || r >= screen.length || c < 0 || c >= screen[0].length) {
			return false;
		}
		if (screen[r][c] == color) {
			screen[r][c] = newColor;
			paintFill(screen, r-1, c, color, newColor);
			paintFill(screen, r + 1, c, color, newColor);
			paintFill(screen, r, c - 1, color, newColor);
			paintFill(screen, r, c + 1, color, newColor);
		}
//		if screen[r][c] is not the old color, it's vacantly true
		return true;
	}
}
