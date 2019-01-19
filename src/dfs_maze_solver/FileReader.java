package dfs_maze_solver;

import java.io.File;
import java.util.Scanner;

public class FileReader {

	private int[][] map;
	private String fileName;
	private int numOfRows;
	private int numOfColums;
	private int startPositionRow;
	private int startPositionCol;
	
	public FileReader(String fileName, int numOfRows, int numOfColums) {
		this.fileName = fileName;
		this.numOfRows = numOfRows;
		this.numOfColums = numOfColums;	
		this.map = new int[numOfRows][numOfColums];
	}
	
	public void parseFile() {
		try {
			Scanner scanner = new Scanner(new File(this.fileName));
			
			for (int i = 0; i < this.numOfRows; i++) {
				for (int j = 0; j < this.numOfColums; j++) {
					this.map[i][j] = scanner.nextInt();
					
					if(this.map[i][j] == 2) {
						this.startPositionRow = i;
						this.startPositionCol = j;
					}
				}
			}
			
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getStartPositionRow() {
		return startPositionRow;
	}

	public int getStartPositionCol() {
		return startPositionCol;
	}

	public int[][] getMap() {
		return map;
	}

}
