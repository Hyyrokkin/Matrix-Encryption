package dev.hyyrokkin.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathOpperations
{

	/**
	 * Invertiert eine Matrix.
	 * Nimmt eine Matrix (zu invertierende Matrix)
	 */
	public static Matrix inverse(Matrix m)
	{
		Matrix ret = new Matrix(1);
		if(isInvertible(m))
		{
			ret = multiplyInt(transpose(kofaktorMatrix(m)), BigDecimal.ONE.setScale(9999, RoundingMode.HALF_EVEN).divide(determinate(m), RoundingMode.HALF_EVEN));
		}
		else
		{
			System.out.println("Not Working");
		}
		return ret;
	}
	
	/**
	 * Gibt an, ob eine Matrix Invertierbar ist.
	 * Nimmt eine Matrix (zu überprüfende Matrix)
	 */
	public static boolean isInvertible(Matrix matrix)
	{
		return determinate(matrix).compareTo(BigDecimal.ZERO) != 0;
	}
	
	/**
	 * Gibt die Determinate einer Matrix zurück.
	 * Nimmt eine Matrix (zu findende Determinate)
	 */
	public static BigDecimal determinate(Matrix matrix)
	{
		MathContext mc = new MathContext(9999, RoundingMode.HALF_EVEN);
		if(matrix.getDimensionX() == 0)
		{
			return BigDecimal.ZERO.setScale(9999, RoundingMode.HALF_EVEN);
		}
		else if(matrix.getDimensionX() == 1)
		{
			return matrix.getCell(0, 0).setScale(9999, RoundingMode.HALF_EVEN);
		}
		else if(matrix.getDimensionX() == 2)
		{
			return matrix.getCell(0, 0).multiply(matrix.getCell(1, 1), mc).add(matrix.getCell(1, 0).multiply(matrix.getCell(0, 1), mc).negate(), mc) ;
		}
		BigDecimal tmp = BigDecimal.ZERO.setScale(9999, RoundingMode.HALF_EVEN);
		for(int i = 0; i < matrix.getDimensionX(); i++)
		{
			BigDecimal j = matrix.getCell(i, 0).multiply(new BigDecimal(-1).setScale(9999, RoundingMode.HALF_EVEN).pow(i));
			tmp = tmp.add(j.multiply(determinate(kofaktor(i, 0, matrix)), mc), mc);
		}
		return tmp;
	}
	
	/**
	 * Multipliziert 2 Matrizen.
	 * Nimmt 2 Matrix (zu multiplizierende Matrix 1, zu multiplizierende Matrix 2)
	 */
	public static Matrix multiply2M(Matrix m1, Matrix m2)
	{
		Matrix tmp = new Matrix(m1.getDimensionX());
		MathContext mc = new MathContext(9999,  RoundingMode.HALF_UP);
		for(int x = 0; x < tmp.getDimensionX(); x++)
		{
			for(int y = 0; y < tmp.getDimensionX(); y++)
			{
				BigDecimal[] tmpX = m1.getRow(y);
				BigDecimal[] tmpY = m2.getColum(x);
				BigDecimal tmpZ = new BigDecimal(0);
				for(int k = 0; k < tmpX.length; k++)
				{
					tmpZ = tmpZ.add(tmpX[k].multiply(tmpY[k], mc));
				}
				tmp.setCell(x, y, tmpZ);
			}
		}
		return tmp;
	}
	
	/**
	 * Multipliziert eine Matrix mit einem Int.
	 * Nimmt 1 Matrix (zu multiplizierende Matrix) und 1 Int (zu multiplizierende Int)
	 */
	public static Matrix multiplyInt(Matrix m1, BigDecimal i1)
	{
		Matrix tmp = new Matrix(m1.getDimensionX());
		MathContext mc = new MathContext(9999, RoundingMode.HALF_EVEN);
		for(int x = 0; x < tmp.getDimensionX(); x++)
		{
			for(int y = 0; y < tmp.getDimensionX(); y++)
			{
				tmp.setCell(x, y, m1.getCell(x, y).multiply(i1, mc));
			}
		}
		return tmp;
	}
	
	/**
	 * Bestimmt den Kofaktor in einem angegebenen Punkt.
	 * Nimmt 2 Int (x und y position) und die Matrix (Element aus Matrix bestimmen)
	 */
	public static Matrix kofaktor(int sX, int sY, Matrix m)
	{
		Matrix tmp = new Matrix(m.getDimensionX()-1);
		for(int x = 0; x < m.getDimensionX(); x++)
		{
			for(int y = 0; y < m.getDimensionX(); y++)
			{
				if(x < sX && y < sY)
				{
					tmp.setCell(x, y, m.getCell(x, y));
				}
				else if(x > sX && y < sY)
				{
					tmp.setCell(x-1, y, m.getCell(x, y));
				}
				else if(x < sX && y > sY)
				{
					tmp.setCell(x, y-1, m.getCell(x, y));
				}
				else if(x > sX && y > sY)
				{
					tmp.setCell(x-1, y-1, m.getCell(x, y));
				}
			}
		}
		return tmp;
	}
	
	/**
	 * Gibt die Kofaktor matrix einer Matrix zurück.
	 * Nimmt eine Matrix (Zu bestimmende Matrix)
	 */
		
	public static Matrix kofaktorMatrix(Matrix m)
	{
		Matrix tmp = new Matrix(m.getDimensionX());
		for(int x = 0; x < tmp.getDimensionX(); x++)
		{
			for(int y = 0; y < tmp.getDimensionX(); y++)
			{
				tmp.setCell(x, y, new BigDecimal(-1).pow(x + y).setScale(9999, RoundingMode.HALF_EVEN).multiply(determinate(kofaktor(x, y, m))));
			}
		}
		return tmp; 
	}
	
	/**
	 * Transponiert eine Matrix.
	 * Nimmt eine Matrix (zu transponierende Matrix)
	 */
	public static Matrix transpose(Matrix m)
	{
		Matrix out = new Matrix(m.getDimensionX());
		for(int i = 0; i < m.getDimensionX(); i++)
		{
			out.setColum(m.getRow(i), i);
		}
		return out;
	}
	
}