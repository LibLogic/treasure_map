package treasure_map;

import java.util.HashMap;
import java.util.Map;

public class TreasureMap {
	
	public static int[] treasureFinder(int x, int y, int[][] directions, int[][] bombLocs) {
		
		Map<String, Integer> bombMap = new HashMap<>();
		for(int[] bombLoc : bombLocs) {
			String location = Integer.toString(bombLoc[0]) + Integer.toString(bombLoc[1]);
			bombMap.put(location, 0);
		}

		int[] result = new int[2];
		for (int[] direction : directions) {
			int xFrom = x;
			int yFrom = y;
			switch(direction[0]) {
				case 0:
					y -= direction[1];
					break;
				case 1:
					x += direction[1];
					break;
				case 2:
					y += direction[1];
					break;
				case 3:
					x -= direction[1];
					break;
			}
			result[0] = x;
			result[1] = y;
						
			if(bombCheck(bombMap, xFrom, yFrom, x, y)) {
				return new int[] {-1};
			}
		}
		return result;
	}
	
	private static boolean bombCheck(Map<String, Integer> bombMap, int xFrom, int yFrom, int x, int y) {
		if(x < 0 || x > 20 || y < 0 || y > 20) {
			return true;
		}
		int from = Integer.valueOf(Integer.toString(xFrom) + Integer.toString(yFrom));
		int to = Integer.valueOf(Integer.toString(x) + Integer.toString(y));
		int skipValue = yFrom == y ? 10 : 1;
		for(int i = Math.min(from, to); i <= Math.max(from , to); i += skipValue) {
			if(bombMap.containsKey(Integer.toString(i))) {
				return true;
			}
		}
		return false;
	}
}
