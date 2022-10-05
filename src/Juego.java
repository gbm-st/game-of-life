import java.util.ArrayList;

public class Juego
{

    ArrayList<Tablero> tableros;

    public Juego()
    {

        tableros = new ArrayList<Tablero>();

    }

    public void iniciarJuego(int filas, int columnas, int porcentajeCelulasVivas)
    {

        Tablero tablero = new Tablero(filas, columnas);

        tablero.crearTablero();

        tablero.inicializarTableroAleatorio(obtenerPorcentaje(filas, columnas, porcentajeCelulasVivas));

        tableros.add(tablero);

    }

    public boolean compararTablero() {

        //if()
        //    return true;

        return false;
    }

    public void dibujarTablero()
    {

        Tablero tablero = tableros.get(tableros.size() - 1);

        tablero.mostrarTablero();

    }

    public int obtenerPorcentaje(int filas, int columnas, int porcentajeCelulasVivas)
    {

        double dimensiones = (double) filas * columnas;
        double porcentaje  = (double) porcentajeCelulasVivas / 100;

        double operacion = dimensiones * porcentaje;

        return (int) Math.round(operacion);

    }

    public void siguientePartida(int filas, int columnas)
    {

        Tablero tablero = new Tablero(filas, columnas);

        tablero.crearTablero();

        tablero.valorarVidaCelulas();

        tableros.add(tablero);

    }

}
