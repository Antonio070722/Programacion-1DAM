package Practica_final;

public class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);//El mensaje a mostrar en caso de que se introduzca una contraseña no válida
    }
}
