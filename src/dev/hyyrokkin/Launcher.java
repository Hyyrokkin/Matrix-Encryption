package dev.hyyrokkin;

//import java.math.BigDecimal;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;


public class Launcher {

	public static void main(String[] args) {
	
			testWorking();
		
	}
	
	@SuppressWarnings("unused")
	private static void testWorking() {
		Matrix matrixT = MiscellaneousOpperations.generateMatrixFromString("ajkr fzmolb 7f20");
		Matrix matrixS = MiscellaneousOpperations.getKey(matrixT.getDimensionX());
		Matrix matrixC = MathOpperations.multiply2M(matrixS, matrixT);
		Matrix matrixIS = MathOpperations.inverse(matrixS);
		Matrix matrixE = MathOpperations.multiply2M(matrixIS, matrixC);
		
		System.out.println("Text");
		matrixT.printMatrix();
		System.out.println("Determinate vom Text");
		System.out.println(MathOpperations.determinate(matrixT));

		System.out.println("");	
		System.out.println("Schlüssel");
		matrixS.printMatrix();
		System.out.println("Determinate vom Schlüssel");
		System.out.println(MathOpperations.determinate(matrixS));
		
		System.out.println("");
		System.out.println("Chiffre");
		matrixC.printMatrix();
		System.out.println("Determinate von der Chiffre");
		System.out.println(MathOpperations.determinate(matrixC));
		
		System.out.println("");
		System.out.println("Inverser Sclüssel");
		matrixIS.printMatrix();
		System.out.println("Determinate vom Inversen Schlüssel");
		System.out.println(MathOpperations.determinate(matrixIS));
		
		
		System.out.println("");
		System.out.println("Ergebniss");
		matrixE.printMatrix();
		System.out.println("Determinate vom Ergebniss");
		System.out.println(MathOpperations.determinate(matrixE));
		
		System.out.println(MiscellaneousOpperations.generateStringFromMatrix(matrixE));
	}

}
