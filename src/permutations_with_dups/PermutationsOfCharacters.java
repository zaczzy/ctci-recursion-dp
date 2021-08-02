package permutations_with_dups;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class PermutationsOfCharacters {
	ArrayList<String> getPerms(String s) {
		ArrayList<String> result = new ArrayList<>();
		Map<Character, Integer> map = buildFreqTable(s);
		getPerms(map, "", s.length(), result);
		return result;
	}

	HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> result = new HashMap<>();
		for (char c : s.toCharArray()) {
			result.put(c, result.getOrDefault(c, 0) + 1);
		}
		return result;
	}

	void getPerms(Map<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		for (char c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c, count - 1);
				getPerms(map, prefix + c, remaining - 1, result);
//				restore shared map
				map.put(c,  count);
			}
		}
	}
}
