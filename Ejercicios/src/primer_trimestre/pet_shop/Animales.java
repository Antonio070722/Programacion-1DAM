package primer_trimestre.pet_shop;

public class Animales {
    public SEXO sexo;
    public int edad;
    public String EAN;

    public Animales(SEXO sexo, int edad, String EAN){
        this.sexo=sexo;
        this.edad=edad;
        this.EAN=EAN;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (edad > 36500){
            throw new IllegalArgumentException("Edad no válida: "+edad+" días.");
        }
        this.edad = edad;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "sexo=" + sexo +
                ", edad=" + edad +
                ", EAN='" + EAN + '\'' +
                '}';
    }

public static boolean puedenReproducirse(Animales a1, Animales a2){
    // Las ratas de cebo para serpientes no pueden reproducirse.
    if (a1 instanceof Ratas_cebo_serpientes || a2 instanceof Ratas_cebo_serpientes){
        System.out.println("No se pueden reproducir. Las ratas no pueden reproducirse");
        return false;
    }
    // Deben ser de distinto sexo.
    if (a1.sexo==a2.sexo){
        System.out.println("No se pueden reproducir. Mismo sexo.");
        return false;
    }
    // Deben ser de la misma especie.
    if (a1.getClass() != a2.getClass()){
        System.out.println("No se pueden reproducir. Diferente especie.");
        return false;
    }
    // Deben haber alcanzado la madurez sexual (1 año = 365 días).
    if (a1.edad<365 || a2.edad<365){
        System.out.println("No se pueden reproducir. Alguno de los dos no ha alcanzado la madurez sexual.");
        return false;
    }
    // Si pasan todas las comprobaciones, pueden reproducirse.
    System.out.println("Pueden reproducirse.");
    return true;
    }
}
