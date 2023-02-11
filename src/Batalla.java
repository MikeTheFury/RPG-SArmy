import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Batalla {

    private Personaje p1;
    private Personaje p2;
    private int turno;
    private int botin;

    public Batalla(Personaje p1, Personaje p2, int turno, int botin) {
        this.p1 = p1;
        this.p2 = p2;
        this.turno = turno;
        this.botin = botin;

        this.librarBatalla();
        this.subirNivel(p1);

    }

    private void librarBatalla() {
        while (conHp(p1) == true && conHp(p2) == true && conStamina(p2) == true) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            boolean repetir = false;
        do {
            try {
            System.out.println("\nPulsa 1 para continuar, 2 para noquear al rival y  pulsa 0 para retirarte");
            Scanner tc = new Scanner(System.in);
            int n = tc.nextInt();
            if (n == 1) {
                if (p1.getAgilidad() > p2.getAgilidad()) {
                    p1.atacar(p1, p2);
                    p2.atacar(p2, p1);
                } else if (p2.getAgilidad() == p1.getAgilidad()) {
                    int resul = (int) (Math.random() * (6 - 1) + 1);
                    if (resul >= 4) {
                        p1.atacar(p1, p2);
                        p2.atacar(p2, p1);
                    } else {
                        p2.atacar(p2, p1);
                        p1.atacar(p1, p2);
                    }
                } else {
                    p2.atacar(p2, p1);
                    p1.atacar(p1, p2);
                }

            }
            else if (n==2){
                p2.setStamina(p2.getStamina()-5);
                p2.atacar(p2, p1);



            } else if (n==0){
                p1.setHp(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debe introducir el número 1 para que el campeonato continue");
            repetir = true;
        }
    } while (repetir == true);

        }
        if (conHp(p1) == true && conStamina(p1) == true) {
            System.out.println(p1.getNombre() + " gana");
            p1.setDinero(p1.getDinero() + p2.getDinero());
            System.out.println("Ganas " + p2.getDinero() + " monedas");
            System.out.println("Tienes " + p1.getDinero() + " monedas");
            if (conStamina(p2) == false) {
                System.out.println(p2.getNombre() + " HA CAÍDO DE AGOTAMIENTO\n");
                System.out.println("CAPTURASTE UN ESCLAVO\n");
                p1.anadeEsclavo(p2, p1);
                System.out.println(p1.getEsclavos().toString());
             

            } }else {
                System.out.println("Gana el comío " + p2.getNombre());
            }
            
        }
    

    public void subirNivel(Personaje a) {
        Scanner tc = new Scanner(System.in);
        System.out.println("\nSUBES DE NIVEL, ELIGE UNA MEJORA");
        System.out.println("\n1.SALUD");
        System.out.println("2.COMBATE");
        System.out.println("3.RESISTENCIA");
        System.out.println("4.AGILIDAD");
        System.out.println("5.SUERTE");
        int n = tc.nextInt();
        switch (n) {

            case 1:
                a.setHp(a.getHp() + 2);
                break;
            case 2:
                a.setCombate(a.getCombate() + 1);
                break;
            case 3:
                a.setStamina(a.getStamina() + 1);
                break;
            case 4:
                a.setAgilidad(a.getAgilidad() + 1);
                break;
            case 5:
                a.setSuerte(a.getSuerte() + 1);
                break;
        }
    }

    public Personaje getP1() {
        return p1;
    }

    public void setP1(Personaje p1) {
        this.p1 = p1;
    }

    public Personaje getP2() {
        return p2;
    }

    public void setP2(Personaje p2) {
        this.p2 = p2;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getBotin() {
        return botin;
    }

    public void setBotin(int botin) {
        this.botin = botin;
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

}