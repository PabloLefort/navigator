package uade.progra3.tpo.util;

import java.util.Random;

import uade.progra3.tpo.model.Node;

public class MatrixUtils {

	public static void fillMatrix(int[][] matrix, int bound) {
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = random.nextInt(bound);
			}
		}
	}

	public static Node matrixToTreeNode(int[][] matrix, int fromX, int fromY) {
		Node node = new Node(fromX, fromY, matrix[fromX][fromY]);
		node.setParent(null);
		return matrixToTreeNode(matrix, node);
	}

	private static Node matrixToTreeNode(int[][] matrix, Node node) {
		Node child;
		int[][] coordinates = fillCoordinates(node.getX(), node.getY());
		for (int i = 0; i < coordinates.length; i++) {
			int coords[] = coordinates[i];
			try {
				child = new Node(coords[0], coords[1], matrix[coords[0]][coords[1]]);
				if (!hasParent(child, node)) {
					node.addLeaf(child);
					child.setParent(node);
					matrixToTreeNode(matrix, child);
				}
			} catch (IndexOutOfBoundsException e) {
			}

		}
		return node;
	}

	private static boolean hasParent(Node child, Node parent) {
		if (parent == null) {
			return false;
		}

		if (child.equals(parent)) {
			return true;
		} else {
			return hasParent(child, parent.getParent());
		}
	}

	// 8 movimientos posibles desde un punto
	private static int[][] fillCoordinates(int x, int y) {
		int[][] coordinates = new int[8][2];
		coordinates[0][0] = x - 1;
		coordinates[0][1] = y;

		coordinates[1][0] = x - 1;
		coordinates[1][1] = y - 1;

		coordinates[2][0] = x - 1;
		coordinates[2][1] = y + 1;

		coordinates[3][0] = x + 1;
		coordinates[3][1] = y;

		coordinates[4][0] = x + 1;
		coordinates[4][1] = y - 1;

		coordinates[5][0] = x + 1;
		coordinates[5][1] = y + 1;

		coordinates[6][0] = x;
		coordinates[6][1] = y - 1;

		coordinates[7][0] = x;
		coordinates[7][1] = y + 1;

		return coordinates;
	}
}
