package Practica_final;

import java.time.LocalDateTime;

public class EventoOnline extends Evento{

    String plataforma;

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
}