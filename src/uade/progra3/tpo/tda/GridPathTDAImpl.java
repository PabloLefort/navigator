package uade.progra3.tpo.tda;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.model.Tree;

public class GridPathTDAImpl implements GridPathTDA {
	private int currentWeight;
	private Vector<Node> path;
	private Tree tree;
	private Node end;
	private boolean finded;
	
	public GridPathTDAImpl() {
		super();
		this.currentWeight = 0;
		this.path = new Vector<Node>();
		this.tree = new Tree();
		this.finded = false;
	}

	public Vector<Node> getPath(Node start, Node end, int[][] grid) {
		end.setWeight(grid[end.getX()][end.getY()]);
		start.setWeight(grid[start.getX()][start.getY()]);
		this.end = end;
		this.tree.setRoot(start);
		this.expandTree(start, grid, this.tree, null);
		// Select the leafs with less weight and expand it until end node is finded
		Tree tree = this.tree;
		Node aux = null;
		Vector<Node> expansions = new Vector<Node>();
		expansions.addElement(start);
		while(!finded){
			Vector<Tree> treeLeafs = tree.getLeafs();
			for (int i = 0; i < treeLeafs.size(); i++) {
				Node treeLeafsAuxNode = treeLeafs.get(i).getRoot();
				expansions.add(treeLeafsAuxNode);
				if(i == 0){
					aux = treeLeafsAuxNode;
				} else {
					if(treeLeafsAuxNode.getWeight() < aux.getWeight()){
						aux = treeLeafsAuxNode;
					}
				}
				if(i == treeLeafs.size() - 1){
					Vector<Node> avoidNodes = new Vector<Node>();
					for (int j = 0; j < expansions.size(); j++) {
						Node auxNodeExpansion = expansions.get(j);
						if(auxNodeExpansion.getX() != aux.getX() && auxNodeExpansion.getY() != aux.getY()){
							avoidNodes.addElement(auxNodeExpansion);
						}
					}
					System.out.println("Expanding: x" + aux.getX() + " -  y" + aux.getY() + " - w" + aux.getWeight());
					this.expandTree(aux, grid, treeLeafs.get(i), avoidNodes);
				}
			}
		}
		this.PrintTree(tree);
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

	private void expandTree(Node start, int[][] grid, Tree tree, Vector<Node> avoidNodes) {
		Vector<Node> leafs = this.getNodeLeafs(start, end, grid);
		Vector<Tree> treeLeafs = new Vector<Tree>();
		Node auxLeaf = null;
		PrintLeafs(leafs);
		for (int i = 0; i < leafs.size(); i++) {
			auxLeaf = leafs.get(i);
			int auxLeafX = auxLeaf.getX();
			int auxLeafY = auxLeaf.getY();
			// Found the end node
			if(auxLeafX == this.end.getX() && auxLeafY == this.end.getY()){
				this.finded = true;
				break;
			}
			if(avoidNodes != null){
				for (int j = 0; j < avoidNodes.size(); j++) {
					Node avoidNodeAux = avoidNodes.get(j);
					// Check avoid nodes
					if(auxLeafX == avoidNodeAux.getX() && auxLeafY == avoidNodeAux.getY()){
						auxLeaf = null;
					}
				}
			}
			if(auxLeaf != null){
				Tree aux = new Tree();
				aux.setRoot(auxLeaf);
				treeLeafs.addElement(aux);
			}
		}
		tree.setLeafs(treeLeafs);
	}

	private Vector<Node> getNodeLeafs(Node start, Node end, int[][] grid) {
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
		Vector<Node> nodeLeafs = start.getLeafs();
		//System.out.println("------");
		//PrintLeafs(nodeLeafs);
		return start.getLeafs();
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
	
	public void PrintTree(Tree tree){
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("Raiz: " + tree.getRoot().getWeight());
		Vector<Tree> auxLeafs = tree.getLeafs();
		for (int i = 0; i < auxLeafs.size(); i++) {
			Tree aux = auxLeafs.get(i);
			if(i == 0){
				System.out.print("(");
			}
			System.out.print(aux.getRoot().getWeight() + ", ");
			if(i == tree.getLeafs().size() - 1){
				System.out.print(")");
			}
			if(aux.getLeafs() != null && aux.getLeafs().size() > 0){
				PrintTree(aux);
			}
		}
	}

}
