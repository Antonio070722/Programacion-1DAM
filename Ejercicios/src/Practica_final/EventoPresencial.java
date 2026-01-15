package Practica_final;

import java.time.LocalDateTime;

public class EventoPresencial extends Evento {
    String aula;

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
}
