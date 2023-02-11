public class Arma {
    protected String nombre;
    protected int daño;
    public int num;
    public int valor;

    public Arma(String nombre, int daño, int num) {
        this.nombre = nombre;
        this.daño = daño;
        this.num=num;
        this.valor=creaValor();

    }
    public int creaValor(){
        int valor =this.daño*200;
        return valor;
    }
    public String getNombre() {
        return nombre;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public String toString() {
        return "\nArma "+num+" [nombre=" + nombre + ", daño=" + daño + ", valor= "+valor+"]";
    }

}
