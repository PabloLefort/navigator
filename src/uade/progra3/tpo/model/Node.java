package uade.progra3.tpo.model;

public class Node {
	private Coordinate coordinate;
	private int accumulated;
	private double distance;
	private int value;
	private Node previous = null;

	public Node(Coordinate coordinate, int value, int accumulated, double distance) {
		this.coordinate = coordinate;
		this.value = value;
		this.accumulated = accumulated;
		this.distance = distance;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public Node getPrevious() {
		return previous;
	}

	public double getCost() {
		return accumulated + distance + value;
	}

	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return this.coordinate.equals(node.coordinate);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public int getValue() {
		return this.value;
	}

	public int getAccumulated() {
		return accumulated;
	}

	@Override
	public String toString() {
		return this.coordinate.toString();
	}
}
