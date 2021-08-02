package triplestep;

class TripleStep {
	private int nSteps;
	private final int[] stepLength = {1, 2, 3};
	
	private int[] waysToStep;
	
	TripleStep(int n) {
		nSteps = n;
		waysToStep = new int[nSteps + 1];
//		you're at the base of stairs
		waysToStep[0] = 1;
	}
	int solve() {
		for (int stair = 0; stair <= nSteps; stair++) {
			for (int length : stepLength) {
				int next = stair + length;
				if (next <= nSteps) {
					waysToStep[next] += waysToStep[stair];
				}
			}
		}
		return waysToStep[nSteps];
	}
}
