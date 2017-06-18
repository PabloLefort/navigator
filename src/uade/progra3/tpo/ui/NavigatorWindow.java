package uade.progra3.tpo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import uade.progra3.tpo.model.Coordinate;
import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;

public class NavigatorWindow extends JFrame {
	private static final long serialVersionUID = -7225797436015174108L;
	private GridLayout experimentLayout;
	private int[][] matrix;
	private List<Node> results;

	public NavigatorWindow(String name, int[][] matrix, List<Node> results) {
		super(name);
		this.experimentLayout = new GridLayout(matrix.length, matrix[0].length);
		setResizable(false);
		this.matrix = matrix;
		this.results = results;
	}

	public void addComponentsToPane(final Container pane) {
		final JPanel compsToExperiment = new JPanel();
		compsToExperiment.setLayout(experimentLayout);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				Node node = new Node(new Coordinate(i, j), matrix[i][j], 0, 0);
				JButton b = new JButton(Integer.toString(matrix[i][j]));
				b.setOpaque(true);
				if(results.contains(node)) {
					b.setBackground(Color.GREEN);
				} else if(node.getValue() == MatrixPathFinderTDA.FORBIDDEN_VALUE) {
					b.setBackground(Color.RED);
				}
				compsToExperiment.add(b);
			}
		}

		pane.add(compsToExperiment, BorderLayout.EAST);
		pane.add(new JSeparator(), BorderLayout.CENTER);
	}
}
