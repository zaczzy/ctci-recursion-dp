package box_stacking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class BoxStacker {
	static List<Box> createAllRotations(List<Box> boxes) {
		List<Box> rotations = new ArrayList<>();
		for (Box box : boxes) {
			rotations.add(box);
			rotations.add(new Box(Math.max(box.height, box.length), Math.min(box.height, box.length), box.width));
			rotations.add(new Box(Math.max(box.height,  box.width), Math.min(box.height,  box.width), box.length));		
		}
		return rotations;
	}
	static int findMaxHeight(List<Box> boxes) {
		List<Box> rotations = createAllRotations(boxes);
		Collections.sort(rotations, (x, y)->(y.length * y.width - x.length * x.width));
		int[] maxHeight = new int[rotations.size()];
		for (int i =0; i < rotations.size();i++) {
			for (int j = 0; j < i; j++) {
				maxHeight[i] = Math.max(maxHeight[i], maxHeight[j]);
			}
			maxHeight[i]+= rotations.get(i).height;
		}
		return Arrays.stream(maxHeight).max().getAsInt();
	}
}
