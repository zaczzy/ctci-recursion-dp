package permutations_without_dups;

import java.util.ArrayList;

class PermutationOfUniqueCharacters {
	ArrayList<String> getPerms(String str) {
		ArrayList<String> result = new ArrayList<>();
		getPerms("", str, result);
		return result;
	}

	void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
			result.add(prefix);
			return;
		}

		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}
}
