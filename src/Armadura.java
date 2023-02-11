public abstract class Armadura {
    private String nombre;
    private int resistencia;
    private int peso;

    public Armadura(String nombre, int resistencia, int peso) {
        this.nombre = nombre;
        this.resistencia = resistencia;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getPeso() {
        return peso;
    }

}