package Practica_final;

import java.time.LocalDateTime;

/**
 * Clase abstracta padre de EventoOnline y EventoPresencial
 * Aquí ya está implementada la interfaz mostrarInfo de forma que no haya que hacerlo en las hijas
 */
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

    /**
     * Método vacío mostrarInfo y un método boolean que devuelva true si el evento es opsterior a la fecha y hora actual
     */
    @Override
    public abstract void mostrarInfo();

    public boolean esFuturo(){
        return fechaHora.isAfter(LocalDateTime.now());
    }
}
