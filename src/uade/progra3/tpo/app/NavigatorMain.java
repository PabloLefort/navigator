package uade.progra3.tpo.app;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;
import uade.progra3.tpo.tda.MatrixPathFinderTDAImpl;
import uade.progra3.tpo.util.MatrixUtils;

public class NavigatorMain {

	public static void main(String[] args) {
		int[][] matrix = new int[2][2];
		MatrixUtils.fillMatrix(matrix, 20);
		MatrixPathFinderTDA tda = new MatrixPathFinderTDAImpl();
		Node start = new Node(0, 0, matrix[0][0]);
		Node end = new Node(1, 1, matrix[1][1]);
		tda.getPath(matrix, start, end);
	}
}
