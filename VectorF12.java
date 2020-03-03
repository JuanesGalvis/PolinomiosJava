import java.util.Scanner;
import java.util.*;
public class VectorF12 {

    /* ===============================================================
    AJUSTAR
    =============================================================== */
    public static void Ajustar(int [] V)
    {
        int DuT = V[0]+1, i = 1, C = 0;

        //CONTAR LOS PRIMEROS CEROS
        while( V[i] == 0 )
        {
            C++;
            i++;
        }

        //ORGANIZAR COEFICIENTES
        for (int x = 1; x < DuT; x++)
        {
            V[x] = V[x+C];
        }

        //ORGANIZAR GRADO MAYOR
        V[0] = V[0] - C;

    }


    /* ===============================================================
    INSERTAR DATO
    =============================================================== */
    public static void InsertarDato(int[] a)
    {
        System.out.println("Por Favor, colocarle el signo al primer termino y una C al final");
        Scanner EntradaTermino = new Scanner(System.in);
        String NTermino = EntradaTermino.nextLine();
        char T[];
        String CTerminos = "", CExponent = "";
        T = NTermino.toCharArray();
        int Cant = NTermino.length();
        for( int i = 0; i < Cant; i++ )
        {
            if (T[i] == '+') {
                i++;
                if (T[i] == 'X' || T[i] == 'x') {

                    CTerminos = CTerminos + "1";
                    i++;
                } else {
                    while (T[i] != 'X' && T[i] != 'x' && T[i] != 'C') {
                        CTerminos += Character.toString(T[i]);
                        i++;
                    }
                }

            } else if (T[i] == '-') {
                CTerminos = CTerminos + "-";
                i++;

                if (T[i] == 'X' || T[i] == 'x') {
                    CTerminos = CTerminos + "1";
                    i++;

                } else {
                    while (T[i] != 'X' && T[i] != 'x' && T[i] != 'C') {
                        CTerminos += Character.toString(T[i]);
                        i++;
                    }
                }
            }

            //EXPONENTES
            if (T[i] == 'X' || T[i] == 'x') {
                if (T[i + 1] == '^') {
                    i += 2;
                    while (T[i] != '+' && T[i] != '-' && T[i] != 'C') {
                        CExponent += Character.toString(T[i]);
                        i++;
                    }
                } else {
                    CExponent = CExponent + "1";
                }
            }else if(T[i] == 'C')
            {
                CExponent = CExponent + "0";
            }
        }

        int DuT = a[0]+1;
        int Posc = DuT - Integer.parseInt(CExponent);

        if( a[Posc] != 0 )
        {
            a[Posc] += Integer.parseInt(CTerminos);
        }else
        {
            a[Posc] = Integer.parseInt(CTerminos);
        }

        if(a[1] == 0)
        {
            Ajustar(a);
        }

        System.out.println("DATO INSERTADO CORRECTAMENTE");
    }

    /* ===============================================================
    IMPRIMIR POLINOMIO
    =============================================================== */
    public static void ImprimirPolinomio(int[] b)
    {
        int DuT = b[0]+1, i=1;
        String Cadena = "";
        for (i = 1; i < DuT; i++)
        {
            int Exp = DuT - i;

            if(Exp != 0 && Exp != 1)
            {
                if(b[i] > 0)
                {
                    Cadena = Cadena+"+"+b[i]+"X^"+Exp;

                }else if(b[i] < 0)
                {
                    Cadena = Cadena+""+b[i]+"X^"+Exp;
                }else
                {
                    Cadena = Cadena+"";
                }

            }else if(Exp == 1)
            {
                if(b[i] > 0)
                {
                    Cadena = Cadena+"+"+b[i]+"X";
                }else
                {
                    Cadena = Cadena+""+b[i]+"X";
                }

            }else
            {
                if(b[i] > 0)
                {
                    Cadena = Cadena+"+"+b[i];
                }else
                {
                    Cadena = Cadena+""+b[i]+"";
                }
            }
        }
        System.out.println(Cadena);
    }

    /* ===============================================================
    ELIMINAR DATO
    =============================================================== */
    public static void EliminarDato(int[] c, int opc)
    {
        int DuT = c[0]+1;
        int Posc = 0;

        switch (opc)
        {
            case 1:

                System.out.println("Inserte El exponente que quiere eliminar: ");
                Scanner Nexp = new Scanner(System.in);
                int Exponente = Nexp.nextInt();

                Posc = DuT - Exponente;
                c[Posc] = 0;

                if(c[1] == 0)
                {
                    Ajustar(c);
                }
                break;

            case 2:

                System.out.println("Inserte el coeficiente a eliminar: ");
                Scanner Ncoe = new Scanner(System.in);
                int Coeficiente = Ncoe.nextInt();

                for(int i=1; i < DuT; i++)
                {
                    if(c[i] == Coeficiente)
                    {
                        c[i] = 0;
                    }
                }

                if(c[1] == 0)
                {
                    Ajustar(c);
                }

                break;
        }
    }

    /* ===============================================================
    EVALUAR
    =============================================================== */
    public static void Evaluar(int [] V, int X)
    {
        int DuT = V[0]+1;
        int Result = 0, Elevado = X;

       for(int i = 1; i < DuT; i++)
       {
           for(int j = 1; j < (DuT - i); j++)
           {
             Elevado *= X;
           }

           Result += V[i]*Elevado;
           Elevado = X;
       }

        System.out.println("RESULTADO: "+Result);
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
        System.out.println("[7] Evaluar");
        System.out.println("[8] Ajustar");
        System.out.println("[9] Salir");
    }


    public static void main(String[] args) {

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

        int opc = 0;

        do
        {
            Menu();
            Scanner EntradaOpcion = new Scanner(System.in);
            opc = EntradaOpcion.nextInt();

        switch (opc)
        {
            case 1:

                    InsertarDato(VectorFinal);

                break;
            case 2:

                Scanner RTerExp = new Scanner(System.in);
                System.out.println("DESEA ELIMINAR POR;");
                System.out.println("[1] EXPONENTE");
                System.out.println("[2] COEFICIENTE");
                int TerExp = RTerExp.nextInt();

                EliminarDato(VectorFinal, TerExp);

                break;
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

            case 5:

                ImprimirPolinomio(VectorFinal);

                break;
            case 6: break;
            case 7:

                Scanner fx = new Scanner(System.in);
                int Vfx = fx.nextInt();

                Evaluar(VectorFinal ,Vfx);
                break;

            case 8:

                Ajustar(VectorFinal);
                break;
        }

        }while(opc != 9);

    }
}