package uade.progra3.tpo.model;

import java.util.Vector;

public class Node {
	private int x;
	private int y;
	private Vector<Node> leafs;
	private int weight;
	private int maxWeightLeafs;
	
	public Node(int x, int y, int weight) {
		super();
		this.x = x;
		this.y = y;
		this.weight = weight;
		this.maxWeightLeafs = 0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Vector<Node> getLeafs() {
		return leafs;
	}
	public void setLeafs(Node leaf) {
		this.leafs.addElement(leaf);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getMaxWeightLeafs() {
		return maxWeightLeafs;
	}

	public void setMaxWeightLeafs(int maxWeightLeafs) {
		this.maxWeightLeafs = maxWeightLeafs;
	}

}
