import java.util.Scanner;
import java.util.*;
public class VectorForma1 {

    public class VectorF1
    {
        //PROPIEDADES
        public int VectorFinal[];
        public int Du;
        public int Dimension;

        //CONSTRUCTOR
    }


    public static void Menu()
    {
        System.out.println("SISTEMA DE POLINOMIOS X3000");
        System.out.println("[1] Insertar Dato");
        System.out.println("[2] Eliminar Dato");
        System.out.println("[3] Mostrar Forma 1");
        System.out.println("[4] Mostrar Forma 2");
        System.out.println("[5] Mostrar nuevo String");
        System.out.println("[6] Operaciones");
        System.out.println("[7] Salir");
    }


    public static void main(String[] args) {
        //int nI = Integer.parseInt(n);
        System.out.println("Por Favor, colocarle el signo al primer termino y una C al final");
        Scanner entradaEscaner = new Scanner(System.in);
        String Polinomio = entradaEscaner.nextLine();

        int Term = 0, x = 0, i = 0, Cantidad = Polinomio.length(), Bandera = 0, j=0, C=0, Du, Posc;
        String CTerminos = "";
        String CExponent = "";

        char p[] = new char[Cantidad];
        p = Polinomio.toCharArray();

        int VectorC[] = new int[Cantidad];
        int VectorE[] = new int[Cantidad];
        int VectorFinal[] = new int[Cantidad];
        int VectorForme2[] = new int[Cantidad];
        //CANTIDAD DE TERMINOS
        for (i = 0; i < Cantidad; i++) {
            if (Polinomio.charAt(i) == '+' || Polinomio.charAt(i) == '-') {
                Term++;
            }
        }
        i = 0;
        // CICLO SEGUN NUMERO DE TERMINOS
        /* RECORRER CADA TERMINO */

        while (j < Term) {
            //MAS O MENOS
            if (p[i] == '+') {
                i++;
                if (p[i] == 'X' || p[i] == 'x') {

                    CTerminos = CTerminos + "1";
                    i++;
                } else {
                    while (p[i] != 'X' && p[i] != 'x' && p[i] != 'C') {
                        CTerminos += Character.toString(p[i]);
                        i++;
                    }
                }

            } else if (p[i] == '-') {
                CTerminos = CTerminos + "-";
                i++;

                if (p[i] == 'X' || p[i] == 'x') {
                    CTerminos = CTerminos + "1";
                    i++;

                } else {
                    while (p[i] != 'X' && p[i] != 'x' && p[i] != 'C') {
                        CTerminos += Character.toString(p[i]);
                        i++;
                    }
                }
            }

            //EXPONENTES
            if (p[i] == 'X' || p[i] == 'x') {
                if (p[i + 1] == '^') {
                    i += 2;
                    while (p[i] != '+' && p[i] != '-' && p[i] != 'C') {
                        CExponent += Character.toString(p[i]);
                        i++;
                    }
                } else {
                    CExponent = CExponent + "1";
                }
            }else if(p[i] == 'C')
            {
                CExponent = CExponent + "0";
            }

            j++;
            VectorC[j] = Integer.parseInt(CTerminos);
            VectorE[j] = Integer.parseInt(CExponent);
            CTerminos = "";
            CExponent = "";
        }

        //MAYOR EXPONENTE

        int Mayor = VectorE[0];

        for(i=0; i<Cantidad; i++)
        {
            if(VectorE[i] > Mayor)
            {
                Mayor = VectorE[i];
            }
        }

        //LLENAR EL VECTOR FORMA 1
        VectorFinal[0] = Mayor;
        Du = VectorFinal[0] + 1;

        for (i = 0; i < Cantidad; i++)
        {
            Posc = Du - VectorE[i];
            VectorFinal[Posc] = VectorC[i];
        }

        //VECTOR FORMA 2
        x=1;
        int DuF2 = Term*2;
        VectorForme2[0] = Term;
        for(i = 1; i <= DuF2; i++)
        {
            VectorForme2[x] = VectorC[i];
            x+=2;
        }

        x=2;
        for(i = 1; i <= DuF2; i++)
        {
            VectorForme2[x] = VectorE[i];
            x+=2;
        }

        //MENU E INTERACION
        Scanner EntradaOpcion = new Scanner(System.in);
        int opc = EntradaOpcion.nextInt();

        switch (opc)
        {
            /*
            System.out.println("[1] Insertar Dato");
            System.out.println("[2] Eliminar Dato");
            System.out.println("[3] Mostrar Forma 1");
            System.out.println("[4] Mostrar Forma 2");
            System.out.println("[5] Mostrar nuevo String");
            System.out.println("[6] Operaciones");
            */

            case 1: break;
            case 2: break;
            case 3:

                System.out.println("VECTOR FORMA 1");
                for(i = 0; i < Du; i++)
                {
                    System.out.println(VectorFinal[i]);
                }break;

            case 4:

                System.out.println("VECTOR FORMA 2");
                for(i = 0; i <= DuF2; i++)
                {
                    System.out.println(VectorForme2[i]);
                }break;

            case 5: break;
            case 6: break;
        }



    }
}