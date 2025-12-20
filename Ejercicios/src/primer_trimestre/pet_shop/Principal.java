package primer_trimestre.pet_shop;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // Ejemplo: crear un perro de raza "Labrador" con identificador en el nombre de la variable
        Perro Labrador1 = new Perro(SEXO.MACHO, 3, "EAN12345", "amarillo", "Labrador", TIPO_PELO_PERRO.CORTO, false, 123456);
        System.out.println(Labrador1);

        Scanner sc = new Scanner(System.in);
        int op= 0;
        do {
            System.out.println("0.\tSalir.\n" +
                    "1.\tVender uno o varios animales y mostrar su precio final.\n" +
                    "2.\tMostrar el total de animales vendidos.\n" +
                    "3.\tMostrar el total de mascotas.\n" +
                    "4.\tMostrar el total de perros, gatos, pájaros y ratas vendidos.\n" +
                    "5.\tMostrar el dueño de una mascota introduciendo el DNI del dueño.\n" +
                    "6.\tMostrar el número de chip y nombre de una mascota introduciendo el nombre.\n" +
                    "7.\tMostrar las características de un animal (sexo, edad y características específicas) introduciendo su código EAN.\n" +
                    "8.\tMostrar si dos mascotas pueden reproducirse introduciendo el número de chip de cada una.\n" +
                    "9.\tSaber si un perro, gato o pájaro come un tipo de comida.");
            System.out.print("Introduce una opción (0-9): ");
            op = sc.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Has seleccionado 0 - Salir");
                    break;
                case 1:
                    System.out.println("Has seleccionado 1");
                    break;
                case 2:
                    System.out.println("Has seleccionado 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado 3");
                    break;
                case 4:
                    System.out.println("Has seleccionado 4");
                    break;
                case 5:
                    System.out.println("Has seleccionado 5");
                    break;
                case 6:
                    System.out.println("Has seleccionado 6");
                    break;
                case 7:
                    System.out.println("Has seleccionado 7");
                    break;
                case 8:
                    System.out.println("Has seleccionado 8");
                    break;
                case 9:
                    System.out.println("Has seleccionado 9");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número entre 0 y 9.");
                    break;
            }

        } while(op!=0);
    }

}
