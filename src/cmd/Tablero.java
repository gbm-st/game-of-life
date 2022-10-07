package cmd;

import java.security.SecureRandom;
import java.util.Scanner;

public class Tablero
{

    Celula[][] celulas;
    int filas;
    int columnas;

    public Tablero(int columnas, int filas)
    {

        this.columnas   = columnas;
        this.filas      = filas;
        celulas         = new Celula[columnas][filas];

    }

    public Celula[][] getCelulas()
    {

        return celulas;

    }

    public void setCelulas(Celula [][] celulas)
    {

        this.celulas = celulas;

    }

    public static boolean compararCelulasTableros(Celula[][] tableroActual, Celula[][] tablerosAnteriores)
    {

        boolean iguales = true;

        for (int i = 0; i < tableroActual.length; i++)
            for(int j = 0; j < tableroActual[i].length; j++)
            {

                if(tableroActual[i][j].isVivo() != tablerosAnteriores[i][j].isVivo())
                {

                    iguales = false;
                    break;

                }

            }

        return iguales;

    }

    public static void mostrarCelulasTablero(Celula[][] celulas)
    {

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                String caracter;

                if(celulas[i][j].isVivo())
                    //caracter = "🦠";
                    caracter = "🔴";
                else
                    caracter = "☠";

                System.out.print("\t"+caracter+"\t");

            }

            System.out.println();

        }

    }

    public void llenarTablero(Celula[][] celulas)
    {

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                Celula celula = new Celula();
                celulas[i][j] = celula;

            }

        }

    }

    public void inicializarTableroAleatorio(int celulasRevivir)
    {

        int contadorCelulas = 1;
        SecureRandom aleatorio = new SecureRandom();
        int columnaRandom;
        int filaRandom;

        while (contadorCelulas <= celulasRevivir)
        {

            columnaRandom = aleatorio.nextInt(this.columnas);
            filaRandom    = aleatorio.nextInt(this.filas);

            if(!celulas[columnaRandom][filaRandom].isVivo())
            {

                celulas[columnaRandom][filaRandom].darVidaCelula();
                contadorCelulas++;

            }

        }
    }

    public void inicializarTableroManual(int celulasRevivir)
    {

        int contadorCelulas = 1;
        Scanner entrada = new Scanner(System.in);
        int columna;
        int fila;

        while (contadorCelulas <= celulasRevivir)
        {

            System.out.println(contadorCelulas +" celulas de "+ celulasRevivir);

            while(true)
            {
                try{
                    System.out.print("Introduzca la coordenada X del elemento "+ contadorCelulas +": ");
                    columna = Integer.parseInt(entrada.nextLine());

                    if(columna < 0 || columna > celulas.length - 1)
                    {

                        System.out.println("Ingrese un número entre 0 y "+ (celulas.length - 1) +", por favor.\n");
                        continue;

                    }
                    break;
                }
                catch (NumberFormatException num)
                {

                    System.out.println("Ingrese un número por favor.\n");

                }
            }

            while(true)
            {
                try{
                    System.out.print("Introduzca la coordenada Y del elemento "+ contadorCelulas +": ");
                    fila = Integer.parseInt(entrada.nextLine());

                    if(fila < 0 || fila > celulas.length - 1)
                    {

                        System.out.println("Ingrese un número entre 0 y "+ (celulas.length - 1) +", por favor.\n");
                        continue;

                    }
                    break;
                }
                catch (NumberFormatException num)
                {

                    System.out.println("Ingrese un número por favor.\n");

                }
            }

            if(celulas[fila][columna].isVivo())
            {

               System.out.println("La celula ya se encuentra viva, favor de introducir otras coordenadas.");
               continue;

            }

            celulas[fila][columna].darVidaCelula();
            contadorCelulas++;

        }

    }

    public void vidaVecinos()
    {

        final int PRIMERA   = 0;
        final int ULTIMA    = celulas.length - 1;

        Celula[][] temporarlCelulas = new Celula[columnas][filas];

        llenarTablero(temporarlCelulas);

        copiarCelulas(celulas, temporarlCelulas);

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                int celulasVecinasVivas     = 0;

                int derecha     = j + 1;
                int abajo       = i + 1;
                int izquierda   = j - 1;
                int arriba      = i - 1;

                //System.out.println(celulas[i][j].isVivo() + " " + i + " " + j);

                if(i == PRIMERA && j == PRIMERA) // Esquina arriba-izquierda
                {

                    if(celulas[i][derecha].isVivo())  // Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][derecha].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][j].isVivo()) // Abajo
                        celulasVecinasVivas++;

                }

                if(i == PRIMERA && (j != PRIMERA && j != ULTIMA)) // Orilla superior, pero no es la primera ni última
                {

                    if( celulas[i][derecha].isVivo()) // Derecha
                        celulasVecinasVivas++;

                    if( celulas[abajo][derecha].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;

                    if( celulas[abajo][j].isVivo()) // Abajo
                        celulasVecinasVivas++;

                    if( celulas[abajo][izquierda].isVivo()) // Abajo-Izquierda
                        celulasVecinasVivas++;

                    if( celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                }

                if(i == PRIMERA && j == ULTIMA) // Esquina arriba-derecha
                {

                    if(celulas[abajo][j].isVivo())  // Abajo
                        celulasVecinasVivas++;

                    if(celulas[abajo][izquierda].isVivo())  // Abajo-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                }

                if(j == ULTIMA && (i != PRIMERA && i != ULTIMA)) // Orilla derecha, pero no es la primera ni última
                {

                    if(celulas[abajo][j].isVivo()) // Abajo
                        celulasVecinasVivas++;

                    if(celulas[abajo][izquierda].isVivo()) // Abajo-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][izquierda].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                }

                if(i == ULTIMA && j == ULTIMA) // Esquina abajo-derecho
                {

                    if(celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][izquierda].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                }

                if(i == ULTIMA && (j != PRIMERA && j != ULTIMA)) // Orilla inferior, pero no es la primera ni última
                {

                    if(celulas[i][derecha].isVivo()) // Derecha
                        celulasVecinasVivas++;

                    if(celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][izquierda].isVivo())  // Arriba-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                    if(celulas[arriba][derecha].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;

                }

                if(i == ULTIMA && j == PRIMERA) // Esquina abajo-izquierda
                {

                    if(celulas[i][derecha].isVivo()) // Derecha
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                    if(celulas[arriba][derecha].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;

                }

                if(j == PRIMERA && (i != PRIMERA && i != ULTIMA)) // Orilla izquierda, pero no es la primera ni última
                {

                    if(celulas[i][derecha].isVivo()) // Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][derecha].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][j].isVivo()) // Abajo
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                    if(celulas[arriba][derecha].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;

                }

                if(i != PRIMERA && j != PRIMERA && i != ULTIMA && j != ULTIMA)
                {

                    if(celulas[i][derecha].isVivo()) // Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][derecha].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;

                    if(celulas[abajo][j].isVivo())  // Abajo
                        celulasVecinasVivas++;

                    if(celulas[abajo][izquierda].isVivo())  // Abajo-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[i][izquierda].isVivo()) // Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][izquierda].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;

                    if(celulas[arriba][j].isVivo()) // Arriba
                        celulasVecinasVivas++;

                    if(celulas[arriba][derecha].isVivo())  // Arriba-Derecha
                        celulasVecinasVivas++;

                }

                valorarVidaCelula(temporarlCelulas[i][j], celulasVecinasVivas);

            }

        }

        copiarCelulas(temporarlCelulas, celulas);

    }

    private void copiarCelulas(Celula[][] origen, Celula[][] destino)
    {

       for (int i = 0; i < origen.length; i++) {
           for (int j = 0; j < origen[i].length; j++) {
               if (origen[i][j].isVivo() == Celula.VIVO) {
                   destino[i][j].darVidaCelula();
               } else if (origen[i][j].isVivo() == Celula.MUERTO) {
                   destino[i][j].matarCelula();
               }
           }
       }

    }

    private void valorarVidaCelula(Celula celula, int celulasVecinasVivas)
    {

        if(!celula.isVivo()) // Una célula muerta con exactamente 3 células vecinas vivas "nace" (al turno siguiente estará viva).
            if(celulasVecinasVivas == 3)
            {

                celula.darVidaCelula();
                return;

            }

        if(celula.isVivo()) // Una célula viva con 2 o 3 células vecinas vivas sigue viva.
            if(celulasVecinasVivas == 2 || celulasVecinasVivas == 3)
                return;

        if(celula.isVivo()) // Una célula viva que tenga 0 o 1 células vecinas muere por “soledad“.
            if(celulasVecinasVivas == 0 || celulasVecinasVivas == 1)
            {

                celula.matarCelula();
                return;

            }

        if (celulasVecinasVivas > 3) // Una célula que tenga más de 3 vecinas vivas o permanece muerta o muere por "sobrepoblación".
            celula.matarCelula();

    }

    public void copiarCelulasTableroAnterior(Tablero original, Tablero copia)
    {

        copiarCelulas(original.getCelulas(), copia.getCelulas());

    }

}
