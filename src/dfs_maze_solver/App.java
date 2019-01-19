package dfs_maze_solver;

public class App {

	public static void main(String[] args) {

		FileReader fileReader = new FileReader("/home/stanley/Desktop/map", 6, 6);
		fileReader.parseFile();
		
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
	}

}
