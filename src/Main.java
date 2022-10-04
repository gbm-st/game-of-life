import java.util.Scanner;

public class Main
{

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

            System.out.println("Ingrese el numero de filas y columnas: ");

            try
            {

                filas = Integer.parseInt(scanner.nextLine());

            }
            catch (NumberFormatException num)
            {
                System.out.println("Ingrese un número por favor.");
                continue;
            }
            columnas = filas;

            System.out.println("Ingrese el porcentaje de células vivas: ");
            try {
                porcentajeCelulasVivas = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException num) {
                System.out.println("Ingrese un flotante por favor.");
                continue;
            }

            break;

        }

        juego.iniciarJuego(filas, columnas, porcentajeCelulasVivas);

        do
        {

            juego.dibujarTablero();

            System.out.println("Presione enter para continuar, presione 1 para salir: ");

            enter = scanner.nextLine();

        }while (!enter.equals("1") || juego.compararTablero());

        System.out.println("Adiós");

    }

}