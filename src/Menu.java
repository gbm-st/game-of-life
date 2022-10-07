
import java.util.Scanner;

public class Menu
{
    private int filas                   = 0;
    private int columnas                = 0;
    private String enter;
    private int numeroJuego             = 1;
    private int porcentajeCelulasVivas  = 0;
    private char manual                 = 'N';
    private Juego juego = new Juego();
    private Scanner entrada = new Scanner(System.in);
    static final int LIMITE_INFERIOR_TABLERO = 0;
    static final int LIMITE_SUPERIOR_TABLERO = 25;
    static final int LIMITE_INFERIOR_PORCENTAJE = 0;
    static final int LIMITE_SUPERIOR_PORCENTAJE = 100;
    public void inicio()
    {

        System.out.println("---------------Game of Life---------------");
        System.out.println("CMD.Juego número: "+ numeroJuego);

        filasColumnas();

        porcentajeCelulas();

        introducirCelulas();

        compararTablero();

    }

    private void filasColumnas()
    {
        while(true)
        {
            try {
                System.out.print("Ingrese el numero de filas y columnas (0 a 25): ");

                columnas = Integer.parseInt(entrada.nextLine());

                if (columnas < LIMITE_INFERIOR_TABLERO || columnas > LIMITE_SUPERIOR_TABLERO) {

                    System.out.println("Ingrese un número entre el rango de 0 y 25, por favor.\n");
                    continue;
                }
                break;
            }
            catch (NumberFormatException num)
            {

                System.out.println("Ingrese un número por favor.\n");

            }
        }

        filas = columnas;
    }

    private void porcentajeCelulas()
    {
        while(true)
        {
            try {
                System.out.print("Ingrese el porcentaje de células vivas (0 a 100): ");

                porcentajeCelulasVivas = Integer.parseInt(entrada.nextLine());


                if (porcentajeCelulasVivas < LIMITE_INFERIOR_PORCENTAJE || porcentajeCelulasVivas > LIMITE_SUPERIOR_PORCENTAJE) {

                    System.out.println("Ingrese un número entre el rango de 0 y 100, por favor.\n");
                    continue;

                }
                break;
            }
            catch (NumberFormatException num)
            {

                System.out.println("Ingrese un número por favor.\n");

            }
        }
    }

    private void introducirCelulas()
    {
        while(true)
        {

            System.out.print("¿Desea introducir las celulas de manera manual (Y/N)");

            manual = Character.toUpperCase(entrada.next().charAt(0));

            if(manual != 'Y' && manual != 'N')
            {

                System.out.println("Ingrese un valor entre Y/N.\n");
                continue;

            }
            break;
        }

        numeroJuego++;

        juego.iniciarJuego(columnas, filas, porcentajeCelulasVivas, manual);
        juego.dibujarTablero();
    }

    private void compararTablero()
    {
        while (!juego.compararTablero())
        {

            System.out.print("Presione 1 para continuar, presione 2 para salir: ");
            enter = entrada.next();

            if(!enter.equals("1"))
                break;

            juego.siguientePartida(columnas, filas);
            System.out.println("CMD.Juego número: "+ numeroJuego);
            juego.dibujarTablero();

            numeroJuego++;

        }

        System.out.println("Adios");
    }
}
