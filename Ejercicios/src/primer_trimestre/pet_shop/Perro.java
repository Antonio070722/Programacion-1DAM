package primer_trimestre.pet_shop;

public class Perro extends Mascotas{
    public String color;
    public String raza;
    public TIPO_PELO_PERRO tipoPeloPerro;
    public boolean peligree=false;
    public static final double PRECIO_SIN_PELIGREE=100;
    public static final double PRECIO_CON_PELIGREE=200;

    public Perro(SEXO sexo, int edad, String EAN, String color,  String raza, TIPO_PELO_PERRO tipoPeloPerro, boolean pedigree, int CHIP) {
        super(sexo, edad, EAN, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloPerro = tipoPeloPerro;
        this.peligree=pedigree;
    }

    public Perro(SEXO sexo, int edad, String EAN, String color,  String raza, TIPO_PELO_PERRO tipoPeloPerro, boolean pedigree, int CHIP, String nombreMascota) {
        super(sexo, edad, EAN, nombreMascota, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloPerro = tipoPeloPerro;
        this.peligree=pedigree;
    }

    public Perro(SEXO sexo, int edad, String EAN, String color,  String raza, TIPO_PELO_PERRO tipoPeloPerro, boolean pedigree, int CHIP, String nombreMascota, String nombreDueno, String apellidoDueno, String DNI) {
        super(sexo, edad, EAN, nombreMascota, CHIP);
        this.color = color;
        this.raza = raza;
        this.tipoPeloPerro = tipoPeloPerro;
        this.peligree=pedigree;
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

    public TIPO_PELO_PERRO getTipoPeloPerro() {
        return tipoPeloPerro;
    }

    public void setTipoPeloPerro(TIPO_PELO_PERRO tipoPeloPerro) {
        this.tipoPeloPerro = tipoPeloPerro;
    }

    public void getPedigree(boolean pedigree) {
        this.peligree = pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.peligree = pedigree;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                ", tipoPeloPerro=" + tipoPeloPerro +
                ", peligree=" + peligree +
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
