package dev.hyyrokkin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;

public abstract class MiscellaneousOpperations {
	
	public static Matrix generateRandomMatrix(int dimensionX) {
		Matrix m = new Matrix(dimensionX);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, new BigDecimal(rand.nextInt((10 - 1) + 1) + 1));
			}
		}
		return m;
	}
	
	public static Matrix generateRandomMatrix(int dimensionX, int demensionY) {
		Matrix m = new Matrix(dimensionX, demensionY);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, new BigDecimal(rand.nextInt((10 - 1) + 1) + 1));
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
	
	public static Matrix generateMatrixFromString(String eingabe) {
		char[] tmp = eingabe.toCharArray();
		int[] ascii = new int[tmp.length];
		BigDecimal rootM = new BigDecimal(tmp.length);
		Matrix ende;
		int z = 0;
		
		for(int k = 0; k < tmp.length; k++) {
			ascii[k] = (int) tmp[k];
		}
		
		rootM = rootM.sqrt(new MathContext(1, RoundingMode.HALF_UP));
		do {
			ende = new Matrix(rootM.intValue()) ;
			rootM.add(new BigDecimal(1));
		}while(ende.getDimensionX() * ende.getDimensionY() < ascii.length);
		
		rootM.subtract(new BigDecimal(1));
		
		for(int x = 0; x < rootM.intValue(); x++) {
			for(int y = 0; y < rootM.intValue(); y++) {
				if(z != ascii.length) {
					ende.setCell(x, y, new BigDecimal(ascii[z]));
					z++;
				}
			}
		}
		
		return ende;
	}
	
}
