package uade.progra3.tpo.model;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {

	private Node root;
	private Set<TreeNode> leafs;

	public Node getRoot() {
		return root;
	}

	public Set<TreeNode> getLeafs() {
		return leafs;
	}

	public TreeNode(Node root) {
		this.root = root;
		leafs = new HashSet<TreeNode>();
	}

	public void addLeaf(TreeNode n) {
		this.leafs.add(n);
	}
}
