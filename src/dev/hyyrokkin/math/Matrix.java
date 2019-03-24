package dev.hyyrokkin.math;

import java.math.BigDecimal;

public class Matrix {

	//Größe der Matrix
	int dimensionX;
	int dimensionY;
	BigDecimal[][] matrix;
	
	/*
	 * Konstrucktor für eine Quardratische Matrix
	 * 	Nimmt 1 Int(Größe x und y)
	 */
	public Matrix(int dimensionX) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionX;
		this.matrix = new BigDecimal[dimensionX][dimensionX];
		
		for(int x = 0; x < this.dimensionX; x++) {
			for(int y = 0; y < this.dimensionX; y++) {
				matrix[x][y] = new BigDecimal(32);
			}
		}
		
	}
	
	/*
	 * Konstrucktor für eine Matrix mit beliber Größe
	 * 	Nimmt 2 Int(Größe x, Größe y)
	 */
	public Matrix(int dimensionX, int dimensionY) {
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.matrix = new BigDecimal[dimensionX][dimensionY];
		
		for(int x = 0; x < this.dimensionX; x++) {
			for(int y = 0; y < this.dimensionX; y++) {
				matrix[x][y] = new BigDecimal(32);
			}
		}
		
	}
	
	
	
	/*
	 * Methode zum setzen einer Matrix
	 * 	Nimmt ein zweidimensional BigDecimal Array
	 */
	public void setMatrix(BigDecimal[][] matrix) {
		this.matrix = matrix;
	}
	
	/*
	 * Setzt eine element in der Matrix auf einen bestimmten Wert
	 * 	Nimmt 2 Int(Position x, position y) und ein BigDecimal(elemnt zum setzen)
	 */
	public void setCell(int x, int y, BigDecimal element) {
		matrix[x][y] = element;
	}
	
	/*
	 * Setzt eine bestimmt Reihe auf ein BigDecimal Array
	 * 	Nimmt ein BigDecimal Array(zu setzende Reihe) und ein Int(zu setzende stelle)
	 */
	public void setRow(BigDecimal[] set, int place) {
		for(int i = 0; i <= getDimensionX(); i++) {
			matrix[place][i] = set[i];
		}
	}
	
	/*
	 * Setzt eine bestimmt Zeile auf ein BigDecimal Array
	 * 	Nimmt ein BigDecimal Array(zu setzende Zeile) und ein Int(zu setzende stelle)
	 */
	public void setColum(BigDecimal[] set, int place) {
		matrix[place] = set;
	}
	
	/*
	 * Gibt das Element an einer Bestimmte Stelle zurück
	 * 	Nimmt 2 Int(Position x und y)
	 */
	public BigDecimal getCell(int x, int y) {
		return matrix[x][y];
	}
	
	/*
	 * Gibt eine Bestimte Reihe zurück
	 * 	Nimmt ein Int(Zu bearbeitende Reihe)
	 */
	public BigDecimal[] getRow(int row) {
		BigDecimal[] tmp = new BigDecimal[dimensionX];
		for(int i = 0; i < dimensionX; i++) {
			tmp[i] = matrix[i][row];
		}
		return tmp;
	}
	
	/*
	 * Gibt eine Bestimte Zeile zurück
	 * 	Nimmt ein Int(Zu bearbeitende Zeile)
	 */
	public BigDecimal[] getColum(int colum) {
		return matrix[colum];
	}
	
	/*
	 * Gibt die Matrix zurück
	 */
	public BigDecimal[][] getMatrix(){
		return matrix;
	}
	
	/*
	 * Gibt die X größe zurück
	 */
	public int getDimensionX() {
		return dimensionX;
	}
	
	/*
	 * Gibt die Y Größe zurück
	 */
	public int getDimensionY() {
		return dimensionY;
	}
	
	/*
	 * Gibt die Matrix in der Konsole aus
	 * 	Beispiel:
	 * 		{
	 * 		{ a, b, c, }
	 * 		{ d, e, f, }
	 * 		{ g, h, i, }
	 * 		}
	 */
	public void printMatrix() {
		System.out.print("{ "+ (char)10);
		for(int i = 0; i < dimensionY; i++) {
			String tmp = "{";
			for(int k = 0; k < dimensionX; k++) {
				tmp = tmp + matrix[k][i] + ", ";
			}
			tmp = tmp + "}";
			System.out.println(tmp);
		}
		System.out.print("}");
		System.out.println(" ");
	}
	
}
