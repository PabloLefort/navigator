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

	public CoordinatePosition compareToCoordinate(Coordinate c) {
		int deltaX = Math.abs(this.x - c.getX());
		int deltaY = Math.abs(this.y - c.getY());

		if (deltaX == 1 && deltaY == 0) {
			return CoordinatePosition.HORIZONTAL;
		} else if (deltaY == 1 && deltaX == 0) {
			return CoordinatePosition.VERTICAL;
		} else {
			return CoordinatePosition.DIAGONAL;
		}
	}

	public enum CoordinatePosition {
		HORIZONTAL, VERTICAL, DIAGONAL
	}
}
