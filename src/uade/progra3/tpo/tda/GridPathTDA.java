package uade.progra3.tpo.tda;

import java.util.Vector;

import uade.progra3.tpo.model.Node;

public interface GridPathTDA {
	
	public Vector<Node> getPath(Node start, Node end, int[][] grid);

	public void setRandomGrid(int[][] grid, int i);

}
