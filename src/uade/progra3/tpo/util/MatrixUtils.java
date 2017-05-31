package uade.progra3.tpo.util;

import java.util.Random;

public class MatrixUtils {

	public static void fillMatrix(int[][] matrix, int bound) {
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = random.nextInt(bound);
			}
		}
	}
}
