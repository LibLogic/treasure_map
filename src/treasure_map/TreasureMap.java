package treasure_map;

import java.util.HashMap;
import java.util.Map;

public class TreasureMap {
	static int mapWidth = 15;
	
	public static int[] treasureFinder(int x, int y, int[][] directions, int[][] bombLocs) {
		
		Map<String, Integer> bombMap = new HashMap<>();
		for(int[] bombLoc : bombLocs) {
			String location = Integer.toString(bombLoc[0]) + " " + Integer.toString(bombLoc[1]);
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
		if(x < 0 || x > mapWidth || y < 0 || y > mapWidth) {
			return true;
		}
		
		int from = 0;
		int to = 0;
		String dir = "";
		
		if(yFrom == y) {
			from = xFrom;
			to = x;
			dir = "x";
		} else if(xFrom == x){
			from = yFrom;
			to = y;
			dir = "y";
		}
		
		for(int i = Math.min(from, to); i <= Math.max(from, to); i++) {
			String key = "";
			
			if(dir.equals("x")) {
				key = i + " " + y;
			}
			
			if(dir.equals("y")) {
				key = x + " " + i;
			}
			
			if(bombMap.containsKey(key)) {
				return true;
			}
		}
		return false;
	}
}
