package Practica_final;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    /**
     *
     * @param args
     */
    static void main(String[] args) throws PasswordException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> usuarios = new HashMap<>();
        ArrayList<Evento> eventos = new ArrayList<>();
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
            mostrarMenu(eventos, usuarios, usuario);
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

    /**
     *
     */
    public static void mostrarMenu(ArrayList<Evento> eventos, HashMap<String, String> usuarios, String usuario) throws PasswordException {
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
                    listarEventos(eventos);
                    break;
                case 2:
                    listarEventosFuturos(eventos);
                    break;
                case 3, 4:
                    anadirEvento(eventos);
                    break;
                case 5:
                    borrarEvento(eventos);
                    break;
                case 6:
                    crearUsuario(eventos, usuarios, usuario);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        }while(op!=7);

        }

    private static void crearUsuario(ArrayList<Evento> eventos, HashMap<String, String> usuarios, String usuario) throws PasswordException {
        Scanner sc = new Scanner(System.in);
        if (!usuario.equals("admin")) {
            System.out.println("Acceso denegado: solo admin puede crear usuarios.");

            mostrarMenu(eventos, usuarios, usuario);
        } else {
            System.out.println("Introduce el nombre del nuevo usuario");
            String nombre=sc.nextLine();
            System.out.println("Introduce la contraseña para el nuevo usuario");
            String password=sc.nextLine();
            comprobarContraseña(password);
        }

    }

    private static boolean comprobarContraseña(String password) throws PasswordException {
        if (password.length() < 8 || password.length() > 12) {
            throw new PasswordException("La contraseña es menor a 8 caracteres o mayor a 12.");
        }

        if (!password.matches(".*[A-Za-z].*")){
            throw new PasswordException("La contraseña debe contener al menos una letra");
        }

        if (!password.matches(".*\\d.*")){
            throw new PasswordException("La contraseña no puede contener números");
        }

        if (!password.matches(".*[!@#$%&*].*")){
            throw new PasswordException("La contraseña debe contener al menos uno de estos signos: !@#$%&*");
        }

        return true;
    }

    private static void borrarEvento(ArrayList<Evento> eventos) {
        Scanner sc = new Scanner(System.in);
        if (eventos.isEmpty()){
            System.out.println("No hay eventos creados.");
        } else {
            System.out.println("Lista de eventos: ");
            for (Evento e : eventos) {
                e.mostrarInfo();
            }
        }
        System.out.println("Introduce el nombre del evento a borrar: ");
        String borrar = sc.nextLine();
        boolean encontrado=false;
        for (Evento e : eventos) {
            if (e.getNombre().equals(borrar)) {
                eventos.remove(e);
                System.out.println("\nEvento "+borrar+" borrado.");
                encontrado=true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encuentra ningún evento con ese nombre");
        }
    }

    private static void listarEventosFuturos(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("No se han encontrado eventos.");
        }else {
            for (Evento a : eventos) {
                if (a.esFuturo()) {
                    a.mostrarInfo();
                }
            }
        }
    }

    private static void listarEventos(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("No se han encontrado eventos.");
        }else {
            for (Evento a : eventos) {
                a.mostrarInfo();
                System.out.println(a);
            }
        }
    }

    private static void anadirEvento(ArrayList<Evento> eventos) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tipo de evento (Presencial u Online): ");
        String tipo = sc.nextLine();
        while (!tipo.equalsIgnoreCase("Presencial") && !tipo.equalsIgnoreCase("Online")) {
            System.out.println("Introduce un tipo de evento correcto (Presencial u Online)");
            tipo = sc.nextLine();
        }
        if (tipo.equalsIgnoreCase("Presencial")){
            System.out.println("Introduce el nombre del evento: ");
            String nombre = sc.nextLine();

            //Para pedir la fecha y hora del evento, he ido pidiendo poco a poco cada uno,
            //dia, mes, año y hora e implementandolos al final en una variable LocalDataTime
            System.out.println("Introduce la fecha del evento, año (Ej: 2024): ");
            int anio = sc.nextInt();
            System.out.println("Introduce el mes (1-12): ");
            int mes = sc.nextInt();
            while (mes > 12 || mes < 1) {
                System.out.println("Introduce un mes válido (1-12): ");
                mes = sc.nextInt();
            }
            System.out.println("Introduce el día");
            int dia = sc.nextInt();
            while(dia > 31 || dia < 1) {
                System.out.println("Introduce un día válido (1-31)");
                dia = sc.nextInt();
            }
            System.out.println("Introduce la hora (0-23)");
            int hora = sc.nextInt();
            while (hora < 0 || hora > 23) {
                System.out.println("Introduce una hora válida (0-23): ");
                hora = sc.nextInt();
            }
            System.out.println("Introduce los minutos (0-60): ");
            int mins = sc.nextInt();
            while(mins > 60 || mins < 0){
                System.out.println("Introduce minutos válidos (0-60): ");
                mins = sc.nextInt();
            }
            //Para juntar la fecha y la hora en una variable LocalDateTime:
            LocalDateTime fechaHora = LocalDateTime.of(anio, mes, dia, hora, mins);

            System.out.println("Introduce el aula del evento: ");
            sc.nextLine();
            String aula = sc.nextLine();

            EventoPresencial eventoPresencial = new EventoPresencial(nombre, fechaHora, aula);
            eventos.add(eventoPresencial);

            System.out.println("Evento presencial creado correctamente!!");
        } else if (tipo.equalsIgnoreCase("Online")) {

            System.out.println("Introduce el nombre del evento: ");
            String nombre = sc.nextLine();

            System.out.println("Introduce la fecha del evento, año (Ej: 2024): ");
            int anio = sc.nextInt();
            System.out.println("Introduce el mes (1-12): ");
            int mes = sc.nextInt();

            while (mes > 12 || mes < 1) {
                System.out.println("Introduce un mes válido (1-12): ");
                mes = sc.nextInt();
            }
            System.out.println("Introduce el día");
            int dia = sc.nextInt();
            System.out.println("Introduce la hora (0-23)");
            int hora = sc.nextInt();
            while (hora < 0 || hora > 23) {
                System.out.println("Introduce una hora válida (0-23): ");
                hora = sc.nextInt();
            }
            System.out.println("Introduce los minutos (0-60): ");
            int mins = sc.nextInt();
            while(mins > 60 || mins < 0){
                System.out.println("Introduce minutos válidos (0-60): ");
                mins = sc.nextInt();
            }

            LocalDateTime fechaHora = LocalDateTime.of(anio, mes, dia, hora, mins);

            System.out.println("Introduce la plataforma del evento: ");
            String plataforma = sc.nextLine();

            EventoOnline eventoOnline = new EventoOnline(nombre, fechaHora, plataforma);

            eventos.add(eventoOnline);

            System.out.println("Evento online creado correctamente!!");
        }
    }

}
