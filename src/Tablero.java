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

            System.out.println("\n\t〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️\t");

        }

    }

    public void inicializarTableroAleatorio(int porcentajeCelulasVivas) {

        int contadorCelulas = 1;
        SecureRandom aleatorio = new SecureRandom();
        int columna;
        int fila;

        while (contadorCelulas <= porcentajeCelulasVivas){

            columna = aleatorio.nextInt(columnas);
            fila    = aleatorio.nextInt(filas);

            if(!celulas[columna][fila].isVivo())
            {

                celulas[columna][fila].darVidaCelula();
                contadorCelulas++;

            }

        }
    }

    public void valorarVidaCelulas()
    {

        for(int i  = 0; i < celulas.length; i++)
        {

            for(int j = 0; j < celulas[i].length; j++)
            {

                if(i == 0)
                {



                }

                if(j == 0)
                {



                }

                if(i == celulas.length)
                {



                }

                if(j == celulas.length)
                {



                }

            }

        }

    }

}
