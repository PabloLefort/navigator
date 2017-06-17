package uade.progra3.tpo.model;

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public boolean equals(Object obj) {
		Coordinate c = (Coordinate) obj;
		return this.x == c.getX() && this.y == c.getY();
	}

	@Override
	public String toString() {
		return "{" + this.x + "," + this.y + "}";
	}
}
