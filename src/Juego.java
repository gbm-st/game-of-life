import java.util.ArrayList;

public class Juego
{

    ArrayList<Tablero> tableros;

    public Juego()
    {

        tableros = new ArrayList<Tablero>();

    }

    public void iniciarJuego(int columnas, int filas, int porcentajeCelulasVivas)
    {

        Tablero tablero = new Tablero(columnas, filas);

        tablero.crearTablero();

        tablero.inicializarTableroAleatorio(obtenerPorcentaje(columnas, filas, porcentajeCelulasVivas));

        tableros.add(tablero);

    }

    public boolean compararTablero()
    {

        return false;

    }

    public void dibujarTablero()
    {

        Tablero tablero = tableros.get(tableros.size() - 1);

        tablero.mostrarTablero();

    }

    public int obtenerPorcentaje(int columnas, int filas, int porcentajeCelulasVivas)
    {

        double dimensiones = (double) columnas * filas;
        double porcentaje  = (double) porcentajeCelulasVivas / 100;

        double operacion = dimensiones * porcentaje;

        return (int) Math.round(operacion);

    }

    public void siguientePartida(int columnas, int filas) {

        Tablero tablero = new Tablero(columnas, filas);

        tablero.crearTablero();

        tablero.copiarTableroAnterior(tableros.get(tableros.size() - 1));

        tablero.vidaVecinos();

        tableros.add(tablero);

    }

}
