package dev.hyyrokkin;

//import java.math.BigDecimal;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;


public class Launcher {

	public static void main(String[] args) {
	
		switch(args[0]){
		
		case "verschl�sseln":	
			
			if(args[1] == null) {
				System.out.println("Benutze einen 'guten' String um eine verschl�sselte Matrix und einen Schl�ssel zu erhalten.");
			}else {
				Matrix tmpT = MiscellaneousOpperations.generateMatrixFromString(args[1]);
				Matrix tmpK = MiscellaneousOpperations.getKey(tmpT.getDimensionX());
				Matrix tmpC = MathOpperations.multiply2M(tmpK, tmpT);
				System.out.println("Das ist die verschl�sselte Matrix und String.");
				tmpC.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpC));
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("Das ist der Schl�ssel der genutzt wurde um die Matrix zu verschl�sselm.");
				tmpK.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpK));
			}
			break;
			
		case "entschl�sseln":	
			
			if(args[1] == null) {
				System.out.println("Benutze einen verschl�sselten String ohne das letzte ',' und einen Schl�ssel ohne das letzte ',' um die Matrix zu entschl�sseln.");
			}else {
				Matrix tmpC = MiscellaneousOpperations.generateMatrixFromInt(args[1]);
				Matrix tmpIK = MathOpperations.inverse(MiscellaneousOpperations.generateMatrixFromInt(args[2]));
				Matrix tmpT = MathOpperations.multiply2M(tmpIK, tmpC);
				System.out.println("Das ist der entschl�sselte Text");
				tmpT.printMatrix();
				System.out.println("");
				System.out.println(MiscellaneousOpperations.generateStringFromMatrix(tmpT));
				
			}
			
			break;
			
		case "test":
			
			testWorking();
			break;
			
		default:
			
			System.out.println("Du hast etwas falsch gemacht!");
			System.out.println("Schreibe 'verschl�sseln' oder 'entschl�sseln' um Infos zu erhalten.");
			System.out.println("'test' gibt ein par Testwerte wieder.");
			break;
		}
	}

	private static void testWorking() {
		Matrix matrixT = MiscellaneousOpperations.generateMatrixFromString("Hallo was");
		Matrix matrixS = MiscellaneousOpperations.getKey(matrixT.getDimensionX());
		Matrix matrixC = MathOpperations.multiply2M(matrixS, matrixT);
		Matrix matrixIS = MathOpperations.inverse(matrixS);
		Matrix matrixE = MathOpperations.multiply2M(matrixIS, matrixC);
		
		System.out.println("Text");
		System.out.println("Hallo was");
		matrixT.printMatrix();
		System.out.println("Determinate vom Text");
		System.out.println(MathOpperations.determinate(matrixT));

		System.out.println("");	
		System.out.println("Schl�ssel");
		matrixS.printMatrix();
		System.out.println("Determinate vom Schl�ssel");
		System.out.println(MathOpperations.determinate(matrixS));
		System.out.println("Schl�ssel in Raw");
		System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(matrixS));
		
		System.out.println("");
		System.out.println("Chiffre");
		matrixC.printMatrix();
		System.out.println("Determinate von der Chiffre");
		System.out.println(MathOpperations.determinate(matrixC));
		System.out.println("Ciffre in Raw");
		System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(matrixC));
		
		System.out.println("");
		System.out.println("Inverser Scl�ssel");
		matrixIS.printMatrix();
		System.out.println("Determinate vom Inversen Schl�ssel");
		System.out.println(MathOpperations.determinate(matrixIS));
		
		
		System.out.println("");
		System.out.println("Ergebniss");
		matrixE.printMatrix();
		System.out.println("Determinate vom Ergebniss");
		System.out.println(MathOpperations.determinate(matrixE));
		
		System.out.println(MiscellaneousOpperations.generateStringFromMatrix(matrixE));
	}

}
