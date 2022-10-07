package cmd;

import java.util.ArrayList;

public class Juego
{

    ArrayList<Tablero> tableros;

    public Juego()
    {

        tableros = new ArrayList<Tablero>();

    }

    public void iniciarJuego(int columnas, int filas, int porcentajeCelulasVivas, char manual)
    {

        Tablero tablero = new Tablero(columnas, filas);

        tablero.llenarTablero(tablero.getCelulas());

        if(manual == 'Y')
            tablero.inicializarTableroManual(obtenerCelulasRevivir(columnas, filas, porcentajeCelulasVivas));
        else
            tablero.inicializarTableroAleatorio(obtenerCelulasRevivir(columnas, filas, porcentajeCelulasVivas));

        tableros.add(tablero);

    }

    public boolean compararTablero()
    {

        try
        {

            // Iteramos desde el penúltimo al último tablero
            for (int i = tableros.size() - 3; i < tableros.size() - 1; i++)
            {

                if(!Tablero.compararCelulasTableros(tableros.get(tableros.size() - 1).getCelulas(), tableros.get(i).getCelulas()))
                    return false;

            }

            return true;

        }
        catch (IndexOutOfBoundsException e) // Si no existe el indice que intentamos acceder
        {

            return false;

        }

    }

    public void dibujarTablero()
    {

        // Obtenemos el último tablero
        Tablero.mostrarCelulasTablero(tableros.get(tableros.size() - 1).getCelulas());

    }

    public int obtenerCelulasRevivir(int columnas, int filas, int porcentajeCelulasVivas)
    {

        double dimensiones = (double) columnas * filas;
        double porcentaje  = (double) porcentajeCelulasVivas / 100;

        double operacion = dimensiones * porcentaje;

        return (int) Math.round(operacion);

    }

    public void siguientePartida(int columnas, int filas)
    {

        Tablero tablero = new Tablero(columnas, filas);

        tablero.llenarTablero(tablero.getCelulas());

        // Obtenemos el último tablero y el tablero actual
        tablero.copiarCelulasTableroAnterior(tableros.get(tableros.size() - 1), tablero);

        tablero.vidaVecinos();

        tableros.add(tablero);

    }

}
