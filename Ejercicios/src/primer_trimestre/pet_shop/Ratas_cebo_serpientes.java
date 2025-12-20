package primer_trimestre.pet_shop;

public class Ratas_cebo_serpientes extends Animales{
    public int peso;//En gramos
    public int tamaño; //En cm
    public static final double  precioRata=2;

    public Ratas_cebo_serpientes(SEXO sexo, int edad, String EAN, int peso, int tamaño) {
        super(sexo, edad, EAN);
        this.peso=peso;
        this.tamaño=tamaño;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Ratas_cebo_serpientes{" +
                "peso=" + peso +
                ", tamaño=" + tamaño +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", EAN='" + EAN + '\'' +
                '}';
    }

    public boolean aptoVenta(){
        if (peso<200){
            System.out.println("La rata pesa menos de 200 gramos. No apta para venta.");
            return false;
        }
        if (tamaño<5){
            System.out.println("La rata mide menos de 5 centímetros. No apta para venta.");
            return false;
        }
        return true;
    }

}
