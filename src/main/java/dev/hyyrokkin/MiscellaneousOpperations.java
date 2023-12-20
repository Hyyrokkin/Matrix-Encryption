package dev.hyyrokkin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;

public class MiscellaneousOpperations {
	
	/**
	 * Gibt eien quardratische Matrix mit zufälligen Elementen zurückl
	 * 	Nimmt ein Int(Größe der neuen Matrix in X und Y)
	 */
	public static Matrix generateRandomMatrix(int dimensionX)
	{
		Matrix m = new Matrix(dimensionX);
		Random rand = new Random();
		for (int i = 0; i < m.getDimensionX(); i++)
		{
			for (int k = 0; k < m.getDimensionX(); k++)
			{
				m.setCell(i, k, new BigDecimal(rand.nextInt(128 ) + 1).setScale(9999, RoundingMode.HALF_EVEN));
			}
		}
		return m;
	}
	
	/**
	 * Gibt eine Matrix zurück die als Schlüssel genutzt werden kann
	 */
	public static Matrix getKey(int dimensionX)
	{
		Matrix tmp;
		do
		{
			tmp = generateRandomMatrix(dimensionX);
		}
		while(!MathOpperations.isInversibal(tmp));
		return tmp;
	}
	
	/**
	 * Generiert eine Matrix aud einem Buchstaben String
	 * 	Nimmt einen String(Außgangs String)
	 */
	public static Matrix generateMatrixFromString(String eingabe)
	{
		char[] tmp = eingabe.toCharArray();
		int[] ascii = new int[tmp.length];
		BigDecimal rootM = new BigDecimal(tmp.length);
		Matrix ende;
		int z = 0;
		
		for(int k = 0; k < tmp.length; k++)
		{
			ascii[k] = tmp[k];
		}
		MathContext mc = new MathContext(1, RoundingMode.HALF_UP);
		rootM = rootM.sqrt(mc).round(mc);
		do
		{
			ende = new Matrix(rootM.intValue()) ;
			rootM = rootM.add(BigDecimal.ONE);
		}
		while(ende.getDimensionX() * ende.getDimensionX() < ascii.length);
		
		for(int x = 0; x < rootM.intValue() - 1; x++)
		{
			for(int y = 0; y < rootM.intValue() - 1; y++)
			{
				if(z != ascii.length)
				{
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
	public static Matrix generateMatrixFromInt(String eingabe)
	{
		Matrix ende;
		String[] splitString = eingabe.split(",");
		BigDecimal rootM = new BigDecimal(splitString.length);
		int z = 0;

		rootM = rootM.sqrt(new MathContext(9999, RoundingMode.HALF_EVEN));
		do
		{
			ende = new Matrix(rootM.intValue()) ;
			rootM = rootM.add(BigDecimal.ONE);
		}
		while(ende.getDimensionX() * ende.getDimensionX() < splitString.length);

		for(int x = 0; x < rootM.intValue(); x++)
		{
			for(int y = 0; y < rootM.intValue(); y++)
			{
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
	public static String generateStringFromMatrix(Matrix m)
	{
		
		StringBuilder tmpS = new StringBuilder();
		MathContext mc = new MathContext(3, RoundingMode.HALF_EVEN);

		for(int x = 0; x < m.getDimensionX(); x++)
		{
			for(int y = 0; y < m.getDimensionX(); y++)
			{
				tmpS.append((char) m.getCell(x, y).round(mc).intValue());
			}
		}
		
		return tmpS.toString();
		
	}
	
	/**
	 * Gibt einen String aus indem die werte der der matrix sind
	 */
	public static String generateRawStringFromMatrix(Matrix m)
	{
		
		StringBuilder tmpS = new StringBuilder();
		
		for(int x = 0; x < m.getDimensionX(); x++)
		{
			for(int y = 0; y < m.getDimensionX(); y++)
			{
				tmpS.append(m.getCell(x, y).intValue()).append(",");
			}
		}
		
		return tmpS.toString();
		
	}

	static void testWorking()
	{
		//String eingabe = "Hallo was";
		//String eingabe = "Hallo was ist ds";
		//String eingabe = "Jo Bro das ist cool";
		String eingabe = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr";
		Matrix matrixT = generateMatrixFromString(eingabe);
		System.out.println("eingabe fertig");
		Matrix matrixS = getKey(matrixT.getDimensionX());
		System.out.println("key fertig");
		Matrix matrixC = MathOpperations.multiply2M(matrixS, matrixT);
		System.out.println("Chiffre fertig");
		Matrix matrixIS = MathOpperations.inverse(matrixS);
		System.out.println("inverse fertig");
		Matrix matrixE = MathOpperations.multiply2M(matrixIS, matrixC);
		System.out.println("entschlüsselt fertig");

		System.out.println("Text");
		System.out.println(eingabe);
		matrixT.printMatrix();
		System.out.println("Determinate vom Text");
		System.out.println(MathOpperations.determinate(matrixT).intValue());

		System.out.println();
		System.out.println("Schlüssel");
		matrixS.printMatrix();
		System.out.println("Determinate vom Schlüssel");
		System.out.println(MathOpperations.determinate(matrixS).intValue());
		System.out.println("Schlüssel in Raw");
		System.out.println(generateRawStringFromMatrix(matrixS));

		System.out.println();
		System.out.println("Chiffre");
		matrixC.printMatrix();
		System.out.println("Determinate von der Chiffre");
		System.out.println(MathOpperations.determinate(matrixC).intValue());
		System.out.println("Ciffre in Raw");
		System.out.println(generateRawStringFromMatrix(matrixC));

		System.out.println();
		System.out.println("Inverser Schlüssel");
		matrixIS.printMatrix();
		System.out.println("Determinate vom Inversen Schlüssel");
		System.out.println(MathOpperations.determinate(matrixIS).intValue());


		System.out.println();
		System.out.println("Ergebniss");
		matrixE.printMatrix();
		System.out.println("Determinate vom Ergebniss");
		System.out.println(MathOpperations.determinate(matrixE).intValue());

		System.out.println(generateStringFromMatrix(matrixE));
	}

	
}