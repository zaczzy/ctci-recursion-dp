package recursivemultiply;

// used % operation
class MinProductSolution {
	int minProduct(int a, int b) {
		int smaller = a < b ? a : b;
		int larger = a < b ? b : a;
		return recursiveProduct(smaller, larger);
	}
	private int recursiveProduct(int smaller, int larger) {
		if (smaller == 0) return 0;
		if (smaller == 1) return larger;
		int halfProduct = recursiveProduct(smaller >> 1, larger);
		if (smaller % 2 == 1) {
			return halfProduct + halfProduct + larger;
		} else {
			return halfProduct + halfProduct;
		}
	}
}
