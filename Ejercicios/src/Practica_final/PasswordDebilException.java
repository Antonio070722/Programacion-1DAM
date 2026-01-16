package Practica_final;

/**
 * Excepción personalizada para cuando a la hora de crear un usuario se introduce una contraseña que no cumple
 * los requisitos y por lo tanto cosiderada debil.
 */
public class PasswordDebilException extends Exception {
    public PasswordDebilException(String message) {
        super(message);//El mensaje a mostrar en caso de que se introduzca una contraseña no válida
    }
}
