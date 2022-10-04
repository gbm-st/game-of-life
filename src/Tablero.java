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

    public void inicializarTableroAleatorio(int porcentajeCelulasVivas) {

        int contadorCelulas = 1;
        SecureRandom aleatorio = new SecureRandom();
        int columna;
        int fila;

        while (contadorCelulas <= porcentajeCelulasVivas){

            columna = aleatorio.nextInt(0, columnas - 1);
            fila    = aleatorio.nextInt(0, filas - 1);

            if(!celulas[columna][fila].isVivo())
            {

                celulas[columna][fila].darVidaCelula();
                contadorCelulas++;

            }

        }
    }
}
