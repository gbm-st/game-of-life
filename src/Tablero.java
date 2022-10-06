import java.security.SecureRandom;

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

    public void crearTablero()
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

    public void mostrarTablero()
    {

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                String caracter;

                if(celulas[i][j].isVivo())
                    caracter = "🦠";
                else
                    caracter = "☠";

                System.out.print("\t"+caracter+"\t");

            }

            System.out.println();

        }

    }

    public void inicializarTableroAleatorio(int celulasRevivir)
    {

        int contadorCelulas = 1;
        SecureRandom aleatorio = new SecureRandom();
        int columna;
        int fila;

        while (contadorCelulas <= celulasRevivir)
        {

            columna = aleatorio.nextInt(columnas);
            fila    = aleatorio.nextInt(filas);

            if(!celulas[columna][fila].isVivo())
            {

                celulas[columna][fila].darVidaCelula();
                contadorCelulas++;

            }

        }
    }

    public void vidaVecinos()
    {

        final int PRIMERA   = 0;
        final int ULTIMA    = celulas.length - 1;

        Celula[][] temporarlCelulas = new Celula[columnas][filas];

        copiarCelulas(celulas, temporarlCelulas);

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                int celulasVecinasVivas     = 0;
                int celulasVecinasMuertas   = 0;

                int derecha     = i + 1;
                int abajo       = j + 1;
                int izquierda   = i - 1;
                int arriba      = j - 1;

                if(i == PRIMERA && j == PRIMERA) // Esquina arriba-izquierda
                {

                    if(celulas[derecha][j].isVivo())  // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][abajo].isVivo()) // Derecha-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][abajo].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == PRIMERA && (i != PRIMERA && i != ULTIMA)) // Orilla superior, pero no es la primera ni última
                {

                    if( celulas[derecha][j].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[derecha][abajo].isVivo()) // Derecha-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[i][abajo].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[izquierda][abajo].isVivo()) // Izquierda-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == ULTIMA && j == PRIMERA) // Esquina arriba-derecha
                {

                    if(celulas[i][abajo].isVivo())  // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][abajo].isVivo())  // Izquierda-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == ULTIMA && (j != PRIMERA && j != ULTIMA)) // Orilla derecha, pero no es la primera ni última
                {

                    if(celulas[i][abajo].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][abajo].isVivo()) // Izquierda-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][arriba].isVivo()) // Izquierda-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == ULTIMA && j == ULTIMA) // Esquina abajo-derecho
                {

                    if(celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][arriba].isVivo()) // Izquierda-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == ULTIMA && (i != PRIMERA && i != ULTIMA)) // Orilla inferior, pero no es la primera ni última
                {

                    if(celulas[derecha][j].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][arriba].isVivo())  // Izquierda-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][arriba].isVivo()) // Izquierda-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == PRIMERA && j == ULTIMA) // Esquina abajo-izquierda
                {

                    if(celulas[derecha][j].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][arriba].isVivo()) // Derecha-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == PRIMERA && (j != PRIMERA && j != ULTIMA)) // Orilla izquierda, pero no es la primera ni última
                {

                    if(celulas[derecha][j].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][abajo].isVivo()) // Derecha-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][abajo].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][arriba].isVivo()) // Derecha-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i != PRIMERA && j != PRIMERA && i != ULTIMA && j != ULTIMA)
                {

                    if(celulas[derecha][j].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][abajo].isVivo()) // Derecha-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][abajo].isVivo())  // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][abajo].isVivo())  // Izquierda-Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][j].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[izquierda][arriba].isVivo()) // Izquierda-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[i][arriba].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[derecha][arriba].isVivo())  // Derecha-Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                valorarVidaCelula(temporarlCelulas[i][j], celulasVecinasVivas, celulasVecinasMuertas);

            }

        }

        System.out.println("Original");

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                String caracter;

                if(celulas[i][j].isVivo())
                    caracter = "🦠";
                else
                    caracter = "☠";

                System.out.print("\t"+caracter+"\t");

            }

            System.out.println();

        }

        System.out.println("Termina original");

        System.out.println("Copia");

        for(int i  = 0; i < temporarlCelulas.length; i++)
        {

            for(int j = 0; j < temporarlCelulas[i].length; j++)
            {

                String caracter;

                if(temporarlCelulas[i][j].isVivo())
                    caracter = "🦠";
                else
                    caracter = "☠";

                System.out.print("\t"+caracter+"\t");

            }

            System.out.println();

        }

        System.out.println("Termina copia");

        copiarCelulas(temporarlCelulas, celulas);

    }

    private void copiarCelulas(Celula[][] original, Celula[][] copia)
    {

        for(int i = 0; i < original.length; i++)
        {

            for(int j = 0; j < original[i].length; j++)
            {

                copia[i][j].setVivo(original[i][j].isVivo());

            }

        }

    }

    private void valorarVidaCelula(Celula celula, int celulasVecinasVivas, int celulasVecinasMuertas)
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

    public void copiarTableroAnterior(Tablero tablero)
    {

        copiarCelulas(tablero.getCelulas(), celulas);

    }

}
