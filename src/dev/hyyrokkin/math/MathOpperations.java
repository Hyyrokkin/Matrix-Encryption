package dev.hyyrokkin.math;

public abstract class MathOpperations {

	public static Matrix inverse(Matrix m){
		return multiplyInt(transpose(kofaktorMatrix(m)), 1 / determinate(m));
	}
	
	public static boolean isInversibal(Matrix matrix) {
		if(determinate(matrix) != 0 && isSquare(matrix)) {
			return true;
		}
		return false;
	}
	
	public static double determinate(Matrix matrix) {
		if(matrix.getDimensionX()<=2) {
			return matrix.getCell(0, 0) * matrix.getCell(1, 1) - matrix.getCell(1, 0) * matrix.getCell(0, 1);
		}
		double tmp = 0;
		for(int i = 0; i < matrix.getDimensionX(); i++) {
			tmp = tmp + (matrix.getCell(i, 0)* Math.pow(-1, 0 + i)) * (determinate(kofaktor(i, 0, matrix)));
		}
		return tmp;
	}
	

	public static boolean isSquare(Matrix matrix) {
		if(matrix.getDimensionX() == matrix.getDimensionY()) {
			return true;
		}
		return false;
	}
	
	public static boolean isMultipliable(Matrix m1, Matrix m2) {
		if(m1.getDimensionY() == m2.getDimensionX()) {
			return true;
		}
		return false;
	}
	
	public static Matrix multiply2M(Matrix m1, Matrix m2) {
		Matrix tmp = new Matrix(m1.getDimensionY(), m2.getDimensionX());
		if(isMultipliable(m1, m2)) {
			for(int x = 0; x < tmp.getDimensionX(); x++) {
				for(int y = 0; y < tmp.getDimensionY(); y++) {
					double[] tmpX = m1.getRow(y);
					double[] tmpY = m2.getColum(x);
					double tmpZ = 0;
					for(int k = 0; k < tmpX.length; k++) {
						tmpZ =+ tmpX[k] * tmpY[k];
					}
					tmp.setCell(x, y, tmpZ); 
				}
			}
		}else {
			System.out.println("Error");
		}
		return tmp;
	}
	
	public static Matrix multiplyInt(Matrix m1, double i1) {
		Matrix tmp = new Matrix(m1.getDimensionX(), m1.getDimensionY());
			for(int x = 0; x < tmp.getDimensionX(); x++) {
				for(int y = 0; y < tmp.getDimensionY(); y++) {
					tmp.setCell(x, y, i1 * m1.getCell(x, y)); 
				}
		}
		return tmp;
	}
	
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
	
	public static Matrix kofaktorMatrix(Matrix m) {
		Matrix tmp = new Matrix(m.getDimensionX());
		for(int x = 0; x < tmp.getDimensionX(); x++) {
			for(int y = 0; y < tmp.getDimensionY(); y++) {
				tmp.setCell(x, y, determinate(kofaktor(x, y, m)) * Math.pow(-1, x + y));
			}
		}
		return tmp;
	}
	
	public static Matrix transpose(Matrix m) {
		Matrix end = new Matrix(m.getDimensionX());
		for(int i = 0; i < m.getDimensionX(); i++) {
			end.setColum(m.getRow(i), i);
		}
		return end;
	}
	
}
