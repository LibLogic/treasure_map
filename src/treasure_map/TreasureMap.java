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
		for(int i = 0; i < directions.length; i++) {
			int xFrom = x;
			int yFrom = y;
			switch(directions[i][0]) {
				case 0:
					y -= directions[i][1];
					break;
				case 1:
					x += directions[i][1];
					break;
				case 2:
					y += directions[i][1];
					break;
				case 3:
					x -= directions[i][1];
					break;
			}
			
			if(bombCheck(bombMap, xFrom, yFrom, x, y)) {
				return new int[] {-1};
			}
			
			result[0] = x;
			result[1] = y;
		}
		return result;
	}
	
	private static boolean bombCheck(Map<String, Integer> bombMap, int xFrom, int yFrom, int x, int y) {
		if(yFrom == y) {
			int xfrom = Integer.valueOf(Integer.toString(xFrom) + Integer.toString(yFrom));
			int xto = Integer.valueOf(Integer.toString(x) + Integer.toString(y));
			for(int i = Math.min(xfrom, xto); i <= Math.max(xfrom , xto); i += 10) {
				String test = Integer.toString(i);
				if(bombMap.containsKey(test)) {
					return true;
				}
			}

		} else if (xFrom == x) {
			int yfrom = Integer.valueOf(Integer.toString(xFrom) + Integer.toString(yFrom));
			int yto = Integer.valueOf(Integer.toString(x) + Integer.toString(y));
			for(int i = Math.min(yfrom, yto); i <= Math.max(yfrom, yto); i++) {
				String test = Integer.toString(i);
				if(bombMap.containsKey(test)) {
					return true;
				}
			}
		}
		return false;
	}
}
