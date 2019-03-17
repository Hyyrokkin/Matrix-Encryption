package dev.hyyrokkin.math;

public class Matrix {

	int dimensionX;
	int dimensionY;
	double[][] matrix;
	
	
	public Matrix(int dimensionX) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionX;
		this.matrix = new double[dimensionX][dimensionX];
		
	}
	public Matrix(int dimensionX, int dimensionY) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.matrix = new double[dimensionX][dimensionY];
		
	}
	
	
	
	
	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}
	
	public void setCell(int x, int y, double element) {
		matrix[x][y] = element;
	}
	
	public void setRow(double[] set, int place) {
		for(int i = 0; i <= getDimensionX(); i++) {
			matrix[place][i] = set[i];
		}
	}
	
	public void setColum(double[] set, int place) {
		matrix[place] = set;
	}
	
	public double getCell(int x, int y) {
		return matrix[x][y];
	}
	
	public double[] getRow(int row) {
		double[] tmp = new double[dimensionX];
		for(int i = 0; i < dimensionX; i++) {
			tmp[i] = matrix[i][row];
		}
		return tmp;
	}
	
	public double[] getColum(int colum) {
		return matrix[colum];
	}
	
	public double[][] getMatrix(){
		return matrix;
	}
	
	public int getDimensionX() {
		return dimensionX;
	}
	
	public int getDimensionY() {
		return dimensionY;
	}
	
	public void printMatrix() {
		System.out.print("{");
		for(int i = 0; i < dimensionY; i++) {
			String tmp = "";
			for(int k = 0; k < dimensionX; k++) {
				tmp = tmp + matrix[k][i] + ",";
			}
			System.out.println(tmp);
		}
		System.out.print("}");
		System.out.println(" ");
	}
	
}
