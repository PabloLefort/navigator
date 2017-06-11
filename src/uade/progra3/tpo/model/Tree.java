package uade.progra3.tpo.model;

import java.util.Vector;

public class Tree {
	private Node root;
	private Vector<Node> leafs;
	
	public Tree(Node root, Vector<Node> leafs) {
		this.root = root;
		this.leafs = leafs;
	}
	
	public Tree() {
		this.root = null;
		this.leafs = null;
	}

	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Vector<Node> getLeafs() {
		return leafs;
	}
	public void setLeafs(Vector<Node> leafs) {
		this.leafs = leafs;
	}
	
}
