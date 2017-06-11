package uade.progra3.tpo.app;

import java.util.Arrays;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.GridPathTDA;
import uade.progra3.tpo.tda.GridPathTDAImpl;

public class Navigator {

	public static void main(String[] args) {
		int[][] grid = new int[5][5];
		GridPathTDA tda = new GridPathTDAImpl();
		tda.setRandomGrid(grid, 3);
		System.out.println(Arrays.deepToString(grid));
		Node start = new Node(0, 0, 0);
		Node end = new Node(0, 0, 0);
		tda.getPath(start, end, grid);
	}

}
