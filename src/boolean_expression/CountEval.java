package boolean_expression;

class CountEval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int countEval (String s, boolean result) {
		if(s.length() == 0) return 0;
		if(s.length() == 1) return stringToBool(s) == result ? 1: 0;
		
		int ways = 0;
		for (int i=1; i < s.length(); i+=2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i+1, s.length());
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			int total  = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if(c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue  + leftTrue * rightFalse;
			}
//			select based on result true or false
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		return ways;
	}
	boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}
}
