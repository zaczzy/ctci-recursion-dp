package parentheses;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.StringBuilder;

class Parenthesizer {
	static Set<String> getParentheses(int n) {
//		Issue! : duplicates, when adding a parenthesis to "", you get duplicates. It's why we use Set.
//		Idea: find all insert points (points where the prefix is a valid parentheses), then place '(' ')'
//		in any two insert points i, j. i = j allowed.
		HashSet<String> result = new HashSet<>();
//		Solution idea: insert a parentheses in every pair of existing parentheses or at the beginning.
//		I will copy the solution here.
		if (n == 0) {
			result.add("");
		} else {
			Set<String> prev = getParentheses(n - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						result.add(s);
					}
				}
				result.add("()" + str);
			}
		}
		return result;
	}

	private static String insertInside(String str, int i) {
		StringBuilder s = new StringBuilder(str);
		s.insert(i + 1, "()");
		return s.toString();
	}

	static List<String> getParenthesesOptimized(int n) {
		char[] str = new char[n * 2];
		ArrayList<String> list = new ArrayList<>();
		addParen(list, n, n, str, 0);
		return list;
	}

	private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem)
			return;
		if (leftRem == 0 && rightRem == 0) {
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '(';
			addParen(list, leftRem - 1, rightRem, str, index + 1);
			str[index] = ')';
			addParen(list, leftRem, rightRem - 1, str, index + 1);
		}
	}
}
