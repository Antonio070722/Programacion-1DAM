package Practica_final;

import java.time.LocalDateTime;

/**
 * Clase para crear eventos presenciales, hija de la clase Evento y con atributo propio 'aula'
 */
public class EventoPresencial extends Evento {
    String aula;
    //Atributo propio de la clase EventoPresencial

    /**
     * Constructor para crear un objeto de clase eventoPresencial, teniendo que pasarle el nombre, la fecha y hora en
     * formato LocalDateTime y el aula en el que se realizará el evento
     * @param nombre
     * @param fechaHora
     * @param aula
     */
    public EventoPresencial(String nombre, LocalDateTime fechaHora, String aula) {
        super(nombre, fechaHora);
        this.aula = aula;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    /**
     * Método de la interfaz mostrarInfo sobreescrito para mostrar la información del evento junto a si es futuro o no
     */
    @Override
    public void mostrarInfo() {
        System.out.println("--Evento Presencial--");
        System.out.println("\tNombre: " + super.nombre);
        System.out.println("\tFecha y Hora: " + super.fechaHora);
        System.out.println("\tAula: " + this.aula);

        if (esFuturo()) {
            System.out.println("\tEvento futuro.");
        } else {
            System.out.println("\tEvento pasado.");
        }
    }

    @Override
    public String toString() {
        return " ";
    }
}
