package dev.hyyrokkin.math;

import java.math.BigDecimal;

public class Matrix {

	int dimensionX;
	int dimensionY;
	BigDecimal[][] matrix;
	
	
	public Matrix(int dimensionX) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionX;
		this.matrix = new BigDecimal[dimensionX][dimensionX];
		
	}
	public Matrix(int dimensionX, int dimensionY) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.matrix = new BigDecimal[dimensionX][dimensionY];
		
	}
	
	
	
	
	public void setMatrix(BigDecimal[][] matrix) {
		this.matrix = matrix;
	}
	
	public void setCell(int x, int y, BigDecimal element) {
		matrix[x][y] = element;
	}
	
	public void setRow(BigDecimal[] set, int place) {
		for(int i = 0; i <= getDimensionX(); i++) {
			matrix[place][i] = set[i];
		}
	}
	
	public void setColum(BigDecimal[] set, int place) {
		matrix[place] = set;
	}
	
	public BigDecimal getCell(int x, int y) {
		return matrix[x][y];
	}
	
	public BigDecimal[] getRow(int row) {
		BigDecimal[] tmp = new BigDecimal[dimensionX];
		for(int i = 0; i < dimensionX; i++) {
			tmp[i] = matrix[i][row];
		}
		return tmp;
	}
	
	public BigDecimal[] getColum(int colum) {
		return matrix[colum];
	}
	
	public BigDecimal[][] getMatrix(){
		return matrix;
	}
	
	public int getDimensionX() {
		return dimensionX;
	}
	
	public int getDimensionY() {
		return dimensionY;
	}
	
	public void printMatrix() {
		System.out.println("{");
		for(int i = 0; i < dimensionY; i++) {
			String tmp = "";
			for(int k = 0; k < dimensionX; k++) {
				tmp = tmp + matrix[k][i] + ", ";
			}
			System.out.println(tmp);
		}
		System.out.print("}");
		System.out.println(" ");
	}
	
}
