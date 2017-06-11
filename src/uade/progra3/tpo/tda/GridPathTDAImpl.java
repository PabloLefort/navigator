package uade.progra3.tpo.tda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import uade.progra3.tpo.model.Node;

public class GridPathTDAImpl implements GridPathTDA {
	private int currentWeight;
	private Vector<Node> path;
	private Vector<Node> auxPaths;

	public GridPathTDAImpl() {
		super();
		this.currentWeight = 0;
		this.path = new Vector<Node>();
		this.auxPaths = new Vector<Node>();
	}

	public Vector<Node> getPath(Node start, Node end, int[][] grid) {
		this.calculatePath(start, end, grid);
		return this.path;
	}

	public void setRandomGrid(int[][] grid, int bound) {
		Random random = new Random();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = random.nextInt(bound);
			}
		}
	}

	private Vector<Node> calculatePath(Node start, Node end, int[][] grid) {
		Vector<Node> leafs = this.getNodeLeafs(start, end, grid);
		//for (int i = 0; i < leafs.size(); i++) {
			
		//}
		return null;
	}

	private Vector<Node> getNodeLeafs(Node start, Node end, int[][] grid) {
		Vector<Node> leafs = new Vector<Node>();
		ArrayList<Integer> auxLeafs = new ArrayList<Integer>();
		int nodeX = start.getX();
		int nodeY = start.getY();
		for(int i = 0; i < 4; i++){
			// Up leaf
			if(i == 0){
				addLeaf(auxLeafs, grid, nodeX, nodeY - 1, start);
			}
			// Right leaf
			if(i == 1){
				addLeaf(auxLeafs, grid, nodeX + 1, nodeY, start);
			}
			// Down leaf
			if(i == 2){
				addLeaf(auxLeafs, grid, nodeX, nodeY + 1, start);
			}
			// Left leaf
			if(i == 3){
				addLeaf(auxLeafs, grid, nodeX - 1, nodeY, start);
			}
		}
		// Sort leafs by weigth
		Collections.sort(auxLeafs);
		// Set lightweigth leafs to the path
		int lightweigth = 0;
		Vector<Node> nodeLeafs = start.getLeafs();
		for (int i = 0; i < nodeLeafs.size(); i++) {
			// Allways add the first leaf, because its the lightest
			if(i == 0){
				leafs.addElement(nodeLeafs.get(i));
				lightweigth = nodeLeafs.get(i).getWeight();
			} else {
				Node aux = nodeLeafs.get(i);
				if(aux.getWeight() == lightweigth || 
						(aux.getX() == end.getX() && aux.getY() == end.getY())){
					leafs.addElement(aux);
				} else {
					// Subsequent leafs are heavier, so stop iteration
					break;
				}
			}
		}
		return leafs;
	}
	
	private void addLeaf(List<Integer> auxLeafs, int[][] grid, int x, int y, Node node) {
		if(leafExists(grid, x, y)){
			int weight = grid[y][x];
			auxLeafs.add(weight);
			Node aux = new Node(y, x, weight);
			node.setLeafs(aux);
		}
	}

	private boolean leafExists(int[][] grid, int x, int y){
		return (x >= 0) && (y >= 0) && (y < grid.length) && (x < grid.length);
	}

}
