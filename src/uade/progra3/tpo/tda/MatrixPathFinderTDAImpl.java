package uade.progra3.tpo.tda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.util.MatrixUtils;

public class MatrixPathFinderTDAImpl implements MatrixPathFinderTDA {

	private PriorityQueue<Node> pq;
	private ArrayList<Node> steps;

	public MatrixPathFinderTDAImpl() {
		this.pq = new PriorityQueue<Node>(new NodeComparator());
		this.steps = new ArrayList<Node>() {
			private static final long serialVersionUID = 8288839705535513624L;

			@Override
			public String toString() {
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				for (int i = 0; i < this.size(); i++) {
					sb.append(this.get(i).getCoordinate());
					sb.append(",");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
				return sb.toString();
			}
		};
	}

	@Override
	public List<Node> getPath(int[][] matrix, Node start, Node end) throws Exception {

		if (start.getValue() == FORBIDDEN_VALUE) {
			throw new Exception("El origen debe ser un nodo valido");
		}

		if (end.getValue() == FORBIDDEN_VALUE) {
			throw new Exception("El destino debe ser un nodo valido");
		}

		this.steps.add(start);
		if (start.equals(end)) {
			return generateResult(end, new ArrayList<Node>());
		}

		Collection<Node> expandedNodes = MatrixUtils.expandFromNode(start, end, matrix);
		expandedNodes.removeAll(this.steps);
		expandedNodes.removeAll(this.pq);

		for (Iterator<Node> it = expandedNodes.iterator(); it.hasNext();) {
			Node n = it.next();
			if (n.equals(end)) {
				end.setPrevious(start);
				n = end;
			}
			if (n.getValue() != FORBIDDEN_VALUE) {
				this.pq.add(n);
			}
		}

		Node n = pq.poll();
		if (n == null) {
			throw new Exception("No existe ningun camino posible entre los nodos");
		}
		return getPath(matrix, n, end);
	}

	private List<Node> generateResult(Node n, List<Node> result) {
		if (n.getPrevious() != null) {
			generateResult(n.getPrevious(), result);
		}
		result.add(n);
		return result;
	}

	private class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node n1, Node n2) {

			if (n1.getCost() > n2.getCost()) {
				return 1;
			} else if (n1.getCost() < n2.getCost()) {
				return -1;
			}
			return 0;
		}
	}
}
