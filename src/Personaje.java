import java.util.ArrayList;

public abstract class Personaje {
    public ArrayList<Personaje> esclavos;
    protected String nombre;
    protected int hp;
    public int stamina;
    public int combate;
    public int defensa;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armadura;
    private int dinero;
    public int suerte;
    public int agilidad;
    public static int valor;

    public Personaje(String nb, int hp, int stamina, int combate, int defensa, int dinero, int suerte, int agilidad) {
        this.nombre = nb;
        this.hp = hp;
        this.stamina = stamina;
        this.combate = combate;
        this.defensa = defensa;
        this.armas = new ArrayList<>();
        this.armadura = new ArrayList<>();
        this.dinero = 100;
        this.suerte = suerte;
        this.agilidad = agilidad;
        this.esclavos = new ArrayList<>();
        this.valor=0;
        
            System.out.println(valor);


    }
    public int valorP(){
       int valor=10*(hp+stamina+combate+defensa+armas.get(0).getDaño()+armadura.get(0).getResistencia()+suerte+agilidad);
       System.out.println(valor);
       return valor;
    }
    public void equipaArma() {
        armas.add(new Arma("Espada", 4,0));
        armadura.add(new Armadura("Malla", 2, 2) {
        });
       
    }
    public void anadeEsclavo(Personaje a,Personaje b){
        b.esclavos.add(a);
    }

    public int getHp() {
        return hp;
    }

    public void setEsclavos(ArrayList<Personaje> esclavos) {
        this.esclavos = esclavos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getCombate() {
        return combate;
    }

    public void setCombate(int combate) {
        this.combate = combate;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    public ArrayList<Armadura> getArmadura() {
        return armadura;
    }

    public void setArmadura(ArrayList<Armadura> armadura) {
        this.armadura = armadura;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getSuerte() {
        return suerte;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public abstract void atacar(Personaje a, Personaje b);

    

    

   
    public abstract void cambiarEquipo();

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", hp=" + hp + ", stamina=" + stamina + ", combate=" + combate
                + ", defensa="
                + defensa + ", suerte=" + suerte + ", agilidad=" + agilidad + "]";
    }

    public String verEsclavos() {
        return "Personaje [nombre=" + nombre + ", hp=" + hp + ", stamina=" + stamina + ", combate=" + combate
                + ", defensa="
                + defensa + ", suerte=" + suerte + ", agilidad=" + agilidad + "]";
    }

    public ArrayList<Personaje> getEsclavos() {
        return esclavos;
    }

}