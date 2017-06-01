package uade.progra3.tpo.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Node {
	private int x;
	private int y;
	private int value;
	private Set<Node> leafs;
	private Node parent;

	public Node(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.leafs = new HashSet<Node>();
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return x == node.getX() && y == node.getY();
	}

	@Override
	public String toString() {
		return "x: " + this.x + ", y: " + this.y;
	}

	public Set<Node> getLeafs() {
		return leafs;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void addLeaf(Node leaf) {
		this.leafs.add(leaf);
	}
}
