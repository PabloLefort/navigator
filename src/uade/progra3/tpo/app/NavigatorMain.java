package uade.progra3.tpo.app;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import uade.progra3.tpo.model.Coordinate;
import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;
import uade.progra3.tpo.tda.MatrixPathFinderTDAImpl;
import uade.progra3.tpo.ui.NavigatorWindow;
import uade.progra3.tpo.util.MatrixUtils;

public class NavigatorMain {

	public static void main(String[] args) {
		// Preparo la matriz
		int[][] matrix = new int[25][25];
		MatrixUtils.fillMatrix(matrix, 4);

		Coordinate startCoordinate = new Coordinate(20, 0);
		Coordinate endCoordinate = new Coordinate(10, 24);
		MatrixPathFinderTDA tda = new MatrixPathFinderTDAImpl();
		Node start = new Node(startCoordinate, matrix[startCoordinate.getX()][startCoordinate.getY()], 0,
				MatrixUtils.getDistanceBetweenCoordinates(startCoordinate, endCoordinate));
		Node end = new Node(endCoordinate, matrix[endCoordinate.getX()][endCoordinate.getY()], 0, 0);
		System.out.println("Matriz: " + Arrays.deepToString(matrix));
		try {
			List<Node> result = tda.getPath(matrix, start, end);
			System.out.println("Solucion: " + result);
			displayResults(matrix, result);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	private static void displayResults(int[][] matrix, List<Node> result) {
		/* Use an appropriate Look and Feel */
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NavigatorWindow frame = new NavigatorWindow("PathFinder UI", matrix, result);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.addComponentsToPane(frame.getContentPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
