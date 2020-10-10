package treasure_map;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		int[][] directions = new int[][] {
			{2, 3}, 
			{1, 1},
			{0, 2},
			{1, 2},
			{2, 4},
			{3, 1}
		};
		
		int[][] bombLocs = new int[][] {
			{2, 3}
		};
		System.out.println(Arrays.toString(TreasureMap.treasureFinder(2, 2, directions, bombLocs)));
	}
}
