
public class TreasureMap {
	
	public static int[] treasureFinder(int x, int y, int[][] directions) {
		int[] result = new int[2];
		for(int i = 0; i < directions.length; i++) {
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
			result[0] = x;
			result[1] = y;
		}
		return result;
	}
}
