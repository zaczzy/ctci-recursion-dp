package parentheses;
import java.util.Set;
import java.util.HashSet;
class Parenthesizer {
	Set<String> getParentheses(int n) {
//		Issue! : duplicates, when adding a parenthesis to "", you get duplicates. It's why we use Set.
//		Idea: find all insert points (points where the prefix is a valid parentheses), then place '(' ')'
//		in any two insert points i, j. i = j allowed.
		HashSet<String> result = new HashSet<>();
		
		return result;
	}
}
