package uade.progra3.tpo.tda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import uade.progra3.tpo.model.Node;

public class GridPathTDAImpl implements GridPathTDA {

	public Vector<Node> getPath(Node start, Node end, int[][] grid) {
		Vector<Node> path;
		path = this.calculatePath(start, end, grid);
		return path;
	}

	public void setRandomGrid(int[][] grid, int bound) {
		Random random = new Random();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = random.nextInt(bound);
				//grid[i][j] = 1;
			}
		}
	}

	private Vector<Node> calculatePath(Node start, Node end, int[][] grid) {
		Vector<Node> leafs = this.getNodeLeafs(start, grid);
		//for (int i = 0; i < leafs.size(); i++) {
			
		//}
		return null;
	}

	private Vector<Node> getNodeLeafs(Node start, int[][] grid) {
		Vector<Node> leafs = new Vector<Node>();
		ArrayList<Integer> auxLeafs = new ArrayList<Integer>();
		int nodeX = start.getX();
		int nodeY = start.getY();
		for(int i = 0; i < 4; i++){
			// Up leaf
			if(i == 0){
				addAuxLeaf(auxLeafs, grid, nodeX, nodeY -1);
			}
			// Right leaf
			if(i == 1){
				addAuxLeaf(auxLeafs, grid, nodeX + 1, nodeY);
			}
			// Down leaf
			if(i == 2){
				addAuxLeaf(auxLeafs, grid, nodeX, nodeY + 1);
			}
			// Left leaf
			if(i == 3){
				addAuxLeaf(auxLeafs, grid, nodeX - 1, nodeY);
			}
		}
		Collections.sort(auxLeafs);
		System.out.println(auxLeafs);
		return null;
	}
	
	private void addAuxLeaf(List<Integer> auxLeafs, int[][] grid, int x, int y) {
		if(leafExists(grid, x, y)){
			auxLeafs.add(grid[y][x]);
		}
	}

	private boolean leafExists(int[][] grid, int x, int y){
		return (x >= 0) && (y >= 0) && (y < grid.length) && (x < grid.length);
	}

}
