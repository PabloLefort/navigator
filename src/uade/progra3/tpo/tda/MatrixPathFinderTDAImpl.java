package uade.progra3.tpo.tda;

import java.util.List;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.util.MatrixUtils;

public class MatrixPathFinderTDAImpl implements MatrixPathFinderTDA {

	@Override
	public List<Node> getPath(int[][] matrix, Node start, Node end) {
		Node treeNode = MatrixUtils.matrixToTreeNode(matrix, start.getX(), start.getY());
		System.out.println(treeNode);
		return null;
	}

}
