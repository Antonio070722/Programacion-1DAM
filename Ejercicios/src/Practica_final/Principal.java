package Practica_final;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    /**
     *
     * @param args
     */
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("admin", "contraseña!!");
        usuarios.put("alumno", "contraseña!!");

        String usuario = "";
        String password = "";
        int intentos=0;
        boolean logeado=false;
        do {
            System.out.println("------------Gestionador de Eventos------------");
            System.out.println("Bienvenido! Login:");
            System.out.println("Introduce tu usuario: ");
            usuario = sc.nextLine();
            System.out.println("Introduce tu contraseña: ");
            password = sc.nextLine();
            if (loginCorrecto(usuario, password, usuarios)){
                logeado=true;
                break;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intentos restantes: "+(3-intentos));
            }
        }while(intentos < 3);

        if (logeado){
            System.out.println("Bienvenido "+ usuario+".");
            mostrarMenu();
        } else {
            System.out.println("Demasidos intentos fallidos.");
        }

    }

    /**
     * Método para verificar si las credenciales que ha introducido el usuario son correctas
     * mediante el uso de un return que únicamente devuelve true si la clave (nombre de usuario)
     * y el valor asociado a la clave (que es la contraseña) son iguales a las credenciales
     * que ha introducido el usuario
     * @param usuario
     * @param password
     * @param usuarios
     * @return
     */
    public static boolean loginCorrecto(String usuario, String password, HashMap<String, String> usuarios) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(password);
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int op=0;
        do {
            System.out.println("\n1.\tListar todos los eventos");
            System.out.println("2.\tListar solo eventos futuros");
            System.out.println("3.\tAñadir evento presencial");
            System.out.println("4.\tAñadir evento online");
            System.out.println("5.\tBorrar evento por nombre");
            System.out.println("6.\t(Solo admin) Crear nuevo usuario");
            System.out.println("7.\tSalir");
            System.out.println("\nIntroduce la opcion deseada: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        }while(op!=7);

        }

}
