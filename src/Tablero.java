import java.security.SecureRandom;

public class Tablero
{

    Celula[][] celulas;
    int filas;
    int columnas;

    public Tablero(int filas, int columnas)
    {

        this.filas      = filas;
        this.columnas   = columnas;
        celulas         = new Celula[filas][columnas];

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
                celulas[j][i] = celula;

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

                if(celulas[j][i].isVivo())
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

        while (contadorCelulas <= celulasRevivir){

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

        int celulasVecinasVivas;
        int celulasVecinasMuertas;
        int longitudMaxima = celulas.length - 1;

        Celula[][] temporarlCelulas = copiarCelulas();

        for(int i  = 0; i <= longitudMaxima; i++)
        {

            for(int j = 0; j <= longitudMaxima; j++)
            {

                celulasVecinasVivas     = 0;
                celulasVecinasMuertas   = 0;

                if(i == 0 && j == 0) // Orilla superior-izquierda
                {

                    if(celulas[j][i + 1].isVivo())  // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i + 1].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == 0 && (j != 0 && j != longitudMaxima)) // Orilla superior, pero no es la primera ni última
                {

                    if( celulas[j][i + 1].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[j + 1][i + 1].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[j + 1][i].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[j + 1][i - 1].isVivo()) // Abajo-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if( celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == longitudMaxima && i == 0) // Orilla superior-derecha
                {

                    if(celulas[j + 1][i].isVivo())  // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i - 1].isVivo())  // Abajo-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == longitudMaxima && (i != 0 && i != longitudMaxima)) // Orilla derecha, pero no es la primera ni última
                {

                    if(celulas[j + 1][i].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i - 1].isVivo()) // Abajo-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i - 1].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == longitudMaxima && j == longitudMaxima) // Orilla inferior-derecha
                {

                    if(celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i - 1].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i == longitudMaxima && (j != 0 && j != longitudMaxima)) // Orilla inferior, pero no es la primera ni última
                {

                    if(celulas[j][i + 1].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i - 1].isVivo())  // Arriba-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i + 1].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == 0 && i == longitudMaxima) // Orilla inferior-izquierda
                {

                    if(celulas[j][i + 1].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i + 1].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(j == 0 && (i != 0 && i != longitudMaxima)) // Orilla izquierda, pero no es la primera ni última
                {

                    if(celulas[j][i + 1].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i + 1].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i].isVivo()) // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i + 1].isVivo()) // Arriba-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                if(i != 0 && j != 0 && i != longitudMaxima && j != longitudMaxima)
                {

                    if(celulas[j][i + 1].isVivo()) // Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i + 1].isVivo()) // Abajo-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i].isVivo())  // Abajo
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j + 1][i - 1].isVivo())  // Abajo-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j][i - 1].isVivo()) // Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i - 1].isVivo()) // Arriba-Izquierda
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i].isVivo()) // Arriba
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                    if(celulas[j - 1][i + 1].isVivo())  // Arriba-Derecha
                        celulasVecinasVivas++;
                    else
                        celulasVecinasMuertas++;

                }

                valorarVidaCelula(temporarlCelulas[i][j], celulasVecinasVivas, celulasVecinasMuertas);

            }

        }

        celulas = temporarlCelulas;

    }

    private Celula[][] copiarCelulas()
    {

        Celula[][] temporalCelulas = new Celula[columnas][filas];

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                temporalCelulas[i][j] = celulas[i][j];

            }

        }

        return temporalCelulas;

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

}
