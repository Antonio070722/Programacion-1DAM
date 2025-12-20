package primer_trimestre.pet_shop;

public class Gato extends Mascotas{
    public String color;
    public String raza;
    public TIPO_PELO_GATO tipoPeloGato;
    public static final double precio_gato=50;


    public Gato(SEXO sexo, int edad, String EAN, String color, String raza, TIPO_PELO_GATO tipoPeloGato, int CHIP) {
        super(sexo, edad, EAN, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloGato = tipoPeloGato;
    }

    public Gato(SEXO sexo, int edad, String EAN, String color, String raza, TIPO_PELO_GATO tipoPeloGato, int CHIP, String nombreMascota) {
        super(sexo, edad, EAN, nombreMascota, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloGato = tipoPeloGato;
    }

    public Gato(SEXO sexo, int edad, String EAN, String color, String raza, TIPO_PELO_GATO tipoPeloGato, int CHIP, String nombreMascota, String nombreDueno, String apellidoDueno, String DNI) {
        super(sexo, edad, EAN, nombreMascota, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloGato = tipoPeloGato;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public TIPO_PELO_GATO getTipoPeloGato() {
        return tipoPeloGato;
    }

    public void setTipoPeloGato(TIPO_PELO_GATO tipoPeloGato) {
        this.tipoPeloGato = tipoPeloGato;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                ", tipoPeloGato=" + tipoPeloGato +
                ", CHIP=" + CHIP +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", apellidoDueno='" + apellidoDueno + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", EAN='" + EAN + '\'' +
                '}';
    }
}
