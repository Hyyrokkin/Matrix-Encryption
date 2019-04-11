package dev.hyyrokkin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;

public abstract class MiscellaneousOpperations {
	
	/**
	 * Gibt eien quardratische Matrix mit zufälligen Elementen zurückl
	 * 	Nimmt ein Int(Größe der neuen Matrix in X und Y)
	 */
	public static Matrix generateRandomMatrix(int dimensionX) {
		Matrix m = new Matrix(dimensionX);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, new BigDecimal(rand.nextInt((128 - 1) + 1) + 1));
			}
		}
		return m;
	}
	
	/**
	 * Gibt eien beliebig große Matrix mit zufälligen Elementen zurückl
	 * 	Nimmt 2 Int(Größe der neuen Matrix in X, Größe der neuen Matrix in Y)
	 */
	public static Matrix generateRandomMatrix(int dimensionX, int demensionY) {
		Matrix m = new Matrix(dimensionX, demensionY);
		for (int i = 0; i < m.getDimensionX(); i++) {
			for (int k = 0; k < m.getDimensionX(); k++) {
				Random rand = new Random();
				m.setCell(i, k, new BigDecimal(rand.nextInt((128 - 1) + 1) + 1));
			}
		}
		return m;
	}
	
	/**
	 * Gibt eine Matrix zurück die als Schlüssel genutzt werden kann
	 */
	public static Matrix getKey(int dimensionX) {
		Matrix tmp = new Matrix(0);
		do{
			while(true) {
				try {
					tmp = generateRandomMatrix(dimensionX);
					new BigDecimal(1).setScale(9999, RoundingMode.HALF_EVEN).divide(MathOpperations.determinate(tmp).setScale(9999, RoundingMode.HALF_EVEN));
					break;
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}while(!MathOpperations.isInversibal(tmp));
		return tmp;
	}
	
	/**
	 * Generiert eine Matrix aud einem Buchstaben String
	 * 	Nimmt einen String(Außgangs String)
	 */
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
	
	/**
	 * Generirt eine Matrix aus einem String aus ascii Zahlen
	 * 	Beispiel: 123,456,789
	 */
	public static Matrix generateMatrixFromInt(String eingabe) {
		Matrix ende;
		String[] splitString = eingabe.split(",");
		BigDecimal rootM = new BigDecimal(splitString.length);
		int z = 0;

		rootM = rootM.sqrt(new MathContext(1, RoundingMode.HALF_UP));
		do {
			ende = new Matrix(rootM.intValue()) ;
			rootM.add(new BigDecimal(1));
		}while(ende.getDimensionX() * ende.getDimensionY() < splitString.length);
		
		rootM.subtract(new BigDecimal(1));

		for(int x = 0; x < rootM.intValue(); x++) {
			for(int y = 0; y < rootM.intValue(); y++) {
					ende.setCell(x, y, new BigDecimal(splitString[z]));
					z++;
			}
		}				
		return ende;
	}
	
	/**
	 * Convertiert einen String aus ascii Zahlen in Buchstaben
	 * 	Nimmt einen String, Beispiel: 123,456,789
	 */
	public static String generateStringFromMatrix(Matrix m) {
		
		String tmpS = "";
		
		for(int x = 0; x < m.getDimensionX(); x++) {
			for(int y = 0; y < m.getDimensionY(); y++) {
				tmpS = tmpS + (char) m.getCell(x, y).intValue();
			}
		}
		
		return tmpS;
		
	}
	
	/**
	 * Gibt einen String aus indem die werte der der matrix sind
	 */
	public static String generateRawStringFromMatrix(Matrix m) {
		
		String tmpS = "";
		
		for(int x = 0; x < m.getDimensionX(); x++) {
			for(int y = 0; y < m.getDimensionY(); y++) {
				tmpS = tmpS + m.getCell(x, y).intValue() + ",";
			}
		}
		
		return tmpS;
		
	}

	
}