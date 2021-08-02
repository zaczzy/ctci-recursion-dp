package recursivemultiply;

// can i use & operation?
class MinProductMyBinary {
	int minProduct(int a, int b) {
		int smaller = a < b ? a : b;
		int larger = a < b ? b : a;
		return solve(smaller, larger, 0);
	}
	private int solve(int smaller, int larger, int power) {
		if (smaller == 0) return 0;
		if (smaller == 1) return larger << power;
		int result = 0;
		if ((smaller & 1) == 1) {
			result += larger << power;
		}
		return result + solve(smaller >> 1, larger, power + 1);
	}
}
