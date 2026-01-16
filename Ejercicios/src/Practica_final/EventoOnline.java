package Practica_final;

import java.time.LocalDateTime;

/**
 * Clase para crear eventos online, es hija de Evento e incluye un atributo propio 'plataforma'.
 */
public class EventoOnline extends Evento{

    String plataforma; //Atributo propio de la clase EventoOnline

    /**
     * Constructor para los objetos de tipo eventoOnline, teniendo que pasarle el nombre del evento, fecha y hora en
     * tipo LocalDataTime y la plataforma del evento.
     * @param nombre
     * @param fechaHora
     * @param plataforma
     */
    public EventoOnline(String nombre, LocalDateTime fechaHora, String plataforma) {
        super(nombre, fechaHora);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Método de la interfaz mostrarInfo sobreescrito para mostrar la información del evento junto a si es futuro o no
     */
    @Override
    public void mostrarInfo() {
        System.out.println("--Evento online--");
        System.out.println("\tNombre: " + super.nombre);
        System.out.println("\tFecha y Hora: " + super.fechaHora);
        System.out.println("\tPlataforma: " + this.plataforma);

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