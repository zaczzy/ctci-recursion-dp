package powerset;
import java.util.ArrayList;
class Subsets {
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		return getSubsets(set, 0);
	}
	
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		if (index == set.size()) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<Integer>());
			return result;
		} else {
			ArrayList<ArrayList<Integer>> subsets = getSubsets(set, index+1);
			
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
			moreSubsets.ensureCapacity(subsets.size());
			
			Integer item = set.get(index);
			
			for (ArrayList<Integer> subset : subsets) {
				ArrayList<Integer> copy = new ArrayList<>();
				copy.addAll(subset);
				moreSubsets.add(copy);
				
				subset.add(item);
			}
			subsets.addAll(moreSubsets);
			return subsets;
		}
	}
}
