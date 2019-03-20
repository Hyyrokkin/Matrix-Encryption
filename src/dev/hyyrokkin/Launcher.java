package dev.hyyrokkin;

//import java.math.BigDecimal;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;


public class Launcher {

	public static void main(String[] args) {
	
		switch(args[0]){
		
		case "encrypt":	
			
			if(args[1] == null) {
				System.out.println("Use a 'good' String to get a encrypted matrix and a key matrix");
			}else {
				Matrix tmpT = MiscellaneousOpperations.generateMatrixFromString(args[1]);
				Matrix tmpK = MiscellaneousOpperations.getKey(tmpT.getDimensionX());
				Matrix tmpC = MathOpperations.multiply2M(tmpK, tmpT);
				System.out.println("This is the encrypted Matrix and String.");
				tmpC.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpC));
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("This is the key that was used to encrypt the Matrix.");
				tmpK.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpK));
			}
			break;
			
		case "decrypt":	
			
			if(args[1] == null) {
				System.out.println("Use a encrypted String without the last ',' and an key without the lalst ',' to decrypt");
			}else {
				Matrix tmpC = MiscellaneousOpperations.generateMatrixFromInt(args[1]);
				Matrix tmpIK = MathOpperations.inverse(MiscellaneousOpperations.generateMatrixFromInt(args[2]));
				Matrix tmpT = MathOpperations.multiply2M(tmpIK, tmpC);
				System.out.println("This is the decrypted Text.");
				tmpT.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateStringFromMatrix(tmpT));
				
			}
			
			break;
			
		case "test":
			
			testWorking();
			break;
			
		default:
			
			System.out.println("You have done something wrong!");
			System.out.println("Use encrypt or decrypt to get some info.");
			System.out.println("'test' gives u a exapel for values.");
			break;
		}
	}
	
	@SuppressWarnings("unused")
	private static void testWorking() {
		Matrix matrixT = MiscellaneousOpperations.generateMatrixFromString("Hallo was");
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
		System.out.println("Schlüssel in Raw");
		System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(matrixS));
		
		System.out.println("");
		System.out.println("Chiffre");
		matrixC.printMatrix();
		System.out.println("Determinate von der Chiffre");
		System.out.println(MathOpperations.determinate(matrixC));
		System.out.println("Ciffre in Raw");
		System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(matrixC));
		
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
