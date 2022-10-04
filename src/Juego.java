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

        // Meter un switch para generar manualmente o aleatorio
        tablero.inicializarTableroAleatorio(porcentajeCelulasVivas);

        tableros.add(tablero);

    }

    public boolean compararTablero() {

        //if()
        //    return true;

        return false;
    }

    public void dibujarTablero() {
        tableros.get(tableros.size() - 1);
    }
}
