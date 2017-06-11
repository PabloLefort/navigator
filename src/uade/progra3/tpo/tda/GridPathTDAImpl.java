package uade.progra3.tpo.tda;

import java.util.Random;
import java.util.Vector;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.model.Tree;

public class GridPathTDAImpl implements GridPathTDA {
	private int currentWeight;
	private Vector<Node> path;
	private Tree tree;

	public GridPathTDAImpl() {
		super();
		this.currentWeight = 0;
		this.path = new Vector<Node>();
		this.tree = new Tree();
	}

	public Vector<Node> getPath(Node start, Node end, int[][] grid) {
		this.tree.setRoot(start);
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
		PrintLeafs(leafs);
		//for (int i = 0; i < leafs.size(); i++) {
			
		//}
		return null;
	}

	private Vector<Node> getNodeLeafs(Node start, Node end, int[][] grid) {
		Vector<Node> leafs = new Vector<Node>();
		int nodeX = start.getX();
		int nodeY = start.getY();
		for(int i = 0; i < 4; i++){
			// Up leaf
			if(i == 0){
				addLeaf(grid, nodeX, nodeY - 1, start);
			}
			// Right leaf
			if(i == 1){
				addLeaf(grid, nodeX + 1, nodeY, start);
			}
			// Down leaf
			if(i == 2){
				addLeaf(grid, nodeX, nodeY + 1, start);
			}
			// Left leaf
			if(i == 3){
				addLeaf(grid, nodeX - 1, nodeY, start);
			}
		}
		// Set lightweigth leafs to the path
		int lightweigth = 0;
		Vector<Node> nodeLeafs = start.getLeafs();
		System.out.println("------");
		PrintLeafs(nodeLeafs);
		System.out.println("------");
		Vector<Node> auxNodeLeafs = new Vector<Node>();
		// Sort node leafs
		int i = 0;
		while(auxNodeLeafs.size() < nodeLeafs.size()){
			if(i == nodeLeafs.size()){
				i = 0;
				lightweigth++;
			}
			Node aux = nodeLeafs.get(i);
			if(aux.getWeight() == lightweigth){
				auxNodeLeafs.addElement(aux);
			}
			i++;
		}
		lightweigth = 0;
		for (i = 0; i < auxNodeLeafs.size(); i++) {
			// Allways add the first leaf, because its the lightest
			if(i == 0){
				leafs.addElement(auxNodeLeafs.get(i));
				lightweigth = auxNodeLeafs.get(i).getWeight();
			} else {
				Node aux = auxNodeLeafs.get(i);
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
	
	private void addLeaf(int[][] grid, int x, int y, Node node) {
		if(leafExists(grid, x, y)){
			int weight = grid[y][x];
			Node aux = new Node(y, x, weight);
			node.setLeafs(aux);
		}
	}

	private boolean leafExists(int[][] grid, int x, int y){
		return (x >= 0) && (y >= 0) && (y < grid.length) && (x < grid.length);
	}
	
	public void PrintLeafs(Vector<Node> leafs){
		for (int i = 0; i < leafs.size(); i++) {
			Node aux = leafs.get(i);
			System.out.println("x:" + aux.getX() + " y:" + aux.getY() + " w:" + aux.getWeight());
		}
	}

}
