package dev.hyyrokkin.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class MathOpperations {

	/**
	 * Invertiert eine Matrix
	 * 	Nimmt eine Matrix(zu invertirende MAtrix)
	 */
	public static Matrix inverse(Matrix m){
		Matrix ret = new Matrix(1);
		if(isInversibal(m)) {
			ret = multiplyInt(transpose(kofaktorMatrix(m)), new BigDecimal(1).setScale(9999, RoundingMode.HALF_EVEN).divide(determinate(m).setScale(9999, RoundingMode.HALF_EVEN)));
		}
		return ret;
	}
	
	/**
	 * Gibt an ob eine Matrix Inversierbar ist
	 * 	Nimmt eine Matrix(zu überprüfende Matrix)
	 */
	public static boolean isInversibal(Matrix matrix) {
		if(determinate(matrix).compareTo(new BigDecimal(0)) != 0 && isSquare(matrix)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt die Determinate einer Matrix zurück
	 * 	Nimmt eine Matrix(zu findende Determinate)
	 */
	public static BigDecimal determinate(Matrix matrix) {
		if(matrix.getDimensionX() == 0) {
			return new BigDecimal(0);
		} else if(matrix.getDimensionX() == 1) {
			return matrix.getCell(0, 0);
		} else if(matrix.getDimensionX() == 2) {
			return matrix.getCell(0, 0).multiply(matrix.getCell(1, 1)).add(matrix.getCell(1, 0).multiply(matrix.getCell(0, 1)).negate()) ;
		}
		BigDecimal tmp = new BigDecimal(0);
		for(int i = 0; i < matrix.getDimensionX(); i++) {
			tmp = tmp.add(matrix.getCell(i, 0).multiply(new BigDecimal(-1).pow(0 + i)).multiply(determinate(kofaktor(i, 0, matrix))));
		}
		return tmp;
	}
	
	/**
	 * Gibt zurück ob eine Matrix quardratisch ist
	 * 	Nimmt eine Matrix(zu überprüfende Matrix)
	 */
	public static boolean isSquare(Matrix matrix) {
		if(matrix.getDimensionX() == matrix.getDimensionY()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt zurück ob 2 Matritzen multiplizierbar sind
	 * 	Nimmt 2 Matrix(zu überprüfende 1, zu überprüfende 2)
	 */
	public static boolean isMultipliable(Matrix m1, Matrix m2) {
		if(m1.getDimensionY() == m2.getDimensionX()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Multiplieziert 2 Matritzen
	 * 	Nimmt 2 Matrix(zu multipliezirende Matrix 1, zu multipliezirende Matrix 2)
	 */
	public static Matrix multiply2M(Matrix m1, Matrix m2) {
		Matrix tmp = new Matrix(m1.getDimensionY(), m2.getDimensionX());
		if(isMultipliable(m1, m2)) {
			for(int x = 0; x < tmp.getDimensionX(); x++) {
				for(int y = 0; y < tmp.getDimensionY(); y++) {
					BigDecimal[] tmpX = m1.getRow(y);
					BigDecimal[] tmpY = m2.getColum(x);
					BigDecimal tmpZ = new BigDecimal(0);
					for(int k = 0; k < tmpX.length; k++) {
						tmpZ = tmpZ.add(tmpX[k].multiply(tmpY[k]));
					}
					tmp.setCell(x, y, tmpZ); 
				}
			}
		}else {
			System.out.println("Error");
		}
		return tmp;
	}
	
	/**
	 * Multipliezirt eine Matrix mit einem Int
	 * 	Nimmt 1 Matrix(zu multipliezirende Matrix) und 1 Int(zu multipliezirende Int)
	 */
	public static Matrix multiplyInt(Matrix m1, BigDecimal i1) {
		Matrix tmp = new Matrix(m1.getDimensionX(), m1.getDimensionY());
			for(int x = 0; x < tmp.getDimensionX(); x++) {
				for(int y = 0; y < tmp.getDimensionY(); y++) {
					tmp.setCell(x, y, m1.getCell(x, y).multiply(i1)); 
				}
		}
		return tmp;
	}
	
	/**
	 * Bestimmt den Kofaktor in einem angegebenen Punkt
	 * 	Nimmt 2 Int(x und y position) und die Matrix(Element aus Matrix bestimmen)
	 */
	public static Matrix kofaktor(int sX, int sY, Matrix m){
		Matrix tmp = new Matrix(m.getDimensionX()-1);
		for(int x = 0; x < m.getDimensionX(); x++) {
			for(int y = 0; y < m.getDimensionY(); y++) {
				if(x < sX && y < sY) {
					tmp.setCell(x, y, m.getCell(x, y));
				}else if(x > sX && y < sY) {
					tmp.setCell(x-1, y, m.getCell(x, y));
				}else if(x < sX && y > sY) {
					tmp.setCell(x, y-1, m.getCell(x, y));
				}else if(x > sX && y > sY) {
					tmp.setCell(x-1, y-1, m.getCell(x, y));
				}
			}
		}
		return tmp;
	}
	
	/**
	 * Gibt die Kofaktormatrix einer Matrix zurück
	 *	Nimmt eine Matrix(Zu bestimmende Matrix)
	 */
		
	public static Matrix kofaktorMatrix(Matrix m) {
		Matrix tmp = new Matrix(m.getDimensionX());
		for(int x = 0; x < tmp.getDimensionX(); x++) {
			for(int y = 0; y < tmp.getDimensionY(); y++) {
				tmp.setCell(x, y, new BigDecimal(-1).pow(x + y).multiply(determinate(kofaktor(x, y, m))));
			}
		}
		return tmp; 
	}
	
	/**
	 * Transponiert eine Matrix
	 * 	Nimmt eine Matrix(zu tranasponierende Matrix)
	 */
	public static Matrix transpose(Matrix m) {
		Matrix end = new Matrix(m.getDimensionX());
		for(int i = 0; i < m.getDimensionX(); i++) {
			end.setColum(m.getRow(i), i);
		}
		return end;
	}
	
}
