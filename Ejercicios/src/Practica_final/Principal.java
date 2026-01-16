package Practica_final;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase Principal, aquí, está el menú completo y los metodos correspondientes a cada opción de este, incluidos métodos
 * adicionales para funcionalidades necesarias como los métodos loginCorrecto o comprobarContraseña.
 */
public class Principal {
    /**
     * Main, en este he declarado el HashMap que almacena los nombres de usuarios y contraseñas, la ArrayList para
     * almacenar eventos y la validación de usuario y contraseña mediante el uso del método loginCorrecto y un do while,
     * de forma que se pedirá todo el rato un usuario y contraseña válido hasta 3 intentos, si no se introduce
     * un nombre de usuario y contraseña válido, cuando se acabe el número de intentos, el programa finaliza con
     * el mensaje 'Demasiados intentos fallidos'.
     * @param args
     */
    static void main(String[] args) throws PasswordDebilException {
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
     * Método para mostrar el menú del programa, solo se llega aquí una vez introducidas unas credeciales correctas;
     * aquí tienes que introducir un número del uno al siete correspondiente a la acción que se desea realizar,
     * el siete es el número que ejecuta la salida del programa.
     */
    public static void mostrarMenu(ArrayList<Evento> eventos, HashMap<String, String> usuarios, String usuario) throws PasswordDebilException {
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

    /**
     * Método que se ejecuta al poner el número 6 en el menú siendo admin, en caso de no serlo, se muestra el mensaje
     * 'Acceso denegado: solo admin puede crear usuarios', si el usuario logueado es admin, tiene que introducir
     * el nombre de usuario lo primero, después tiene que introducir una contraseña que es validada en un método llamado
     * comprobarContraseña, el método está dentro de un 'try', después del método (si devuelve true) se intenta
     * añadir el usuario y contraseña al hashmap que los almacena, y si esto es posible, muestra el
     * mensaje: Usuario añadido correctamente. En el caso de que alguno de esto falle, ya sea porque la contraseña
     * no cumple los requisitos (método comprobarContraseña devuelve false) o porque por algún motivo ha fallado
     * al añadir el nuevo usaurio al HashMap, pasa a 'catch' en el que muestra error, junto al mensaje de error generado
     * y el texto:  No se ha creado el usuario.
      * @param eventos
     * @param usuarios
     * @param usuario
     * @throws PasswordDebilException
     */
    private static void crearUsuario(ArrayList<Evento> eventos, HashMap<String, String> usuarios, String usuario) throws PasswordDebilException {
        Scanner sc = new Scanner(System.in);
        if (!usuario.equals("admin")) {
            System.out.println("Acceso denegado: solo admin puede crear usuarios.");

            mostrarMenu(eventos, usuarios, usuario);
        } else {
            System.out.println("Introduce el nombre del nuevo usuario");
            String nombre=sc.nextLine();
            System.out.println("Introduce la contraseña para el nuevo usuario");
            String password=sc.nextLine();

            try {
                comprobarContraseña(password);
                usuarios.put(usuario, password);
                System.out.println("Usuario añadido correctamente");
            }catch(PasswordDebilException e){
                System.out.println("Error:"+e.getMessage());
                System.out.println("No se ha creado el usuario");
            }
        }

    }

    /**
     * Este es el método que verifica que la contraseña que ha introducido el admin para el nuevo usuario cumpla con
     * los requisitos siguientes: longitud entre 8 y 12 caracteres; al menos una letra; ningún número; al menos
     * uno de estos signos: !@#$%&* Si no cumple alguno de estos requisitos lanza un PasswordException
     * con el mensaje correspondiente, devolviendo false al método que lo llamó, en caso contrario, como cumple todos
     * termina devolviendo true.
     * @param password
     * @return
     * @throws PasswordDebilException
     */
    private static boolean comprobarContraseña(String password) throws PasswordDebilException {
        if (password.length() < 8 || password.length() > 12) {
            throw new PasswordDebilException("La contraseña es menor a 8 caracteres o mayor a 12.");
        }

        if (!password.matches(".*[A-Za-z].*")){
            throw new PasswordDebilException("La contraseña debe contener al menos una letra");
        }

        if (password.matches(".*\\d.*")){
            throw new PasswordDebilException("La contraseña no puede contener números");
        }

        if (!password.matches(".*[!@#$%&*].*")){
            throw new PasswordDebilException("La contraseña debe contener al menos uno de estos signos: !@#$%&*");
        }

        return true;
    }

    /**
     * Método para borrar un evento, primero comprueba que hay eventos, si hay, muestra la lista de eventos disponibles
     * y pide el nombre de el evento que se desea borrar, este nombre lo comprueba con todos los eventos que hay,
     * si un nombre de evento coincide con el nombre de un evento, lo borra y muestra el mensaje 'Evento [nombre_evento]
     * borrado'.
     * @param eventos
     */
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

    /**
     * Método para mostrar los eventos que tienen asignada una fecha posterior a la actual, en el caso de que no haya
     * ningún evento creado, muestra el mensaje 'No se han encontrado eventos', en caso contrario, con un bucle
     * for-each, se recorren todos los eventos en busca de los que el método esFuturo devuelve true y se muestran.
     * @param eventos
     */
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

    /**
     * Método para listar todos los eventos, si nos hay eventos, se muestra el mensaje 'No se han encontrado eventos',
     * y si hay, mediante un bucle for-each que recorre todos los eventos, ejecutando el método mostrarInfo, que es
     * un @Override de la interfaz mostrarInfo.java
     * @param eventos
     */
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

    /**
     * Método para añadir un nuevo evento, lo primero que hace es pedir al usuario un tipo de evento, Presencial y online
     * en caso de que no introduzca ninguno de estos, sigue preguntando hasta que se introduzca alguno de los dos,
     * tras poner uno válido, se hace que, si es Presencial, que pida, el nombre del evento, la fecha y hora desglosada,
     * es decir pide primero el año, despues el mes, dia, hora y minuto, incluyendo validaciones para que se introduzcan
     * valores válidos (Ej: que no puedas poner un número de mes menor de 1 ni mayor de 12), una vez son introducidos
     * todos, se junta todo en un LocalDateTime, a continuación, pide el nombre o número de aula y crea un objeto de
     * clase eventoPresencial y lo añade a la Arraylist; en el caso de introducir online, el proceso es exactamente el
     * mismo con la diferencia de que no pide un aula, sino la plataforma del evento online y creando un objeto de
     * clase eventoOnline en vez de presencial.
     * @param eventos
     */
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
