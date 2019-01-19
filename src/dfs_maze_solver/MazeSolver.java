package dfs_maze_solver;

public class MazeSolver {
	
	private int[][] mazeMap;
	private boolean[][] visited;
	private int startPositionRow;
	private int startPositionCol;
	
	public MazeSolver(int[][] map, int startPositionRow, int startPositionCol) {
		this.mazeMap = map;
		this.visited = new boolean[mazeMap.length][mazeMap.length];
		this.startPositionRow = startPositionRow;
		this.startPositionCol = startPositionCol;
	}
	
	public void findWayOut() {
		try {
			dfs(startPositionRow, startPositionCol, "init");
			System.out.println("No solution found...");
		} catch (RuntimeException e) {
			System.out.println("Route found to exit!!!");
		}
	}

	public void dfs(int rowIndex, int colIndex, String direction) {
		
		int endOfMap = this.mazeMap.length - 1;
		if((rowIndex < 0 || rowIndex > endOfMap)||(colIndex < 0 || colIndex > endOfMap))
			return;
		
		System.out.println("value="+ this.mazeMap[rowIndex][colIndex] + " - direction = "+direction);
		
		if(this.mazeMap[rowIndex][colIndex] == 3) {
			throw new RuntimeException(); 
		}
		
		if(visited[rowIndex][colIndex]) {
			return;
		}else if(this.mazeMap[rowIndex][colIndex] == 1) {
			return;
		}else {
			visited[rowIndex][colIndex] = true;
			
			dfs(rowIndex+1, colIndex, "down");//down
			dfs(rowIndex, colIndex+1, "right");//right;
			dfs(rowIndex, colIndex-1, "left");//left
			dfs(rowIndex-1, colIndex, "up");//up
		}
	}
}
