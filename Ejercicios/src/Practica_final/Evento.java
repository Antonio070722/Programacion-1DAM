package Practica_final;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Evento {
    protected String nombre;
    protected LocalDateTime fechaHora;

    public Evento(String nombre, LocalDateTime fechaHora) {
        this.nombre = nombre;
        this.fechaHora=fechaHora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFecha(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fechaHora +
                '}';
    }

    public boolean esFuturo(){
        return fechaHora.isAfter(LocalDateTime.now());
    }
}
