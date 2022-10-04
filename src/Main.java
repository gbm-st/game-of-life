import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu()
    {
        String enter;
        int filas;
        int columnas;
        float porcentajeCelulasVivas;
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("---------------Game of Life---------------");
            System.out.println("Presione enter para continuar, presione 1 para salir: ");
            enter = scanner.nextLine();
            if (!enter.equals("1"))
            {
                System.out.println("Ingrese el numero de filas y columnas: ");
                try {
                    filas = Integer.parseInt(scanner.nextLine());
                }
                catch (NumberFormatException num){
                    System.out.println("Ingrese un número por favor.");
                    continue;
                }
                columnas = filas;

                System.out.println("Ingrese el porcentaje de células vivas: ");
                try {
                    porcentajeCelulasVivas = Float.parseFloat(scanner.nextLine());
                }
                catch (NumberFormatException num){
                    System.out.println("Ingrese un flotante por favor.");
                    continue;
                }

                break;
            }
            else {
                System.out.println("Adios");
                break;
            }
        }
    }
}