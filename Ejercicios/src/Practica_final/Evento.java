package Practica_final;

import java.time.LocalDateTime;

public abstract class Evento implements  mostrarInfo {
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
    public abstract void mostrarInfo();

    public boolean esFuturo(){
        return fechaHora.isAfter(LocalDateTime.now());
    }
}
