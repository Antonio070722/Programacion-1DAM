package primer_trimestre.Tema10.RECAP1EVAL;

public class Usuario {

    String nombreUsuario;
    long password;

    public Usuario(String nombreUsuario, long password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public boolean comprobarPassword(long passwordIntroducida){
//        if(password == passwordIntroducida){
//            return true;
//        }else return false;


        //LO DE ARRIBA ES LO MISMO QUE LO DE ABAJO, PERO ABAJO DE FORMA RESUMIDA


        return this.password == passwordIntroducida;
    }

}
