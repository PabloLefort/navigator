package uade.progra3.tpo.app;

import java.util.Arrays;
import java.util.List;

import uade.progra3.tpo.model.Coordinate;
import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;
import uade.progra3.tpo.tda.MatrixPathFinderTDAImpl;
import uade.progra3.tpo.util.MatrixUtils;

public class NavigatorMain {

	public static void main(String[] args) {
		// Preparo la matriz
		int[][] matrix = new int[5][5];
		MatrixUtils.fillMatrix(matrix, 4);

		Coordinate startCoordinate = new Coordinate(0, 0);
		Coordinate endCoordinate = new Coordinate(4, 4);
		MatrixPathFinderTDA tda = new MatrixPathFinderTDAImpl();
		Node start = new Node(startCoordinate, matrix[startCoordinate.getX()][startCoordinate.getY()], 0,
				MatrixUtils.getDistanceBetweenCoordinates(startCoordinate, endCoordinate));
		Node end = new Node(endCoordinate, matrix[endCoordinate.getX()][endCoordinate.getY()], 0, 0);
		System.out.println("Matriz: " + Arrays.deepToString(matrix));
		try {
			List<Node> result = tda.getPath(matrix, start, end);
			System.out.println("Solucion: " + result);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
