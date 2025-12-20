package primer_trimestre.pet_shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static ArrayList<Animales> listaAnimales = new ArrayList<>();

    public static void main(String[] args) {
        // Ejemplo: crear un perro de raza "Labrador" con identificador en el nombre de la variable
        Perro Labrador1 = new Perro(SEXO.MACHO, 3, "EAN12345", "amarillo", "Labrador", TIPO_PELO_PERRO.CORTO, false, 123456);
        System.out.println(Labrador1);

        Scanner sc = new Scanner(System.in);
        int op= 0;
        do {
            System.out.println("\n------------------- MENÚ ------------------");
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
                    ventaAnimales();
                    break;
                case 2:
                    System.out.println("Has seleccionado 2");
                    System.out.println("Total de animales vendidos: " + listaAnimales.size());
                    break;
                case 3:
                    System.out.println("Has seleccionado 3");
                    System.out.println("Total de mascotas: " + listaAnimales.size());
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

    public static void ventaAnimales(){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Que animal desea comprar? (perro/gato/pajaro/rata): ");
        String animal = sc.nextLine().toLowerCase();
        switch (animal) {
            case "perro":
                System.out.println("Ha seleccionado un perro.");

                System.out.print("Introduce el chip (Ej: 9999): ");
                int chip = sc.nextInt();
                sc.nextLine();

                System.out.print("Introduce el EAN (Ej: 99AE): ");
                String ean = sc.nextLine();

                System.out.print("Sexo (macho/hembra): ");
                String sexoStr = sc.nextLine().toUpperCase();
                SEXO sexo = SEXO.valueOf(sexoStr);

                System.out.print("Edad en días: ");
                int edad = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre de la mascota: ");
                String nombreMascota = sc.nextLine();

                System.out.print("Tipo de pelo (CORTO/LARGO/RIZADO): ");
                TIPO_PELO_PERRO tipoPelo = TIPO_PELO_PERRO.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Color: ");
                String color = sc.nextLine();

                System.out.print("Raza: ");
                String raza = sc.nextLine();

                System.out.print("¿Tiene pedigree? (true/false): ");
                boolean pedigree = sc.nextBoolean();
                sc.nextLine();

                Perro nuevoPerro = new Perro(sexo, edad, ean, color, raza, tipoPelo, pedigree, chip, nombreMascota);
                System.out.println("Perro creado: " + nuevoPerro);

                //Datos del dueño
                System.out.print("Nombre del dueño: ");
                String nombreDueno = sc.nextLine();
                System.out.print("Apellido del dueño: ");
                String apellidoDueno = sc.nextLine();
                System.out.print("DNI del dueño: ");
                String dniDueno = sc.nextLine();

                nuevoPerro.asignarDueno(nombreDueno, apellidoDueno, dniDueno);

                System.out.println("Dueño asignado: " + nombreDueno + " " + apellidoDueno + ", DNI: " + dniDueno);

                if (nuevoPerro.peligree){
                    System.out.println("El precio del perro con pedigree es: " + Perro.PRECIO_CON_PELIGREE + " euros.");
                } else {
                    System.out.println("El precio del perro sin pedigree es: " + Perro.PRECIO_SIN_PELIGREE + " euros.");
                }
                listaAnimales.add(nuevoPerro);
                break;
            case "gato":
                System.out.println("Ha seleccionado un gato.");
                // Solicitar datos similares a perro, ajustados al constructor de Gato
                System.out.print("Introduce el chip (Ej: 9999): ");
                int chipG = sc.nextInt();
                sc.nextLine();

                System.out.print("Introduce el EAN (Ej: 99AE): ");
                String eanG = sc.nextLine();

                System.out.print("Sexo (macho/hembra): ");
                String sexoGStr = sc.nextLine().toUpperCase();
                SEXO sexoG = SEXO.valueOf(sexoGStr);

                System.out.print("Edad en días: ");
                int edadG = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre de la mascota: ");
                String nombreMascotaG = sc.nextLine();

                System.out.print("Tipo de pelo (CORTO/MEDIO/LARGO): ");
                TIPO_PELO_GATO tipoPeloG = TIPO_PELO_GATO.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Color: ");
                String colorG = sc.nextLine();

                System.out.print("Raza: ");
                String razaG = sc.nextLine();

                Gato nuevoGato = new Gato(sexoG, edadG, eanG, colorG, razaG, tipoPeloG, chipG, nombreMascotaG);
                System.out.println("Gato creado: " + nuevoGato);

                //Datos del dueño
                System.out.print("Nombre del dueño: ");
                String nombreDuenoG = sc.nextLine();
                System.out.print("Apellido del dueño: ");
                String apellidoDuenoG = sc.nextLine();
                System.out.print("DNI del dueño: ");
                String dniDuenoG = sc.nextLine();

                nuevoGato.asignarDueno(nombreDuenoG, apellidoDuenoG, dniDuenoG);
                System.out.println("Dueño asignado: " + nombreDuenoG + " " + apellidoDuenoG + ", DNI: " + dniDuenoG);

                System.out.println("El precio del gato es: " + Gato.precio_gato + " euros.");
                listaAnimales.add(nuevoGato);
                break;
            case "pajaro":
                System.out.println("Ha seleccionado un pájaro.");
                // Solicitar datos para pájaro según constructor de Pájaros
                System.out.print("Introduce el EAN (Ej: 99AE): ");
                String eanP = sc.nextLine();

                System.out.print("Sexo (macho/hembra): ");
                String sexoPStr = sc.nextLine().toUpperCase();
                SEXO sexoP = SEXO.valueOf(sexoPStr);

                System.out.print("Edad en días: ");
                int edadP = sc.nextInt();
                sc.nextLine();

                System.out.print("Color: ");
                String colorP = sc.nextLine();

                System.out.print("Tipo de loro (VERDE, ROJO, AZUL, AMARILLO, NARANJA, BLANCO, NEGRO, MULTICOLOR): ");
                TIPO_LORO tipoLoro = TIPO_LORO.valueOf(sc.nextLine().toUpperCase());

                Pájaros nuevoPajaro = new Pájaros(sexoP, edadP, eanP, colorP, tipoLoro);
                System.out.println("Pájaro creado: " + nuevoPajaro);
                listaAnimales.add(nuevoPajaro);
                break;
            case "rata":
                System.out.println("Ha seleccionado una rata.");
                // Solicitar datos para rata según constructor de Ratas_cebo_serpientes
                System.out.print("Introduce el EAN (Ej: 99AE): ");
                String eanR = sc.nextLine();

                System.out.print("Sexo (macho/hembra): ");
                String sexoRStr = sc.nextLine().toUpperCase();
                SEXO sexoR = SEXO.valueOf(sexoRStr);

                System.out.print("Edad en días: ");
                int edadR = sc.nextInt();
                sc.nextLine();

                System.out.print("Peso en gramos: ");
                int pesoR = sc.nextInt();
                sc.nextLine();

                System.out.print("Tamaño en cm: ");
                int tamR = sc.nextInt();
                sc.nextLine();

                Ratas_cebo_serpientes nuevaRata = new Ratas_cebo_serpientes(sexoR, edadR, eanR, pesoR, tamR);
                System.out.println("Rata creada: " + nuevaRata);

                if (nuevaRata.aptoVenta()){
                    System.out.println("La rata es apta para la venta. Precio: " + Ratas_cebo_serpientes.precioRata + " euros.");
                    listaAnimales.add(nuevaRata);
                } else {
                    System.out.println("Rata no apta para venta. No cumple con las medidas mínimas.");
                }
                break;
            default:
                System.out.println("Animal no válido. Por favor, seleccione perro, gato, pájaro o rata.");
                break;
        }
    }

}
