import java.util.Scanner;

public class Asalto {
    
    private int num;

    public Asalto( int num,Personaje a, Personaje b,Personaje c) {
        
        this.num = num;
        fase(a, b, c);
    }
    public static void fase(Personaje a, Personaje b,Personaje c){     
        Batalla b1 = new Batalla(a, b, 0, 0);    
        Batalla b2 = new Batalla(a, c, 0, 0);
       System.out.println("\nHas arrasado el pueblo, victoria para ti y tus abyectos aliados.\n");
     

    }
      

}