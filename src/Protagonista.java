import java.util.ArrayList;
import java.util.Scanner;

public class Protagonista extends Personaje {
    

    public Protagonista(String nb, int hp, int stamina, int combate, int defensa, int dinero, int suerte,
            int agilidad) {
        super(nb, hp, stamina, combate, defensa, dinero, suerte, agilidad);
        equipaArma();
    }

    public int tiraDado() {
        int resul = (int) (Math.random() * (6 - 1) + 1);
        return resul;
    }

    public boolean conHp(Personaje a) {
        if (a.getHp() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean conStamina(Personaje a) {
        if (a.getStamina() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void dejaKO(Personaje a, Personaje b){
        b.setStamina(b.getStamina()-5);

    }
    public void atacar(Personaje a, Personaje b) {
        
        if (conStamina(a) == true) {
            int dam = (a.getArmas().get(0).getDaño() + (a.getCombate() / 2) - b.getArmadura().get(0).getResistencia())+golpeCritico(a);
            

            if (a.getCombate() > b.getCombate()) {
                if (tiraDado() >= 3) {
                    if (dam!=a.getArmas().get(0).getDaño() + (a.getCombate() / 2) - b.getArmadura().get(0).getResistencia()){
                        System.out.println(a.getNombre()+ " hace un golpe crítico\n");
                    }
                    System.out.println(nombre + " golpea al enemigo con " + a.getArmas().get(0).getNombre()
                            + " y le quita " + dam + " puntos de vida\n");
                    b.setHp(b.getHp() - dam);
                    a.setStamina(a.getStamina() - 1);
                }
                else if (tiraDado() >= 2 && (a.getCombate() - b.getCombate() == 2)) {
                    if (dam!=a.getArmas().get(0).getDaño() + (a.getCombate() / 2) - b.getArmadura().get(0).getResistencia()){
                        System.out.println(a.getNombre()+ " hace un golpe crítico\n");
                    }
                    System.out.println(nombre + " golpea al enemigo con " + a.getArmas().get(0).getNombre()
                            + " y le quita " + dam + " puntos de vida\n");
                    b.setHp(b.getHp() - dam);
                    a.setStamina(a.getStamina() - 1);
                } else {
                    System.out.println(nombre + " falla el ataque y queda en ridículo\n");
                    a.setStamina(a.getStamina() - 1);
                }
            } else if (a.getCombate() == b.getCombate()) {
                if (tiraDado() >= 4) {
                    if (dam!=a.getArmas().get(0).getDaño() + (a.getCombate() / 2) - b.getArmadura().get(0).getResistencia()){
                        System.out.println(a.getNombre()+ " hace un golpe crítico");
                    }
                    System.out.println(nombre + " golpea al enemigo con " + a.getArmas().get(0).getNombre()
                            + " y le quita " + dam + " puntos de vida\n");
                    b.setHp(b.getHp() - dam);
                    a.setStamina(a.getStamina() - 1);
                } else {
                    System.out.println(nombre + " falla el ataque y queda en ridículo\n");
                    a.setStamina(a.getStamina() - 1);
                }
            } else {
                if (tiraDado() >= 5) {
                    System.out.println(nombre + " golpea al enemigo con " + a.getArmas().get(0).getNombre()
                            + " y le quita " + dam + " puntos de vida\n");
                    b.setHp(b.getHp() - dam);
                    a.setStamina(a.getStamina() - 1);
                } else {
                    System.out.println(nombre + " falla el ataque y queda en ridículo\n");
                    a.setStamina(a.getStamina() - 1);
                }
            }
        } else {
            System.out.println(nombre + " está demasiado cansado para atacar");

        }
    }
 
    public String verEsclavos() {
        return "ESCLAVO [nombre=" + nombre + ", hp=" + hp + ", stamina=" + stamina + ", combate=" + combate
                + ", defensa="
                + defensa + ", suerte=" + suerte + ", agilidad=" + agilidad + "]";
    }
    public int golpeCritico(Personaje a){
        int gc=(a.getSuerte()+a.getCombate())/3;
        int dado = (int) (Math.random() * (6 - 1) + 1)+(int) (Math.random() * (6 - 1) + 1);
        if (dado>=a.getSuerte()+1){
            
            return gc;
        }
        else{
            return 0;
 }
}
    @Override
    public void cambiarEquipo() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return" \n"+ nombre + " - HP: " + hp + " ";
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Personaje> getEsclavos() {
        return esclavos;
    }

    

}
