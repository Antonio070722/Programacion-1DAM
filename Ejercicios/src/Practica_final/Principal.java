package Practica_final;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario = "";
        String password = "";
        do {
            System.out.println("Bienvenido! Login:");
            System.out.println("Introduce tu usuario: ");
            usuario = sc.nextLine();
            System.out.println("Introduce tu contraseña: ");
            password = sc.nextLine();
        }while(!loginCorrecto(usuario, password));
    }

    public static boolean loginCorrecto(String usuario, String password) {
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("admin", "contraseñaValida");
        usuarios.put("alumno", "contraValida");
    }

}
