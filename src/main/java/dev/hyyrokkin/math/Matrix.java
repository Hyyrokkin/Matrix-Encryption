package dev.hyyrokkin.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matrix
{

	//Größe der Matrix
	private final int dimensionX;
	private BigDecimal[][] matrix;
	
	/**
	 * Konstruktor für eine quadratische Matrix.
	 * Nimmt 1 Int (Größe x)
	 */
	public Matrix(int dimensionX)
	{
		this.dimensionX = dimensionX;
		this.matrix = new BigDecimal[dimensionX][dimensionX];
		
		for(int x = 0; x < this.dimensionX; x++)
		{
			for(int y = 0; y < this.dimensionX; y++)
			{
				matrix[x][y] = new BigDecimal(32).setScale(9999, RoundingMode.HALF_EVEN);
			}
		}
		
	}
	
	/**
	 * Setzt eine element in der Matrix auf einen bestimmten Wert.
	 * Nimmt 2 Int (Position x, position y) und ein BigDecimal (Element zum Setzen)
	 */
	public void setCell(int x, int y, BigDecimal element)
	{
		matrix[x][y] = element.setScale(9999, RoundingMode.HALF_EVEN);
	}
	
	/**
	 * Setzt eine bestimmte Zeile auf ein BigDecimal Array.
	 * Nimmt ein BigDecimal Array (zu setzende Zeile) und ein Int (zu setzende stelle)
	 */
	public void setColum(BigDecimal[] set, int place)
	{
		matrix[place] = set;
	}
	
	/**
	 * Gibt das Element an einer bestimmten Stelle zurück.
	 * Nimmt 2 Int (Position x und y)
	 */
	public BigDecimal getCell(int x, int y)
	{
		return matrix[x][y].setScale(9999, RoundingMode.HALF_EVEN);
	}
	
	/**
	 * Gibt eine bestimmte Reihe zurück.
	 * Nimmt ein Int (Zu bearbeitende Reihe)
	 */
	public BigDecimal[] getRow(int row)
	{
		BigDecimal[] tmp = new BigDecimal[dimensionX];
		for(int i = 0; i < dimensionX; i++)
		{
			tmp[i] = matrix[i][row];
		}
		return tmp;
	}
	
	/**
	 * Gibt eine bestimmte Zeile zurück.
	 * Nimmt ein Int(Zu bearbeitende Zeile)
	 */
	public BigDecimal[] getColum(int colum)
	{
		return matrix[colum];
	}

	
	/**
	 * Gibt die X größe zurück
	 */
	public int getDimensionX()
	{
		return dimensionX;
	}

	
	/**
	 * Gibt die Matrix in der Konsole aus
	 * 	Beispiel:
	 * 		{ a, b, c, }
	 * 		{ d, e, f, }
	 * 		{ g, h, i, }
	 */
	public void printMatrix()
	{
		for(int i = 0; i < dimensionX; i++)
		{
			StringBuilder out = new StringBuilder("{");

			for(int k = 0; k < dimensionX; k++)
			{
				out.append(matrix[k][i].stripTrailingZeros());
				out.append(", ");
			}
			out.append("}");
			System.out.println(out);
		}
		System.out.println(" ");
	}
	
}
