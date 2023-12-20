package dev.hyyrokkin;

import javax.swing.JOptionPane;

//import java.math.BigDecimal;

import dev.hyyrokkin.math.MathOpperations;
import dev.hyyrokkin.math.Matrix;


public class Main {
    public static void main(String[] args) {
        try
        {
            switch(args[0])
            {

                case "verschlüsseln":

                    try
                    {
                        if(args[1] != null)
                        {
                            Matrix tmpT = MiscellaneousOpperations.generateMatrixFromString(args[1]);
                            Matrix tmpK = MiscellaneousOpperations.getKey(tmpT.getDimensionX());
                            Matrix tmpC = MathOpperations.multiply2M(tmpK, tmpT);

                            System.out.println("Das ist die verschlüsselte Matrix und String.");
                            tmpC.printMatrix();
                            System.out.print("\n");
                            System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpC));
                            System.out.print("\n\n\n");
                            System.out.println("Das ist der Schlüssel der genutzt wurde um die Matrix zu verschlüsselm.");
                            tmpK.printMatrix();
                            System.out.print("\n");
                            System.out.println(MiscellaneousOpperations.generateRawStringFromMatrix(tmpK));
                        }
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Benutze einen 'guten' String um eine verschlüsselte Matrix und einen Schlüssel zu erhalten.");
                    }
                    break;

                case "entschlüsseln":
                    try
                    {
                        if(args[1] != null)
                        {
                            Matrix tmpC = MiscellaneousOpperations.generateMatrixFromInt(args[1]);
                            Matrix tmpIK = MathOpperations.inverse(MiscellaneousOpperations.generateMatrixFromInt(args[2]));
                            Matrix tmpT = MathOpperations.multiply2M(tmpIK, tmpC);

                            System.out.println("Das ist der entschlüsselte Text");
                            tmpT.printMatrix();
                            System.out.println("\n" + MiscellaneousOpperations.generateStringFromMatrix(tmpT));
                        }
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Benutze einen verschlüsselten String ohne das letzte ',' und einen Schlüssel ohne das letzte ',' um die Matrix zu entschlüsseln.");
                    }
                    break;

                case "test":
                    MiscellaneousOpperations.testWorking();
                    break;
            }

        }
        catch(Exception ex)
        {
            System.out.println("Du hast etwas falsch gemacht!");
            System.out.println("Schreibe 'verschlüsseln' oder 'entschlüsseln' um Infos zu erhalten.");
            System.out.println("'test' gibt ein par Testwerte wieder.");
        }
    }
}
