package dev.hyyrokkin;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;


public class Launcher {

	public static void main(String[] args) {
		Matrix matrixC = MiscellaneousOpperations.generateRandomMatrix(5);
		Matrix matrixK = MiscellaneousOpperations.getKey(5);
		Matrix matrixV = MathOpperations.multiply2M(matrixK, matrixC);
		
		System.out.println("Text");
		matrixC.printMatrix();
		System.out.println("Schlüssel");
		matrixK.printMatrix();
		System.out.println("Ciffre");
		matrixV.printMatrix();
		System.out.println("Ergebniss");
		MathOpperations.multiply2M(MathOpperations.inverse(matrixK), matrixV).printMatrix();	
	}

}
