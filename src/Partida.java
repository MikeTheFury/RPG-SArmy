import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    private String nombre;
    private Protagonista prota;
    private ArrayList<Personaje> enemigo;
    private ArrayList<Arma> tienda;
    private ArrayList<Personaje> esclavos;
    private ArrayList<Batalla> misiones;
    private int nivel;

    public Partida(Protagonista prota) {

        this.nombre = creaPersonaje(prota);
        this.prota = prota;
        this.enemigo = enemigo;
        this.tienda = new ArrayList<>();
        this.esclavos = new ArrayList<>();
        this.nivel = 1;
        creaEsclavos();
        creaTienda();
        menuPrincipal();}
    public void menuPrincipal(){
       
        int n=1;
        Scanner tc=new Scanner(System.in);
       
        
        while (n!= 0){
            System.out.println("\nEstás en el campamento, ¿Qué quieres hacer, "+prota.getNombre()+"?");
        System.out.println("1.Atacar Pueblo");
        System.out.println("2.Curar heridas");    
        System.out.println("3.Tienda");            
        System.out.println("4.Mercado de Esclavos\n");
        n=tc.nextInt();
        switch (n) {
            case 1:
                Talla();
                break;
                case 2:
                curarPersonaje(prota);
                break;
                case 3:
                usaTienda();
                break;
                case 4:
                venderEsclavos(prota);
                break;
            default:
                break;

        }}
    }

    public String creaPersonaje(Protagonista a) {
        System.out.println("*************SLAVER ARMY*************");
        System.out.println("**************SP games***************");
        System.out.println(
                "\nBienvenido a Slaver Army, un juego cuyo único objetivo es hacer que todo el mundo que lo juegue se sienta miserable.");
        System.out.println("\nINTRODUCE TU NOMBRE:");
        Scanner tc = new Scanner(System.in);
        String nom = tc.nextLine();
        a.setNombre(nom);

        return nom;
    }
    public void Talla(){
    Protagonista ob2 = new Protagonista("Rafa el piedras", 30, 7, 3, 0, 100, 7, 5);
    Protagonista ob3 = new Protagonista("Kenshi Monedo", 30, 8, 4, 0, 100, 7, 5);
        Asalto a1=new Asalto( 1, prota, ob2, ob3);
        //Protagonista ob4 = new Protagonista("Tabique Nasal", 40, 9, 3, 0, 100, 7, 5);
        //Protagonista ob5 = new Protagonista("El Jupa", 40, 10, 4, 0, 100, 7, 5);
        //Asalto a2=new Asalto( 1, prota, ob4, ob5);
    }
    public void curarPersonaje(Protagonista a){
        a.setHp(30);
        System.out.println(a.getNombre()+" se ha curado por completo\n");

    }
    public void creaEsclavos() {
        
        String nombre[] = { "Raúl", "Ronaldo", "Guti", "Rafa", "Paco", "Marcos", "Johan", "Max", "Insulayah",
                "Evaristo", "Pepón", "Graham", "Thomas", "Ayrton", "Miguel", "Iker", "Vladimir", "Juan Carlos", "Curro",
                "El Bicho" };
        String apellido[] = { "Gómez", "Alonso", "El pernales", "Sánchez ", "Terredos", "Jackson", "Epstein", "Popeye",
                "Ibrahim", "Putin", "Pla", "Zubizarreta", "Thomas", "ben Sulayem", "Archuleta", "Zapatero", "Bush",
                "Nixon", "Reagan" };
        
        for (int i = 0; i < 9; i++) {
            int probap = (int) (Math.random() * apellido.length + 0);
            int probnom = (int) (Math.random() * nombre.length + 0);
            String n1 = nombre[probnom] + " " + apellido[probap];
            esclavos.add(new Protagonista(n1, probnom, probnom, probnom, probnom, probnom, probnom, probap));
        }  }     
        
        public static void venderEsclavos(Personaje a){
            if (a.esclavos.size()>0){
                System.out.println(a.esclavos.toString());
                System.out.println("Selecciona el numero del esclavo que quieres vender\n");
                Scanner tc=new Scanner(System.in);
                int n=tc.nextInt()-1;
                if(n+1<=a.esclavos.size()) { 
                  System.out.println("Has vendido a "+a.esclavos.get(n).getNombre() );
                    a.esclavos.remove(n);
                    a.setDinero(a.getDinero()+1000);
                    System.out.println("Tienes "+a.getDinero()+" monedas");}
                else{
                    System.out.println("no vendes a nadie\n");
                }  
             }
            else{
                System.out.println("No tienes esclavos para vender\n");
            }
            
        }
    
    
    
    public void creaTienda() {
       
        String nombre[] = { "Espada", "Hacha", "Lanza", "Katana", "Garrote", "Espadón", "Alabarda", "Martillo"};
        String apellido[] = { "Mágico", "Ígneo", "Afilado", "Bestial ", "Corta", "Larga", "Antigua", "LEGENDARIA",
                 };
        
        for (int i = 1; i < 15; i++) {
            int probap = (int) (Math.random() * apellido.length + 0);
            int probnom = (int) (Math.random() * nombre.length + 0);
            int fue = (int) (Math.random() * 10 + 2);

            String n1 = nombre[probnom] + " " + apellido[probap];
           tienda.add(new Arma(n1, fue ,i));
                
            }
                
            }
    public void usaTienda(){
        System.out.println(tienda.toString());
        System.out.println("pulsa el número del arma que quieras comprar,pulsa 0 para salir");
        Scanner tc=new Scanner(System.in);
        int n=tc.nextInt()-1;
        if (tienda.get(n).getValor()<=prota.getDinero()&& n>0){
            prota.setDinero(prota.getDinero()-tienda.get(n).getValor());
            prota.getArmas().add( tienda.get(n)) ;
            System.out.println("Compraste y equipaste"+tienda.get(n).getNombre());
            prota.getArmas().remove(0);
        }
        else{
            System.out.println("No tienes dinero");
        }
    }
        }        
    


