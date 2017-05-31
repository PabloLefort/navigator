package uade.progra3.tpo.model;

public class Node {
	private int i;
	private int j;
	private int value;

	public Node(int i, int j, int value) {
		super();
		this.i = i;
		this.j = j;
		this.value = value;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return i == node.getI() && j == node.getJ();
	}

	@Override
	public String toString() {
		return "i: " + this.i + ", j: " + this.j;
	}

}
