package dev.hyyrokkin;

import java.util.Random;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;

public abstract class MiscellaneousOpperations {
	
	public static Matrix generateRandomMatrix(int dimensionX) {
		Matrix m = new Matrix(dimensionX);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, rand.nextInt((10 - 1) + 1) + 1);
			}
		}
		return m;
	}
	
	public static Matrix generateRandomMatrix(int dimensionX, int demensionY) {
		Matrix m = new Matrix(dimensionX, demensionY);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, rand.nextInt((10 - 1) + 1) + 1);
			}
		}
		return m;
	}
	
	public static Matrix getKey(int dimensionX) {
		Matrix tmp;
		do{
			tmp = generateRandomMatrix(dimensionX);
		}while(!MathOpperations.isInversibal(tmp));
		return tmp;
	}
	
}
