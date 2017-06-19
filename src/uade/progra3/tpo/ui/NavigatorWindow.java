package uade.progra3.tpo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import uade.progra3.tpo.model.Coordinate;
import uade.progra3.tpo.model.Node;
import uade.progra3.tpo.tda.MatrixPathFinderTDA;
import uade.progra3.tpo.tda.MatrixPathFinderTDAImpl;

public class NavigatorWindow extends JFrame {
	private static final long serialVersionUID = -7225797436015174108L;
	private GridLayout experimentLayout;
	private int[][] matrix;
	private List<Node> results;
	private MatrixPathFinderTDA tda;
	private Node start, end;

	public void displayUI() throws Exception {
		Container container = this.getContentPane();
		container.removeAll();
		this.tda = new MatrixPathFinderTDAImpl();
		this.results = tda.getPath(matrix, start, end);
		addComponentsToPane(container);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public NavigatorWindow(int[][] matrix, Node start, Node end) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super("PathFinder UI");
		this.start = start;
		this.end = end;
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.experimentLayout = new GridLayout(matrix.length, matrix[0].length);
		setResizable(false);

		this.matrix = matrix;
		this.results = results;
	}

	private void addComponentsToPane(final Container pane) {
		final JPanel compsToExperiment = new JPanel();
		compsToExperiment.setLayout(experimentLayout);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int value = matrix[i][j];
				Node node = new Node(new Coordinate(i, j), value, 0, 0);
				JButton b = new JButton(Integer.toString(value));
				b.addActionListener(new ButtonActionListener(new Coordinate(i, j)));
				b.setOpaque(true);
				if (results.contains(node)) {
					b.setBackground(Color.GREEN);
				} else if (node.getValue() == MatrixPathFinderTDA.FORBIDDEN_VALUE) {
					b.setBackground(Color.RED);
				}
				compsToExperiment.add(b);
			}
		}

		pane.add(compsToExperiment, BorderLayout.EAST);
	}

	private class ButtonActionListener implements ActionListener {

		private Coordinate coord;

		public ButtonActionListener(Coordinate coord) {
			this.coord = coord;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int value = Integer.parseInt(button.getText());
			if (value == MatrixPathFinderTDA.FORBIDDEN_VALUE) {
				value = 0;
			} else {
				value = value + 1;
			}
			matrix[this.coord.getX()][this.coord.getY()] = value;
			try {
				displayUI();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				System.exit(-1);
			}
		}
	}
}
