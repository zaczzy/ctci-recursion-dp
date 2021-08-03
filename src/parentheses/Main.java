package parentheses;
import java.util.Set;
import java.util.List;
class Main {

	public static void main(String[] args) {
//		Set<String> result = Parenthesizer.getParentheses(3);
		List<String> result = Parenthesizer.getParenthesesOptimized(3);
		for (String s : result) {
			System.out.println(s);
		}
		
	}

}
