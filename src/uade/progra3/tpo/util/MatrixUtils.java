package uade.progra3.tpo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import uade.progra3.tpo.model.Coordinate;
import uade.progra3.tpo.model.Coordinate.CoordinatePosition;
import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;

public class MatrixUtils {

	public static void fillMatrix(int[][] matrix, int bound) {
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = random.nextInt(bound);
			}
		}
	}

	public static Collection<Node> expandFromNode(Node start, Node end, int[][] matrix) {
		Collection<Node> result = new ArrayList<Node>();
		Collection<Node> excluded = new ArrayList<Node>();

		Collection<Coordinate> coordinates = fillCoordinates(start.getCoordinate());
		for (Iterator<Coordinate> it = coordinates.iterator(); it.hasNext();) {
			Coordinate c = it.next();
			try {
				Node n = new Node(c, matrix[c.getX()][c.getY()], start.getAccumulated() + 1,
						getDistanceBetweenCoordinates(start.getCoordinate(), end.getCoordinate()));
				n.setPrevious(start);
				if (n.getValue() == MatrixPathFinderTDA.FORBIDDEN_VALUE) {
					Coordinate cAux;
					Node nAux;

					if (start.getCoordinate().compareToCoordinate(n.getCoordinate()) == CoordinatePosition.HORIZONTAL) {
						try {
							cAux = new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() - 1);
							nAux = new Node(cAux, matrix[cAux.getX()][cAux.getY()], 0, 0);
							excluded.add(nAux);
						} catch (IndexOutOfBoundsException e1) {
							// Nada que hacer
						}
						try {
							cAux = new Coordinate(n.getCoordinate().getX(), n.getCoordinate().getY() + 1);
							nAux = new Node(cAux, matrix[cAux.getX()][cAux.getY()], 0, 0);
							excluded.add(nAux);
						} catch (IndexOutOfBoundsException e1) {
							// Nada que hacer
						}

					} else if (start.getCoordinate()
							.compareToCoordinate(n.getCoordinate()) == CoordinatePosition.VERTICAL) {
						try {
							cAux = new Coordinate(n.getCoordinate().getX() - 1, n.getCoordinate().getY());
							nAux = new Node(cAux, matrix[cAux.getX()][cAux.getY()], 0, 0);
							excluded.add(nAux);
						} catch (IndexOutOfBoundsException e1) {
							// Nada que hacer
						}
						try {
							cAux = new Coordinate(n.getCoordinate().getX() + 1, n.getCoordinate().getY());
							nAux = new Node(cAux, matrix[cAux.getX()][cAux.getY()], 0, 0);
							excluded.add(nAux);
						} catch (IndexOutOfBoundsException e1) {
							// Nada que hacer
						}

					}

				}
				result.removeAll(excluded);
				result.add(n);
			} catch (IndexOutOfBoundsException e) {
				// Nada que hacer
			}
		}
		return result;
	}

	// 8 movimientos posibles desde un punto
	private static Collection<Coordinate> fillCoordinates(Coordinate coord) {
		Collection<Coordinate> result = new ArrayList<Coordinate>();
		Coordinate c = new Coordinate(coord.getX() - 1, coord.getY());
		result.add(c);
		c = new Coordinate(coord.getX() - 1, coord.getY() - 1);
		result.add(c);
		c = new Coordinate(coord.getX() - 1, coord.getY() + 1);
		result.add(c);
		c = new Coordinate(coord.getX() + 1, coord.getY());
		result.add(c);
		c = new Coordinate(coord.getX() + 1, coord.getY() - 1);
		result.add(c);
		c = new Coordinate(coord.getX() + 1, coord.getY() + 1);
		result.add(c);
		c = new Coordinate(coord.getX(), coord.getY() - 1);
		result.add(c);
		c = new Coordinate(coord.getX(), coord.getY() + 1);
		result.add(c);
		return result;
	}

	public static double getDistanceBetweenCoordinates(Coordinate start, Coordinate end) {
		int deltaX = end.getX() - start.getX();
		int deltaY = end.getY() - start.getY();
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
}
