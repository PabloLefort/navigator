package uade.progra3.tpo;

import java.util.Random;
import java.util.Vector;

public class Navigator {
	private int xsize;
	private int ysize;
	private int[][]grid;
	private Vector<Nodo> path;
	
	public Navigator(int[][] grid) {
		super();
		this.xsize = 5;
		this.ysize = 5;
		this.grid = grid == null ? this.RandomGrid() : grid;		
	}

	Vector<Nodo> calculate(Nodo origen, Nodo destino){
		Vector<Nodo> path = new Vector<Nodo>();
		
		
		return path;
	}
	
	private int[][] RandomGrid(){
		int[][] aux = new int[xsize][ysize];
		Random generator = new Random();
		for (int i = 0; i < xsize; i++) {
			for (int j = 0; j < ysize; j++) {
				aux[i][j] = generator.nextInt(4);
				System.out.println(aux[i][j]);
			}
		}
		return aux;
	}
}
