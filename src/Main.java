import java.util.Scanner;

public class Main
{

    static final int LIMITE_INFERIOR_TABLERO = 0;
    static final int LIMITE_SUPERIOR_TABLERO = 25;

    static final int LIMITE_INFERIOR_PORCENTAJE = 0;
    static final int LIMITE_SUPERIOR_PORCENTAJE = 100;

    public static void main(String[] args)
    {

        menu();

    }

    private static void menu()
    {

        String enter;
        int filas                  = 0;
        int columnas               = 0;
        int porcentajeCelulasVivas = 0;

        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------Game of Life---------------");

        while (true) {

            System.out.print("Ingrese el numero de filas y columnas (0 a 25): ");

            try
            {

                filas = Integer.parseInt(scanner.nextLine());

                if(filas < LIMITE_INFERIOR_TABLERO || filas > LIMITE_SUPERIOR_TABLERO)
                {

                    System.out.println("Ingrese un número entre el rango de 0 y 25, por favor.");
                    continue;

                }

            }
            catch (NumberFormatException num)
            {

                System.out.println("Ingrese un número por favor.");
                continue;

            }

            columnas = filas;

            System.out.print("Ingrese el porcentaje de células vivas (0 a 100): ");

            try
            {

                porcentajeCelulasVivas = Integer.parseInt(scanner.nextLine());

                if(porcentajeCelulasVivas < LIMITE_INFERIOR_PORCENTAJE || porcentajeCelulasVivas > LIMITE_SUPERIOR_PORCENTAJE)
                {

                    System.out.println("Ingrese un número entre el rango de 0 y 25, por favor.");
                    continue;

                }

            }
            catch (NumberFormatException num)
            {

                System.out.println("Ingrese un flotante por favor.");
                continue;

            }

            break;

        }

        juego.iniciarJuego(filas, columnas, porcentajeCelulasVivas);
        juego.dibujarTablero();

        while (!juego.compararTablero())
        {

            System.out.println("Presione enter para continuar, presione 1 para salir: ");
            enter = scanner.nextLine();

            if(enter.equals("1"))
                break;

            juego.siguientePartida(filas, columnas);
            juego.dibujarTablero();

        }

        System.out.println("Adios");

    }

}