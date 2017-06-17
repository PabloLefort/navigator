package uade.progra3.tpo.tda;

import java.util.List;

import uade.progra3.tpo.model.Node;

public interface MatrixPathFinderTDA {

	public List<Node> getPath(int[][] matrix, Node start, Node end) throws Exception;
	
	public static final int FORBIDDEN_VALUE = 3;

}
