package primer_trimestre.pet_shop;

public class Mascotas extends Animales{
    int CHIP;
    String nombreMascota;
    String nombreDueno;
    String apellidoDueno;
    String DNI;

    /**
     * Constructor de las mascotas con: sexo, edad, EAN y CHIP
     * @param sexo
     * @param edad
     * @param EAN
     * @param CHIP
     */
    public Mascotas(SEXO sexo, int edad, String EAN, int CHIP){
        super(sexo, edad, EAN);
        this.CHIP=CHIP;
    }

    /**
     * Constructor con los datos del anterior constructor pero con la
     * opcion de añadir el nombre de la mascota
     * @param sexo
     * @param edad
     * @param EAN
     * @param nombreMascota
     * @param CHIP
     */
    public Mascotas(SEXO sexo, int edad, String EAN, String nombreMascota, int CHIP){
        super(sexo, edad, EAN);
        this.nombreMascota=nombreMascota;
        this.CHIP=CHIP;
    }


    public int getCHIP() {
        return CHIP;
    }

    public void setCHIP(int CHIP) {
        this.CHIP = CHIP;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Mascotas{" +
                "CHIP=" + CHIP +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", apellidoDueno='" + apellidoDueno + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", EAN='" + EAN + '\'' +
                '}';
    }

    /**
     * Método para asignar dueño a la mascota al venderla
     * @param nombreDueno
     * @param apellidoDueno
     * @param DNI
     */
    public void asignarDueno(String nombreDueno, String apellidoDueno, String DNI){
        this.nombreDueno=nombreDueno;
        this.apellidoDueno=apellidoDueno;
        this.DNI=DNI;
    }
}
