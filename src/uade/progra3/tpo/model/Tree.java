package uade.progra3.tpo.model;

import java.util.Vector;

public class Tree {
	private Node root;
	private Vector<Tree> leafs;
	
	public Tree(Node root, Vector<Node> leafs) {
		this.root = root;
		this.leafs = null;
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

	public Vector<Tree> getLeafs() {
		return leafs;
	}

	public void setLeafs(Vector<Tree> leafs) {
		this.leafs = leafs;
	}
	
}
