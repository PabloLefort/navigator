package uade.progra3.tpo.app;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;
import uade.progra3.tpo.tda.MatrixPathFinderTDAImpl;
import uade.progra3.tpo.util.MatrixUtils;

public class NavigatorMain {

	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		MatrixUtils.fillMatrix(matrix, 4);
		MatrixPathFinderTDA tda = new MatrixPathFinderTDAImpl();
		Node start = new Node(0, 0, matrix[0][0]);
		Node end = new Node(4, 4, matrix[4][4]);
		System.out.println(matrix);
		tda.getPath(matrix, start, end);
	}
}
